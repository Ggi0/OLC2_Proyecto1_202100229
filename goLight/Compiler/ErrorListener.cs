using Antlr4.Runtime;
using Antlr4.Runtime.Misc;

public class SemanticError : Exception
{
    private string message;
    private Antlr4.Runtime.IToken token;

    public SemanticError(string message, Antlr4.Runtime.IToken token){
        this.message = message;
        this.token = token;

    }

    public override string Message{
        get{
            Console.WriteLine(message + "en linea " + token.Line + ", columna " + token.Column);
            return message + "en linea " + token.Line + ", columna " + token.Column;
        }
    }
}


public class LexicoErrorListener : BaseErrorListener, IAntlrErrorListener<int>
{
    public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        Console.WriteLine($"Error léxico en línea {line}, columna {charPositionInLine}: {msg}");
        throw new ParseCanceledException($"Error léxico en línea {line}:{charPositionInLine} - {msg}");
    }

}


public class SintacticoErrorListener : BaseErrorListener
{
    public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        Console.WriteLine($"Error de sintaxis en línea {line}, columna {charPositionInLine}: {msg}");
        throw new ParseCanceledException($"Error sintáctico en línea {line}:{charPositionInLine} - {msg}");
    }
}