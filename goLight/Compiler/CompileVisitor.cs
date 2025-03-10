using System.Globalization;
using analyzer;
using Antlr4.Runtime.Misc;

/*
    El código a partir de tu gramática, se crean clases llamadas Context, 
    que representan los nodos del árbol sintáctico (AST).

    con:   Visit(context.expr())
    significa que se esta visitando el nodo hijo expr, 
    es decir, el nodo que representa la expresión dentro de otro nodo.

*/
public class CompilerVisitor : LanguageParserBaseVisitor<ValueWrapper>{ //<int> que valor devolver el hecho de recorrer el arbol 

    // un visit por cada NoTerminal

    // output ---> publica ya que se accedera desde el controlador
    public string output = "";
    private ValueWrapper defaultValue = new VoidValue();
    // declaraclando entorno
    private Entorno entornoActual = new Entorno(null); // entorno limpio cuando se inicializa el visitor


    /*
    Recorre todas las declaraciones
    */
    public override ValueWrapper VisitProgram( LanguageParser.ProgramContext context)
    {
        //context.dcl(); --> todas las declaraciones almacenadas en ese arreglo `program: dcl*;` de la gramatica
        foreach (var linea in context.dcl()){
            Visit(linea);
        }

        return defaultValue; // retorna un void
    }

    //       -----------> ENTORNOS <-----------
    public override ValueWrapper VisitBloque(LanguageParser.BloqueContext context)
    {
        Entorno entornoAnterior = entornoActual; // Guardar la referencia del entorno actual
        entornoActual = new Entorno(entornoAnterior); // el patre del nuevo entorno es el anterior

        // ejecutar todas las instrucciones dentro del entorno
        foreach (var stmt in context.dcl()){
            Visit(stmt);
        }

        entornoActual = entornoAnterior; // regresar al entorno previo
        return defaultValue;
    }

    // Instrucciones ---> VisitExpreStmt
    public override ValueWrapper VisitExprStmt( LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }


    //       -----------> DECLARACIONES <-----------
    /*
        caso 1: Declaración explícita con tipo y valor

        var <identificador> <Tipo> = <Expresión>
        VAR ID tiposD IGUAL expr SEMICOLON
    */ 
    public override ValueWrapper VisitVarDcl1(LanguageParser.VarDcl1Context context)
    {
        string id = context.ID().GetText(); // Obtiene el nombre de la variable (ID)
        string tipoVar = context.tiposD().GetText(); // Tipo de la variable en string
        ValueWrapper value = Visit(context.expr()); // Visita la expresión y obtiene su valor

        // Determinamos el tipo real del valor
        string tipoValor = value switch
        {
            IntValue => "int",
            FloatValue => "float64",
            StringValue => "string",
            BoolValue => "bool",
            RuneValue => "rune",
            _ => throw new Exception("ERROR: Tipo desconocido")
        };

        if (tipoVar == "float64" && tipoValor == "int"){
            // convertir el int a float64
            string excepcionFloat = context.expr().GetText();
            ValueWrapper valorConvertido = new FloatValue( float.Parse(excepcionFloat));
            entornoActual.DeclaracionVar(id, valorConvertido); 
            return defaultValue;
        }

        // Validamos que los tipos coincidan
        if (tipoVar != tipoValor)
        {
            throw new Exception($"ERROR: No se puede asignar un valor de tipo {tipoValor} a una variable de tipo {tipoVar}.");
        }

        // Si es válido, guardamos la variable en el entorno
        entornoActual.DeclaracionVar(id, value);

        return defaultValue; // una declaración no regresa ningun valor
    }

    /*
        caso 2: Declaración explícita con tipo y sin valor

        var <identificador> <Tipo>
        VAR ID tiposD SEMICOLON          # varDcl2
    */
    public override ValueWrapper VisitVarDcl2(LanguageParser.VarDcl2Context context)
    {
        string id = context.ID().GetText(); // Obtiene el nombre de la variable (ID)
        string tipo = context.tiposD().GetText(); // Tipo de la variable en string

        // asignar un valor por defecto según su tipo
        ValueWrapper value = tipo switch
        {
            "int" => new IntValue(0),
            "float64" => new FloatValue(0.0f),
            "string" => new StringValue(""),
            "bool" => new BoolValue(false),
            "rune" => new RuneValue('\0'),
            _ => throw new Exception("ERROR: Tipo desconocido"),
        };

        entornoActual.DeclaracionVar(id, value);

        return defaultValue; // una declaración no regresa ningun valor
    }

    /*
        caso 3: Declaración implícita infiriendo el tipo
        
        <identificador> := <Expresión>  
        ID DCLIMPL expr                  # varDcl3
    */
    public override ValueWrapper VisitVarDcl3( LanguageParser.VarDcl3Context context)
    {
        string id = context.ID().GetText(); // Obtiene el nombre de la variable
        ValueWrapper value = Visit(context.expr()); // Visita la expresión y obtiene su valor

        // Almacena la variable en el entorno
        entornoActual.DeclaracionVar(id, value); 

        return defaultValue; // una declaración no regresa ningun valor
    }




    //       -----------> ASIGNACIONES <-----------
    /*
        asignaciones VARIABLES
        Inmutabilidad del tipo: Una variable puede cambiar su valor, pero su tipo no puede ser modificado una vez declarado.
        Si una variable ya existe, su valor puede ser actualizado, pero el nuevo valor debe ser del mismo tipo que el original.
    */
    public override ValueWrapper VisitAssignVar(LanguageParser.AssignVarContext context)
    {
        // retornara lo asignado
        string id = context.ID().GetText(); // obtener nombre de la variable
        ValueWrapper value = Visit(context.expr());
        return entornoActual.AsignarVar(id, value);
    }





    // Identificador--> VisitIdentifier
    public override ValueWrapper VisitIdentifier( LanguageParser.IdentifierContext context)
    {
        // se debe ir a buscar a la tabla de simbolos
        string id = context.ID().GetText();
        
        // ENTORNOS
        return entornoActual.GetVariable(id);
    }

    // PARENTESIS --> VisitParens
    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }






    // VisitPrint ---> publica ya que se accedera desde el controlador
    public override ValueWrapper VisitPrintStmt( LanguageParser.PrintStmtContext context)
    {
        Console.WriteLine("Desde el print1: " + context.expr().GetText());
        Console.WriteLine("Desde el print1 (tipo) : " + context.expr().GetText().GetType());
        ValueWrapper value = Visit(context.expr());
        Console.WriteLine("Desde el print2: "+ value);
        Console.WriteLine("Desde el print2 (tipo): "+ value.GetType());
        // output += value + "\n";
        
        output += value switch
        {
            IntValue i => i.Value.ToString(),
            FloatValue f => f.Value.ToString(),
            StringValue s => s.Value,
            BoolValue b => b.Value.ToString(),
            RuneValue r => Convert.ToByte(r.Value).ToString(),
            VoidValue v => "void",
            _ => throw new Exception("Invalid value")
        };
        output += "\n";
        //Console.WriteLine("Desde el print2: "+ value.GetType());
        //Console.WriteLine("output --> : "+ output);

        return defaultValue;
    }




    //       -----------> OPERACIONES ARITMETICAS <-----------
    // Mult y division --> VisitMulDiv
    public override ValueWrapper VisitMulDiv(LanguageParser.MulDivContext context)
    {
        Console.WriteLine("--> multiplicacion - division");
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            (IntValue l, IntValue r, "*") => new IntValue(l.Value * r.Value),
            (IntValue l, IntValue r, "/") => new IntValue(l.Value / r.Value),
            _ => throw new Exception("ERROR: Operacion Invalida")
        };
    }


    // Suma y resta --> VisitAddSub
    public override ValueWrapper VisitAddSub(LanguageParser.AddSubContext context)
    {
        Console.WriteLine("--> suma - resta");
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            (IntValue l, IntValue r, "+") => new IntValue(l.Value + r.Value),
            (IntValue l, IntValue r, "-") => new IntValue(l.Value - r.Value),
            _ => throw new Exception("ERROR: Operacion Invalida")
        };
    }


    // Negación unitaria --> VisitNegateU
    public override ValueWrapper VisitNegateU(LanguageParser.NegateUContext context)
    {
        ValueWrapper value = Visit(context.expr());
        return value switch
        {
            IntValue i => new IntValue(-i.Value),
            _ => throw new Exception("Invalid operation")
        };
    }





    //       -----------> TIPO DE DATOS <-----------
    public override ValueWrapper VisitInt(LanguageParser.IntContext context)
    {
        return new IntValue(int.Parse(context.INT().GetText()));
    }

    public override ValueWrapper VisitFloat(LanguageParser.FloatContext context)
    {
        //Console.WriteLine("Desde el valor: " + context.FLOAT().GetText());
        return new FloatValue(float.Parse(context.FLOAT().GetText(), CultureInfo.InvariantCulture));    
    }

    public override ValueWrapper VisitBool(LanguageParser.BoolContext context)
    {
        return new BoolValue(bool.Parse(context.BOOL().GetText()));
    }

    public override ValueWrapper VisitString(LanguageParser.StringContext context)
    {
        Console.WriteLine("Desde el valor: " + context.STRING().GetText());
        string text = context.STRING().GetText();
        text = text[1..^1]; // Remueve las comillas

        // Procesar secuencias de escape
        text = ProcessEscapeSequences(text);

        return new StringValue(text);
    }

    public override ValueWrapper VisitRune(LanguageParser.RuneContext context)
    {
        Console.WriteLine("Desde el valor: " + context.RUNE().GetText());
        string text = context.RUNE().GetText();
        text = text[1..^1]; // Remueve las comillas

        // Procesar secuencias de escape en un solo carácter
        char runeValue = text.Length == 1 ? text[0] : ProcessEscapeChar(text);

        // VALIDAR ERROR  si la longitud es >1 y no es una secuencia de escape

        return new RuneValue(runeValue);
    }


    // Función para procesar secuencias de escape en cadenas
    private string ProcessEscapeSequences(string text)
    {
        return text.Replace("\\\"", "\"")
                .Replace("\\\\", "\\")
                .Replace("\\n", "\n")
                .Replace("\\r", "\r")
                .Replace("\\t", "\t");
    }

    // Función para procesar secuencias de escape en caracteres (runes)
    private char ProcessEscapeChar(string text)
    {
        return text switch
        {
            "\\n" => '\n',
            "\\t" => '\t',
            "\\r" => '\r',
            "\\'" => '\'',
            "\\\"" => '\"',
            "\\\\" => '\\',
            _ => text[0] // Si no es un escape, devolver el primer carácter normal
        };
    }

}



