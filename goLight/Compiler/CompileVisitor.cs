using analyzer;
using Antlr4.Runtime.Misc;

public class CompilerVisitor : LanguageParserBaseVisitor<int>{ //<int> que valor devolver el hecho de recorrer el arbol 

    // un visit por cada no terminal

    // VisitPrint ---> publica ya que se accedera desde el controlador
    public string output = "";

    // declaraclando entorno
    private Entorno entornoActual = new Entorno(); // entorno limpio cuando se inicializa el visitor


    // visitProgram
    public override int VisitProgram( LanguageParser.ProgramContext context)
    {
        //context.dcl(); // todas las declaraciones almacenadas en ese arreglo `program: dcl*;`
        foreach (var dcl in context.dcl()){
            Visit(dcl);
        }

        return 0;
    }

    // VisitVarDcl ---> declaracion de variables
    public override int VisitVarDcl( LanguageParser.VarDclContext context)
    {
        string id = context.ID().GetText();
        int value = Visit(context.expr());

        // implementacion de entornos --> almacenando la variable
        entornoActual.SetVariable(id, value);

        return 0; // una declaración no regresa ningun valor
    }

    // VisitExpreStmt
    public override int VisitExprStmt( LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }


    // VisitPrint ---> publica ya que se accedera desde el controlador
    public override int VisitPrintStmt( LanguageParser.PrintStmtContext context)
    {
        int value = Visit(context.expr());
        output += value + "\n";
        return 0;
    }

    // VisitIdentifier
    public override int VisitIdentifier( LanguageParser.IdentifierContext context)
    {
        // se debe ir a buscar a la tabla de simbolos
        string id = context.ID().GetText();
        
        // ENTORNOS
        return entornoActual.GetVariable(id);
    }




    // VisitParens --> parentesis
    public override int VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }

    // VisitNegate --> negación unitaria
    public override int VisitNegate( LanguageParser.NegateContext context)
    {
        return - Visit(context.expr());
    }

    public override int VisitNumber(LanguageParser.NumberContext context)
    {
      return int.Parse(context.GetText());
    }

    // visitMultDiv
    public override int VisitMulDiv(LanguageParser.MulDivContext context)
    {
        Console.WriteLine("Aplicando visitor");
        int left = Visit(context.expr(0));
        int right = Visit(context.expr(1));

        return context.op.Text == "*" ? left * right : left /right;
    }

    public override int VisitAddSub(LanguageParser.AddSubContext context)
    {
        int left = Visit(context.expr(0));
        int right = Visit(context.expr(1));

        return context.op.Text == "+" ? left + right : left -right;
    }

}