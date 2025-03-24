using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace api.Controllers
{
    [Route("[controller]")] 
    [ApiController] // <-- para validación automática de modelos
    public class Compile : ControllerBase // <-- Cambiado a ControllerBase
    {
        private readonly ILogger<Compile> _logger;

        public Compile(ILogger<Compile> logger)
        {
            _logger = logger;
        }
        

        public class CompileRequest
        {
            [Required]
            public required string Code { get; set; }
        }

        [HttpPost]
        public IActionResult Post([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Invalid request" });
            }

            var inputStream = new AntlrInputStream(request.Code);
            var lexer = new LanguageLexer(inputStream); // metodo viene de la gramatica

            // Para errores Sintacticos:
            lexer.RemoveErrorListeners();
            lexer.AddErrorListener(new LexicoErrorListener());

            var tokens = new CommonTokenStream(lexer);// tokens que se generaron a partir del lexer
            var parser = new LanguageParser(tokens);// parser regresa un contexto

            parser.RemoveErrorListeners();
            parser.AddErrorListener(new SintacticoErrorListener());





            /*
            ------- listener --------
            var walker = new ParseTreeWalker();
            var lister = new CompileListener(); //CompileListener() es el de CompilerListener
            walker.Walk(lister, tree);


            return Ok(new { result = lister.GetResult() });
            */
            // podemos recorrer el arbol con lisener o con visitor

            try
            {
                // Visitor
                var tree = parser.program();
                var visitor = new CompilerVisitor();
                visitor.Visit(tree);
                Console.WriteLine(" ~-~-~-~-~-~-~-~-~-~-~-~-> Compile <-~-~-~-~-~-~-~-~-~-~-~-~- ");

                return Ok(new { result = visitor.output });

            }
            catch (ParseCanceledException ex)
            {
                return BadRequest(new { error = ex.Message });
            }

            catch (SemanticError ex)
            {
                return BadRequest(new { error = ex.Message });
            }catch (ContinueException)
            {
                return BadRequest(new { error = "ERROR: sentencia Continue fuera de un ciclo" });
            }
        }

        [HttpPost("ast")]
        public async Task<IActionResult> GetAst([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Invalid Request" });
            }

            string parserGrammarPath = Path.Combine(Directory.GetCurrentDirectory(), "Gramatica/LanguageParser.g4");
            string lexerGrammarPath = Path.Combine(Directory.GetCurrentDirectory(), "Gramatica/LanguageLexer.g4");

            string parserGrammar = "";
            string lexerGrammar = "";

            try
            {
                if (System.IO.File.Exists(parserGrammarPath))
                {
                    parserGrammar = await System.IO.File.ReadAllTextAsync(parserGrammarPath);
                }
                else
                {
                    return BadRequest(new { error = "parser grammar not found" });
                }

                if (System.IO.File.Exists(lexerGrammarPath))
                {
                    lexerGrammar = await System.IO.File.ReadAllTextAsync(lexerGrammarPath);
                }
                else
                {
                    return BadRequest(new { error = "lexer grammar not found" });
                }
            }
            catch (System.Exception)
            {
                return BadRequest(new { error = "error reading grammar files" });
            }

            var payload = new
            {
                grammar = parserGrammar,
                lexgrammar = lexerGrammar,
                input = request.Code,
                start = "program"
            };

            var jsonPayload = JsonSerializer.Serialize(payload);
            var context = new StringContent(jsonPayload, Encoding.UTF8, "application/json");

            using (var client = new HttpClient())
            {
                try
                {
                    HttpResponseMessage response = await client.PostAsync("http://lab.antlr.org/parse/", context);
                    response.EnsureSuccessStatusCode();

                    string result = await response.Content.ReadAsStringAsync();

                    using var doc = JsonDocument.Parse(result);
                    var root = doc.RootElement;

                    if (root.TryGetProperty("result", out JsonElement resultElement) &&
                        resultElement.TryGetProperty("svgtree", out JsonElement svgtreeElement))
                    {
                        string svgtree = svgtreeElement.GetString() ?? string.Empty;
                        return Content(svgtree, "image/svg+xml");
                    }

                    return BadRequest(new { error = "svgtree not found in response" });
                }
                catch (System.Exception ex)
                {
                    _logger.LogError(ex, "Error parsing code");
                    return BadRequest(new { error = "Error parsing code" });
                }
            }
        }

    }
}