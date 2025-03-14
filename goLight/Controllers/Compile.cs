using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics;
using System.Linq;
using System.Net.Sockets;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;
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
        
        [HttpGet]
        public IActionResult Index()
        {
            return Ok("Compile API is running!");
        }

        [HttpGet("error")] // <-- Se define explícitamente para Swagger
        public IActionResult Error()
        {
            return Problem("An error occurred.");
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
            var tokens = new CommonTokenStream(lexer);// tokens que se generaron a partir del lexer
            var parser = new LanguageParser(tokens);// parser regresa un contexto
            
            var tree = parser.program();


            /*
            ------- listener --------
            var walker = new ParseTreeWalker();
            var lister = new CompileListener(); //CompileListener() es el de CompilerListener
            walker.Walk(lister, tree);


            return Ok(new { result = lister.GetResult() });
            */
            // podemos recorrer el arbol con lisener o con visitor

            try {
                // Visitor
            var visitor = new CompilerVisitor();
            visitor.Visit(tree);
            Console.WriteLine("Compile");

            return Ok(new{result = visitor.output});

            }catch(SemanticError ex){
                return BadRequest(new {error = ex.Message});
            }

            

            
        }
    }
}