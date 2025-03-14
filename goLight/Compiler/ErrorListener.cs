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