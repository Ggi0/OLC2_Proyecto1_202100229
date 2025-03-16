using System.Globalization;
using System.Linq.Expressions;
using System.Runtime.CompilerServices;
using System.Security.Cryptography.X509Certificates;
using analyzer;
using Antlr4.Runtime.Misc;
using Microsoft.AspNetCore.Razor.TagHelpers;

/*
    El código a partir de tu gramática, se crean clases llamadas Context, 
    que representan los nodos del árbol sintáctico (AST).

    con:   Visit(context.expr())
    significa que se esta visitando el nodo hijo expr, 
    es decir, el nodo que representa la expresión dentro de otro nodo.

     context.expr()        -> devuelve el nodo del árbol de sintaxis que representa la expresión condicional
     Visit(context.expr()) -> ejecuta el método Visit en ese nodo, lo que significa que evaluará la expresión y devolverá su resultado.

*/
public class CompilerVisitor : LanguageParserBaseVisitor<ValueWrapper>{ //<int> que valor devolver el hecho de recorrer el arbol 

    // un visit por cada NoTerminal

    // output ---> publica ya que se accedera desde el controlador
    public string output = "";
    private ValueWrapper defaultValue = new VoidValue();
    // declaraclando entorno
    private Entorno entornoActual; // entorno limpio cuando se inicializa el visitor

    // para funciones embebidas
    public CompilerVisitor(){
        entornoActual = new Entorno(null); // entorno Global
        Embebidas.Generate(entornoActual); // al entorno Gloabal se generan las embebidas.
    }


    /*
    Recorre todas las declaraciones
    */
    public override ValueWrapper VisitProgram( LanguageParser.ProgramContext context)
    {
        //context.dcl(); --> todas las declaraciones almacenadas en ese arreglo `program: dcl*;` de la gramatica
        foreach (var linea in context.dcl()){
            Console.WriteLine("\n\n -------------------------------------------------------------- \n\n");
            Visit(linea);
        }

        return defaultValue; // retorna un void
    }

    //       -----------> ENTORNOS <-----------
    public override ValueWrapper VisitBloque(LanguageParser.BloqueContext context)
    {
        Entorno entornoAnterior = entornoActual; // Guardar la referencia del entorno actual
        entornoActual = new Entorno(entornoAnterior); // el patre del nuevo entorno es el anterior

        Console.WriteLine("\n ---> nuevo Entorno <---");

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
        Console.WriteLine("\n--> Asignación c1");
        string id = context.ID().GetText(); // Obtiene el nombre de la variable (ID)
        string tipoVar = context.tiposD().GetText(); // Tipo de la variable en string
        //Console.WriteLine("\n Antes de visitar el contexto del valor");
        ValueWrapper value = Visit(context.expr()); // Visita la expresión y obtiene su valor
        //Console.WriteLine("\n Despues de visitar el contexto del valor");


        // Determinamos el tipo real del valor
        string tipoValor = value switch
        {
            IntValue => "int",
            FloatValue => "float64",
            StringValue => "string",
            BoolValue => "bool",
            RuneValue => "rune",
            _ => throw new SemanticError($"ERROR: Tipo del valor {value} es desconocido", context.Start)
        };

        //Console.WriteLine($" \t asignacion --> id: {id} tipo variable {tipoVar} --> valor: {value} valor tipo: {value.GetType()} tipoValor {tipoValor}<--");

        // Si la variable es float64 y el valor es int, hacemos conversión implícita
        if (tipoVar == "float64" && value is IntValue intValue)
        {
            value = new FloatValue(intValue.Value); // Convertir int a float64
            //Console.WriteLine($" \t asignacion --> id: {id} --> valor convertido: {value} <--");
        }

        // Validamos que los tipos coincidan
        if (tipoVar != tipoValor && !(tipoVar == "float64" && tipoValor == "int"))
        {
            throw new SemanticError($"ERROR: No se puede asignar un valor de tipo {tipoValor} a una variable de tipo {tipoVar}.", context.Start);
        }

        // Si es válido, guardamos la variable en el entorno
        Console.WriteLine($" \t asignacion --> id: {id} --> valor: {value} --> tipo: {value.GetType()} <--");
        entornoActual.DeclaracionVar(id, value, context.Start);

        return defaultValue; // una declaración no regresa ningun valor
    }

    /*
        caso 2: Declaración explícita con tipo y sin valor

        var <identificador> <Tipo>
        VAR ID tiposD SEMICOLON          # varDcl2
    */
    public override ValueWrapper VisitVarDcl2(LanguageParser.VarDcl2Context context)
    {
        Console.WriteLine("\n--> Asignación c2");
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
            _ => throw new SemanticError($"ERROR: el tipo: {tipo} es desconocido", context.Start),
        };

        Console.WriteLine($" \t asignacion --> id: {id} --> valor: {value} --> tipo: {value.GetType()} <--");
        entornoActual.DeclaracionVar(id, value, context.Start);

        return defaultValue; // una declaración no regresa ningun valor
    }

    /*
        caso 3: Declaración implícita infiriendo el tipo
        
        <identificador> := <Expresión>  
        ID DCLIMPL expr                  # varDcl3
    */
    public override ValueWrapper VisitVarDcl3( LanguageParser.VarDcl3Context context)
    {
        Console.WriteLine("\n--> Asignación c3");
        string id = context.ID().GetText(); // Obtiene el nombre de la variable
        ValueWrapper value = Visit(context.expr()); // Visita la expresión y obtiene su valor

        Console.WriteLine($" \t asignacion --> id: {id} --> valor: {value} --> tipo: {value.GetType()} <--");
        // Almacena la variable en el entorno
        entornoActual.DeclaracionVar(id, value, context.Start); 

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
        Console.WriteLine(context.expr());
        ValueWrapper value = Visit(context.expr()); // obtener el valor de la variable
       
        var op = context.op.Text;
        Console.WriteLine("---> operador asig: "+ op);
        
        /*if (value.Equals(null) && (!op.Equals("++") || !op.Equals("--")))
        {
            Console.WriteLine("el valor es nulo");
            throw new Exception($"ERROR: Para la asignacion {op} sea valida se le debe asignar un valor");
        }*/

        return entornoActual.AsignarVar(id, value, op, context.Start);
    }

    public override ValueWrapper VisitUpdateVar(LanguageParser.UpdateVarContext context)
    {
        // retornara lo asignado
        string id = context.ID().GetText(); // obtener nombre de la variable
        ValueWrapper value = new IntValue(1); // obtener el valor de la variable
       
        var op = context.op.Text;
        Console.WriteLine("---> op actualizador: "+ op);

        return entornoActual.AsignarVar(id, value, op, context.Start);
    }





    // Identificador--> VisitIdentifier
    public override ValueWrapper VisitIdentifier( LanguageParser.IdentifierContext context)
    {
        // se debe ir a buscar a la tabla de simbolos
        string id = context.ID().GetText();
        
        // ENTORNOS
        return entornoActual.GetVariable(id, context.Start);
    }

    // PARENTESIS --> VisitParens
    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }





    //       -----------> PRINTLN <-----------    
    // VisitPrint ---> publica ya que se accedera desde el controlador
    public override ValueWrapper VisitPrintStmt( LanguageParser.PrintStmtContext context)
    {
        Console.WriteLine("\n--> Println");
        //Console.WriteLine("Desde el print1: " + context.expr().GetText());
        //Console.WriteLine("Desde el print1 (tipo) : " + context.expr().GetText().GetType());
        ValueWrapper value = Visit(context.expr());
        Console.WriteLine("Desde el println: "+ value + "\n");
        //Console.WriteLine("Desde el print2 (tipo): "+ value.GetType());
        // output += value + "\n";
        
        output += value switch
        {
            IntValue i => i.Value.ToString(),
            FloatValue f => f.Value.ToString(),
            StringValue s => s.Value,
            BoolValue b => b.Value.ToString(),
            RuneValue r => Convert.ToByte(r.Value).ToString(),
            VoidValue v => "void",
            FuncionValue fn => "-> fn "+ fn.name + " <-",
            _ => throw new SemanticError("ERROR: tipo de valor no valido", context.Start)
        };
        output += "\n";
        //Console.WriteLine("Desde el print2: "+ value.GetType());
        //Console.WriteLine("output --> : "+ output);

        return defaultValue;
    }




    //       -----------> SENTENCIAS DE CONTROL DE FLUJO <-----------
    /*
        ---> IF
            La sentencia if-else permite ejecutar bloques de código dependiendo del resultado de unacondición. 

            var condicion = true

            if condicion {
                Bloque de sentencias para el if
            } else if condicion {
                Bloque de sentencias para el else if
            } else { 
                Bloque de sentencias para el else
            }
        
    */
    public override ValueWrapper VisitIfStatement( LanguageParser.IfStatementContext context)
    {
        Console.WriteLine("\t---> IF <---\n");

        ValueWrapper condition = Visit(context.expr()); // estamos obteniendo la condición del if

        // Validar que la condición siempre sea BOOLEANA
        if (condition is not BoolValue)
        {
            throw new SemanticError($"ERROR: la {condition} debe ser de tipo BOOLEANA", context.Start);
        }

        if ((condition as BoolValue).Value)
        {
            Console.WriteLine("-------> if (");
            Visit(context.statement(0));
            Console.WriteLine("------->    )");
        }
        else if (context.statement().Length > 1)
        {
            Console.WriteLine("-------> else - if (");
            Visit(context.statement(1));
            Console.WriteLine("------->           )");
        }

        return defaultValue;
    }



    /*
        ---> SWITCH
            La sentencia switch evalúa una expresión y ejecuta el bloque de declaraciones
            correspondiente al primer case que coincida en VALOR y TIPO. 

            statement: ...
                    | SWITCH expr LBRACE (caseStmt)+ RBRACE # SwitchStmt
            ;

            caseStmt: CASE expr COLON dcl*    # caseNormal
                    | DEFAUL COLON dcl*     # caseDefault
            ;

            switch <expresión> {                                          --> exprInput = Visit(context.expr(0))
                case valor1:                                              --> caseValor = Visit(context.expr(1))
                    // Declaraciones ejecutadas si <expresión> == valor1  --> Visit(context.dcl(0))

                case valor2:                                              --> caseValor = Visit(context.expr(2))
                    // Declaraciones ejecutadas si <expresión> == valor2  --> Visit(context.dcl(1))

                case valor_n:                                              --> caseValor = Visit(context.expr(n))
                    // Declaraciones ejecutadas si <expresión> == valor_n  --> Visit(context.dcl(n))

                default:
                    // Declaraciones ejecutadas si ningún caso coincide    --> Visit(context.dcl(n-1))
            } 
    */
    public override ValueWrapper VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
    {
        Console.WriteLine("\t---> SWITCH <---\n");

        Console.WriteLine("---- Estructura del SwitchStmtContext ----");
        //Console.WriteLine($"Número de expresiones: {context.expr().Length}");
        //Console.WriteLine($"Número total de dcl: {context.dcl().Length}");
        Console.WriteLine($"Número de casos: {context.caseStmt().Length}");

        Console.WriteLine("---- ------------------------------- ----");

        ValueWrapper exprInput = Visit(context.expr()); // obtener la expresion que se valuara en el switch
        string exprTipo = exprInput.GetType().Name;     // obtener el tipo de la expresion que se valua

        Console.WriteLine($"\t-> Expresion entrada  {exprInput} y tipo {exprTipo}");

        bool matchEncontrado = false; // Bandera para saber si se encontró un caso coincidente

        // Recorrer todos los casos
        foreach (var caseContext in context.caseStmt())
        {
            // Verificar si es un caso normal (tiene expresión para comparar)
            if (caseContext is LanguageParser.CaseNormalContext caseNormal)
            {
                // Obtener el valor del caso a comparar
                ValueWrapper caseValor = Visit(caseNormal.expr());
                string caseTipo = caseValor.GetType().Name;

                // Comparar el valor y tipo de la expresión de entrada con el caso
                if (exprTipo == caseTipo && exprInput.Equals(caseValor))
                {
                    Console.WriteLine($"\t -->Valor de entrada {exprInput} coincide con el caso {caseValor}");
                    matchEncontrado = true;

                    // Ejecutar todas las declaraciones dentro del caso
                    // Usamos VisitCaseNormal que procesará todas las declaraciones
                    Visit(caseNormal);

                    // Salir del switch (no hay "break" explícito en tu lenguaje)
                    return defaultValue;
                }
            }
        }

        // Si no se encontró coincidencia, buscar el caso default
        if (!matchEncontrado)
        {
            foreach (var caseContext in context.caseStmt())
            {
                if (caseContext is LanguageParser.CaseDefaultContext caseDefault)
                {
                    Console.WriteLine("\t-> Ejecutando bloque default...");

                    // Ejecutar todas las declaraciones del default
                    Visit(caseDefault);

                    break;
                }
            }
        }

        return defaultValue;
    }

    public override ValueWrapper VisitCaseNormal(LanguageParser.CaseNormalContext context)
    {
        Console.WriteLine("\t-> Ejecutando CASE normal --> nuevo entorno");
        // Crear un nuevo entorno para este caso
        Entorno entornoAnterior = entornoActual;
        entornoActual = new Entorno(entornoAnterior);

        // Ejecutar todas las declaraciones dentro del caso
        foreach (var declaracion in context.dcl())
        {
            Visit(declaracion);
        }

        // Restaurar el entorno anterior
        entornoActual = entornoAnterior;

        return defaultValue;
    }

    public override ValueWrapper VisitCaseDefault(LanguageParser.CaseDefaultContext context)
    {
        Console.WriteLine("\t-> Ejecutando caso DEFAULT --> nuevo entorno");

        // Crear un nuevo entorno para el default
        Entorno entornoAnterior = entornoActual;
        entornoActual = new Entorno(entornoAnterior);


        // Ejecutar todas las declaraciones dentro del caso default
        foreach (var declaracion in context.dcl())
        {
            Visit(declaracion);
        }

        // Restaurar el entorno anterior
        entornoActual = entornoAnterior;

        return defaultValue;
    }


    //       -----------> CICLOS <-----------
    /*
        --> FOR (while)
        
        for <condición> {
            // Bloque de sentencias
        }

        condicion -> debe de ser booleana

    */
    public override ValueWrapper VisitWhileStmt(LanguageParser.WhileStmtContext context)
    {
        Console.WriteLine("\t---> FOR (while) <---\n");
        ValueWrapper condition = Visit(context.expr());

        if (condition is not BoolValue)
        {
            throw new SemanticError($"ERROR: la condicion {condition} del For debe de ser booleana", context.Start);
        }

        while ((condition as BoolValue).Value)
        {
            Visit(context.statement());
            condition = Visit(context.expr());// valuar la condicion por cada iteracion
        }

        return defaultValue;
    }


    /*
        --> FOR

        for inicialización; condición; incremento {
            // Bloque de sentencias
        }

        inicializacion:  i := 1
        condicion  : i <= 5
        incremento : i++ o i--

    */
    public override ValueWrapper VisitForStmt( LanguageParser.ForStmtContext context)
    {
        // un nuevo entorno (contexto de variables) para la inicialización del for.
        Entorno entornoAnterior = entornoActual;      // Guardar la referencia del entorno actual
        entornoActual = new Entorno(entornoAnterior); // el patre del nuevo entorno es el anterior

        Visit(context.forInit()); // puede ser una declaración o una expresion (asignacion)

        // Ejecutar el cuerpo del FOR
        VisitForBody(context);

        entornoActual = entornoAnterior; // regresar al entorno previo (el que estaba antes de ejecutar el ciclo)
        return defaultValue;
    }

    public void VisitForBody(LanguageParser.ForStmtContext context){
        // 1) recorrer la condicion
        ValueWrapper condicion = Visit(context.expr(0)); // for inicialización; --> condición <---; incremento

        var UltimoEntorno = entornoActual; // Guardar la referencia del ultimo entorno donde se ejecuto

        // 2) Verifica que la condición sea de tipo BoolValue, ya que un for requiere una condición booleana.
        if (condicion is not BoolValue){ 
            throw new SemanticError($"ERROR: la condicion {condicion} debe ser de tipo booleana", context.Start);
        }

        // 3) ejecutar las instrucciones dentro del for mientras la condición sea true.
        try{ 
            while (condicion is BoolValue boolCondicion && boolCondicion.Value){
                Visit(context.statement());   // Ejecutar el cuerpo del for
                Visit(context.expr(1));       // Ejecutar la expresión de incremento
                condicion = Visit(context.expr(0)); // Reevaluar la condición --> ya que debe seguir siendo true
            }
        }catch(BreakException){
            // Si se encuentra un break, salir del ciclo y restaurar el entorno
            entornoActual = UltimoEntorno ; 
            
        }catch(ContinueException){
            // Si se encuentra un continue, restaurar el entorno y continuar con la siguiente iteración
            entornoActual = UltimoEntorno; // regresar al entorno actual
            Visit(context.expr(1)); // Ejecutar el incremento antes de continuar
            VisitForBody(context);  // Volver a ejecutar el cuerpo del for desde el inicio
        }


    }


    //       -----------> SENTENCIAS DE TRANSFERENCIA <-----------
    // --> BREAK
    public override ValueWrapper VisitST_break( LanguageParser.ST_breakContext context)
    {
        throw new BreakException();
    }

    // --> CONTINUE
    public override ValueWrapper VisitST_continue(LanguageParser.ST_continueContext context)
    {
        throw new ContinueException();
    }

    // --> RETURN
    public override ValueWrapper VisitST_return( LanguageParser.ST_returnContext context)
    {
        ValueWrapper value = defaultValue;

        // Lanza una ReturnException con el valor que se debe devolver.
        if(context.expr() != null){
            value = Visit(context.expr());
        }

        throw new ReturnException(value);
    }





    //       -----------> FUNCIONES <-----------

    /*
     ---> Funciones EMBEBIDAS:
          predefinidas en los lenguajes de programación que permiten realizar tareas comunes de manera eficiente.

        expr:
            | expr call+                   # Llamada
            ...                            ...
            | LPAREN expr RPAREN           # Parens
        ;

        call: LPAREN parametros? RPAREN
        ;

        parametros: expr (COMMA expr)*
        ;
    
    */
    public override ValueWrapper VisitLlamada(LanguageParser.LlamadaContext context)
    {
        ValueWrapper llamadaEmb = Visit(context.expr());

        // recorrer cada llamada:
        foreach (var llamada in context.call())
        {
            if (llamadaEmb is FuncionValue funtionValue)
            {
                llamadaEmb = VisitCall(funtionValue.invocable, llamada.parametros());
            }
            else
            {
                throw new SemanticError($"ERROR: la llamada es invalida {llamadaEmb}", context.Start);
            }
        }

        return llamadaEmb;
    }

    // call: LPAREN parametros? RPAREN
    public ValueWrapper VisitCall(Invocable invocable, LanguageParser.ParametrosContext context ){
        // definir una lista de argunmentos:
        List<ValueWrapper> argumetos = new List<ValueWrapper>();
        
        if (context != null){
            // si el contexto es diferente de nulo hay que recorrer todos los parametros ---> parametros?
            foreach(var expr in context.expr()){
                argumetos.Add(Visit(expr));
            }
        }

        // validar tipos

        // validar cantidad de parametros:
        if (context != null && argumetos.Count != invocable.Arity()){
            throw new SemanticError($"ERROR: La cantidad de parametros es invalida --> {argumetos}", context.Start);
        }

        return invocable.Invoke(argumetos, this);
    }





    //       -----------> OPERACIONES ARITMETICAS <-----------
    // Multiplicacion / division / modulo
    public override ValueWrapper VisitMulDiv(LanguageParser.MulDivContext context)
    {
        Console.WriteLine("---> multiplicacion - division - modulo");

        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        
        var op = context.op.Text;
        Console.WriteLine("---> operador: "+ op);

        switch (op)
        {
            case "*":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int * int = int
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} * valor der: {r.Value} - {r.GetType()}");
                        return new IntValue(l.Value * r.Value);

                    case (IntValue l, FloatValue r): // int * float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} * valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value * r.Value);

                    case (FloatValue l, FloatValue r): // float * float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} * valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value * r.Value);

                    case (FloatValue l, IntValue r): // float * int = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} * valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value * r.Value);

                    default:
                        throw new SemanticError($"ERROR: Multiplicación invalida entre los tipos {left.GetType()} * {right.GetType()} ", context.Start);
                }

            case "/":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int / int = int
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} / valor der: {r.Value} - {r.GetType()}");
                        if (r.Value == 0){
                            throw new SemanticError($"ERROR: Division indefinida el denominador {right} no puede ser 0.", context.Start);
                        }
                        return new IntValue(l.Value / r.Value);

                    case (IntValue l, FloatValue r): // int / float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} / valor der: {r.Value} - {r.GetType()}");
                        if (r.Value == 0.0f){
                            throw new SemanticError($"ERROR: Division indefinida el denominador {right} no puede ser 0.", context.Start);
                        }
                        return new FloatValue(l.Value / r.Value);

                    case (FloatValue l, FloatValue r): // float / float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} / valor der: {r.Value} - {r.GetType()}");
                        if (r.Value == 0.0f){
                            throw new SemanticError($"ERROR: Division indefinida el denominador {right} no puede ser 0.", context.Start);
                        }
                        return new FloatValue(l.Value / r.Value);

                    case (FloatValue l, IntValue r): // float / int = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} / valor der: {r.Value} - {r.GetType()}");
                        if (r.Value == 0){
                            throw new SemanticError($"ERROR: Division indefinida el denominador {right} no puede ser 0.", context.Start);
                        }
                        return new FloatValue(l.Value / r.Value);

                    default:
                        throw new SemanticError($"ERROR: Division invalida entre los tipos {left.GetType()} / {right.GetType()} ", context.Start);
                }
            case "%":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int % int = int
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} % valor der: {r.Value} - {r.GetType()}");
                        if (r.Value == 0){
                            throw new SemanticError($"ERROR: Modulo indefinido el denominador {right} no puede ser 0", context.Start);
                        }
                        return new IntValue(l.Value % r.Value);

                    default:
                        throw new SemanticError($"ERROR: Modulo invalido entre los tipos {left.GetType()} % {right.GetType()} ", context.Start);
                }

            default:
                throw new SemanticError($"ERROR: Operador {op} valido.", context.Start);
        }
    }


    // Suma y resta
    public override ValueWrapper VisitAddSub(LanguageParser.AddSubContext context)
    {
        Console.WriteLine("---> suma - resta");

        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        
        var op = context.op.Text;
        Console.WriteLine("---> operador: "+ op);

        switch (op)
        {
            case "+":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int + int = int
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} + valor der: {r.Value} - {r.GetType()}");
                        return new IntValue(l.Value + r.Value);

                    case (IntValue l, FloatValue r): // int + float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} + valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value + r.Value);

                    case (FloatValue l, FloatValue r): // float + float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} + valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value + r.Value);

                    case (FloatValue l, IntValue r): // float + int = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} + valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value + r.Value);

                    case (StringValue l, StringValue r): // string + string = string
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} + valor der: {r.Value} - {r.GetType()}");
                        return new StringValue(l.Value + r.Value);

                    default:
                        throw new SemanticError($"ERROR: Suma invalida entre los tipos {left.GetType()} + {right.GetType()} ", context.Start);
                }

            case "-":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int - int = int
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} - valor der: {r.Value} - {r.GetType()}");
                        return new IntValue(l.Value - r.Value);

                    case (IntValue l, FloatValue r): // int * float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} - valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value - r.Value);

                    case (FloatValue l, FloatValue r): // float - float = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} - valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value - r.Value);

                    case (FloatValue l, IntValue r): // float - int = float
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} - valor der: {r.Value} - {r.GetType()}");
                        return new FloatValue(l.Value - r.Value);

                    default:
                        throw new SemanticError($"ERROR: Resta invalida entre los tipos {left.GetType()} - {right.GetType()} ", context.Start);
                }

            default:
                throw new SemanticError($"ERROR: Operador {op} valido.", context.Start);
        }
    }



    // Negación unitaria 
    public override ValueWrapper VisitNegateU(LanguageParser.NegateUContext context)
    {
        ValueWrapper value = Visit(context.expr());
        var op = context.op.Text;
        Console.WriteLine("---> operador: " + op);

        switch (op)
        {
            case "-":
                switch (value)
                {
                    case IntValue i:
                        return new IntValue(-i.Value);
                    case FloatValue i:
                        return new FloatValue(-i.Value);
                    default:
                        throw new SemanticError($"ERROR: Negacion unitaria invalida para el valor de tipo: {value.GetType}", context.Start);
                }

            case "!":
                switch (value)
                {
                    case BoolValue i:
                        return new BoolValue(!i.Value);

                    default:
                        throw new SemanticError($"ERROR: Operador logico NOT invalido para el valor de tipo: {value.GetType}", context.Start);
                }
            default:
                throw new SemanticError($"ERROR: Operador {op} invalido en NEGACION.", context.Start);
        }


    }



    //       -----------> OPERACIONES DE COMPARACIÓN <-----------
    //  Igualdad y desigualdad
    public override ValueWrapper VisitComparation( LanguageParser.ComparationContext context)
    {
        Console.WriteLine("---> igualdad - desigualdad");

        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        
        var op = context.op.Text;
        Console.WriteLine("---> operador: "+ op);

        switch (op)
        {
            case "==":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int == int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} == valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value == r.Value);

                    case (IntValue l, FloatValue r): // int == float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} == valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value == r.Value);

                    case (FloatValue l, FloatValue r): // float == float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} == valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value == r.Value);

                    case (FloatValue l, IntValue r): // float == int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} == valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value == r.Value);

                    case (BoolValue l, BoolValue r): // bool == bool = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} == valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value == r.Value);

                    case (StringValue l, StringValue r): // string == string = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} == valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value == r.Value);

                    case (RuneValue l, RuneValue r): // rune == rune = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} == valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value == r.Value);

                    default:
                        throw new SemanticError($"ERROR: Comparacion de IGUALDAD invalida entre los tipos {left.GetType()} * {right.GetType()} ", context.Start);
                }

            case "!=":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int != int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} != valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value != r.Value);

                    case (IntValue l, FloatValue r): // int != float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} != valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value != r.Value);

                    case (FloatValue l, FloatValue r): // float != float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} != valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value != r.Value);

                    case (FloatValue l, IntValue r): // float != int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} != valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value != r.Value);

                    case (BoolValue l, BoolValue r): // bool != bool = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} != valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value != r.Value);

                    case (StringValue l, StringValue r): // string != string = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} != valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value != r.Value);

                    case (RuneValue l, RuneValue r): // rune != rune = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} != valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value != r.Value);

                    default:
                        throw new SemanticError($"ERROR: Comparacion de DESIGUALDAD invalida entre los tipos {left.GetType()} * {right.GetType()} ", context.Start);
                }
            default:
                throw new SemanticError($"ERROR: Operador {op} invalido en Comparacion.", context.Start);
        }

    }



    //       -----------> OPERACIONES RELACIONALES <-----------
    public override ValueWrapper VisitRelacionales(LanguageParser.RelacionalesContext context)
    {
        Console.WriteLine("---> mayor / mayorIgual - menor/ menorIgual");

        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        
        var op = context.op.Text;
        Console.WriteLine("---> operador: "+ op);
        
        
        switch (op)
        {
            case ">":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int > int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} > valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value > r.Value);

                    case (IntValue l, FloatValue r): // int > float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} > valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value > r.Value);

                    case (FloatValue l, FloatValue r): // float > float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} > valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value > r.Value);

                    case (FloatValue l, IntValue r): // float > int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} > valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value > r.Value);

                    case (RuneValue l, RuneValue r): // rune > rune = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} > valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value > r.Value);

                    default:
                        throw new SemanticError($"ERROR: Relacion MAYOR QUE invalida entre los tipos {left.GetType()} > {right.GetType()} ", context.Start);
                }
            
            case ">=":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int >= int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} >= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value >= r.Value);

                    case (IntValue l, FloatValue r): // int >= float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} >= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value >= r.Value);

                    case (FloatValue l, FloatValue r): // float >= float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} >= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value >= r.Value);

                    case (FloatValue l, IntValue r): // float >= int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} >= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value >= r.Value);

                    case (RuneValue l, RuneValue r): // rune >= rune = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} >= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value >= r.Value);

                    default:
                        throw new SemanticError($"ERROR: Relacion MAYOR O IGUAL invalida entre los tipos {left.GetType()} >= {right.GetType()} ", context.Start);
                }

            case "<":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int < int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} < valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value < r.Value);

                    case (IntValue l, FloatValue r): // int < float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} < valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value < r.Value);

                    case (FloatValue l, FloatValue r): // float < float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} < valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value < r.Value);

                    case (FloatValue l, IntValue r): // float < int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} < valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value < r.Value);

                    case (RuneValue l, RuneValue r): // rune < rune = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} < valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value < r.Value);

                    default:
                        throw new SemanticError($"ERROR: Relacion MENOR QUE invalida entre los tipos {left.GetType()} < {right.GetType()} ", context.Start);
                }
            
            case "<=":
                switch (left, right)
                {
                    case (IntValue l, IntValue r): // int <= int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} <= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value <= r.Value);

                    case (IntValue l, FloatValue r): // int <= float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} <= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value <= r.Value);

                    case (FloatValue l, FloatValue r): // float <= float = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} <= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value <= r.Value);

                    case (FloatValue l, IntValue r): // float <= int = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} <= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value <= r.Value);

                    case (RuneValue l, RuneValue r): // rune <= rune = bool
                        Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} <= valor der: {r.Value} - {r.GetType()}");
                        return new BoolValue(l.Value <= r.Value);

                    default:
                        throw new SemanticError($"ERROR: Relacion MENOR O IGUAL invalida entre los tipos {left.GetType()} <= {right.GetType()} ", context.Start);
                }
            default:
                throw new SemanticError($"ERROR: Operador {op} invalido en Comparacion.", context.Start);
        }
    }



    //       -----------> OPERACIONES LOGICAS <-----------
    // ---> And
    public override ValueWrapper VisitAnd(LanguageParser.AndContext context)
    {
        Console.WriteLine("---> AND ");

        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));

        switch (left, right)
        {
            case (BoolValue l, BoolValue r): // int && int = bool
                Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} && valor der: {r.Value} - {r.GetType()}");
                return new BoolValue(l.Value && r.Value);

            default:
                throw new SemanticError($"ERROR: Operador logico AND invalido entre los tipos {left.GetType()} && {right.GetType()} ", context.Start);
        }
    }

    // ---> OR
    public override ValueWrapper VisitOr(LanguageParser.OrContext context)
    {
        Console.WriteLine("---> OR ");

        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));

        switch (left, right)
        {
            case (BoolValue l, BoolValue r): // int || int = bool
                Console.WriteLine($"---> valor izq: {l.Value} - {l.GetType()} || valor der: {r.Value} - {r.GetType()}");
                return new BoolValue(l.Value || r.Value);

            default:
                throw new SemanticError($"ERROR: Operador logico OR invalido entre los tipos {left.GetType()} || {right.GetType()} ", context.Start);
        }

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
        //Console.WriteLine("Desde el valor: " + context.STRING().GetText());
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




    // Función para procesar SECUENCIAS DE ESCAPE en cadenas
    private string ProcessEscapeSequences(string text)
    {
        return text.Replace("\\\"", "\"")
                .Replace("\\\\", "\\")
                .Replace("\\n", "\n")
                .Replace("\\r", "\r")
                .Replace("\\t", "\t");
    }

    // Función para procesar SECUENCIAS DE ESCAPE en caracteres (runes)
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



