using System.Globalization;
using System.Linq.Expressions;
using System.Reflection.Metadata;
using System.Runtime;
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
    public ValueWrapper defaultValue = new VoidValue();
    // declaraclando entorno
    public Entorno entornoActual; // entorno limpio cuando se inicializa el visitor

    public static CompilerVisitor Instance { get; private set; }


    // para funciones embebidas
    public CompilerVisitor(){
        entornoActual = new Entorno(null); // entorno Global
        Embebidas.Generate(entornoActual); // al entorno Gloabal se generan las embebidas.

         // Establecer la instancia singleton
        Instance = this;
    }


    /*
    Recorre todas las declaraciones
    */
    public override ValueWrapper VisitProgram( LanguageParser.ProgramContext context)
    {
        /*//context.dcl(); --> todas las declaraciones almacenadas en ese arreglo `program: dcl*;` de la gramatica
        foreach (var linea in context.dcl()){
            Console.WriteLine("\n\n -------------------------------------------------------------- \n\n");
            Visit(linea);
        }

        return defaultValue; // retorna un void*/
         // Fase 1: Procesar todas las declaraciones
        Console.WriteLine("\n\n ------ FASE DE DECLARACIÓN ------\n\n");
        foreach (var linea in context.dcl()){
            Visit(linea);
        }
        
        // Fase 2: Ejecutar la función main
        Console.WriteLine("\n\n ------ EJECUCIÓN DEL PROGRAMA ------\n\n");
        try {
            // Obtener la función main del entorno global
            ValueWrapper mainFunc = entornoActual.Get("main", context.Start);
            
            // Verificar que sea una función
            if (mainFunc is FuncionValue funcionValue) {
                // Llamar a la función main sin argumentos
                List<ValueWrapper> args = new List<ValueWrapper>();
                
                // Usar el mismo mecanismo de invocación que ya tienes en VisitCall
                return funcionValue.invocable.Invoke(args, this, context.Start);
            } else {
                throw new SemanticError("ERROR: No se encontró la función 'main' o no es una función válida.", context.Start);
            }
        } catch (SemanticError e) {
            throw new SemanticError(e.Message, context.Start);
        } catch (Exception e) {
            Console.WriteLine($"ERROR: {e.Message}");
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
        entornoActual.Declaracion(id, value, context.Start);

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
        entornoActual.Declaracion(id, value, context.Start);

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
        entornoActual.Declaracion(id, value, context.Start); 

        return defaultValue; // una declaración no regresa ningun valor
    }

/*
--> para declaracion de variables tipo  structs t
    VAR ID ID SEMICOLON 
*/
public override ValueWrapper VisitVarDclStruct(LanguageParser.VarDclStructContext context) {
    string nombreVariable = context.ID(0).GetText(); // nombre de la variable a la cual se le pasara la referencia del struct
    string tipoStruct = context.ID(1).GetText();     // nombre del struct
    
    // Verificar si el tipo struct existe
    ValueWrapper tipoValor;
    try {
        tipoValor = entornoActual.Get(tipoStruct, context.Start);
    } catch (SemanticError) {
        throw new SemanticError($"ERROR: El struct '{tipoStruct}' no está definido", context.Start);
    }
    
    // Verificar que sea un struct (StructValue)
    if (!(tipoValor is StructValue structValue)) {
        throw new SemanticError($"ERROR: '{tipoStruct}' no es un struct", context.Start);
    }
    
    // Crear una instancia vacía del struct
    Dictionary<string, ValueWrapper> instanciaAtributos = new Dictionary<string, ValueWrapper>();
    
    // Inicializar los atributos con valores por defecto
    foreach (var atributo in structValue.Atributos) {
        string nombreAtributo = atributo.Key;
        string tipoAtributo = atributo.Value.Item1;
        bool esStruct = atributo.Value.Item2;
        
        if (!esStruct) {
            // Es un tipo primitivo
            ValueWrapper valorDefecto = tipoAtributo switch {
                "int" => new IntValue(0),
                "float64" => new FloatValue(0.0f),
                "string" => new StringValue(""),
                "bool" => new BoolValue(false),
                "rune" => new RuneValue('\0'),
                _ => defaultValue
            };
            
            instanciaAtributos.Add(nombreAtributo, valorDefecto);
        } else {
            // Es un struct, crear una instancia recursiva
            try {
                var otroTipoValor = entornoActual.Get(tipoAtributo, context.Start);
                if (otroTipoValor is StructValue otroStructValue) {
                    var otroStruct = CrearInstanciaStruct(otroStructValue, context.Start);
                    instanciaAtributos.Add(nombreAtributo, otroStruct);
                }
            } catch (SemanticError) {
                // Si hay error, usar valor por defecto
                instanciaAtributos.Add(nombreAtributo, defaultValue);
            }
        }
    }
    
    // Crear la instancia del struct
    InstanciaValue instanciaValue = new InstanciaValue(
        new Instancia(structValue.Nombre, instanciaAtributos)
    );
    
    // Declarar la variable en el entorno actual
    entornoActual.Declaracion(nombreVariable, instanciaValue, context.Start);
    
    return defaultValue;
}


// --> Método auxiliar para crear una instancia de un struct con valores por defecto
private InstanciaValue CrearInstanciaStruct(StructValue structValue, Antlr4.Runtime.IToken token) {
    // Diccionario para almacenar los valores de los atributos
    Dictionary<string, ValueWrapper> instanciaAtributos = new Dictionary<string, ValueWrapper>();
    
    // Inicializar cada atributo con su valor por defecto
    foreach (var atributo in structValue.Atributos) {
        string nombreAtributo = atributo.Key;
        string tipoAtributo = atributo.Value.Item1;
        bool esStruct = atributo.Value.Item2;
        bool esPuntero = atributo.Value.Item3;
        
        if (esPuntero) {
            // Si es un puntero, inicializar con nil
            instanciaAtributos.Add(nombreAtributo, new NilValue());
        } else if (!esStruct) {
            // Es un tipo primitivo, asignar valor por defecto
            ValueWrapper valorDefecto = tipoAtributo switch {
                "int" => new IntValue(0),
                "float64" => new FloatValue(0.0f),
                "string" => new StringValue(""),
                "bool" => new BoolValue(false),
                "rune" => new RuneValue('\0'),
                _ => defaultValue
            };
            
            instanciaAtributos.Add(nombreAtributo, valorDefecto);
        } else {
            // Es un struct, crear una instancia recursiva
            try {
                var otroTipoValor = entornoActual.Get(tipoAtributo, token);
                if (otroTipoValor is StructValue otroStructValue) {
                    // Llamada recursiva para crear instancia anidada
                    var otroStruct = CrearInstanciaStruct(otroStructValue, token);
                    instanciaAtributos.Add(nombreAtributo, otroStruct);
                } else {
                    // Si no es un struct, usar valor por defecto
                    instanciaAtributos.Add(nombreAtributo, defaultValue);
                }
            } catch (SemanticError) {
                // Si no existe, usar valor por defecto
                instanciaAtributos.Add(nombreAtributo, defaultValue);
            }
        }
    }
    
    // Crear y devolver la instancia del struct
    return new InstanciaValue(
        new Instancia(structValue.Nombre, instanciaAtributos)
    );
}

    //       -----------> ASIGNACIONES <-----------
    /*
        asignaciones VARIABLES
        Inmutabilidad del tipo: Una variable puede cambiar su valor, pero su tipo no puede ser modificado una vez declarado.
        Si una variable ya existe, su valor puede ser actualizado, pero el nuevo valor debe ser del mismo tipo que el original.

        
        expr op=(IGUAL | ASIGSUM | ASIGMIN) expr
        expr(0) --> en donde lo voy asignar (ID o llamada --> una llamada.context)
        expr(1) --> lo que voy asignar

    */
    public override ValueWrapper VisitAssignVar(LanguageParser.AssignVarContext context)
    {
        /*
        
        // retornara lo asignado
        string id = context.ID().GetText(); // obtener nombre de la variable
        Console.WriteLine(context.expr());
        ValueWrapper value = Visit(context.expr()); // obtener el valor de la variable

        */

        var asignee = context.expr(0);
        ValueWrapper value = Visit(context.expr(1));

        var op = context.op.Text;
        Console.WriteLine("---> operador asig: "+ op);

        // Caso 1: Asignación a un ID simple
        if (asignee is LanguageParser.IdentifierContext idContext){
            // ASIGNACION normal
            string id = idContext.ID().GetText();
            
            return entornoActual.Asignacion(id, value, op, context.Start); // retornar valor

        }
        // Caso 2: Asignación a un atributo (posiblemente anidado)
        else if (asignee is LanguageParser.LlamadaContext llamadaContext)
        {
            ValueWrapper llamadaEmb = Visit(llamadaContext.expr()); // lo primero que se debe resolver

            // Verificar que el resultado de la expresión no sea null
            if (llamadaEmb == null)
            {
                throw new SemanticError($"ERROR: La expresión de la llamada evaluó a null", context.Start);
            }

            // Recorrer cada llamada hasta la penúltima
            for (int i = 0; i<llamadaContext.call().Length; i++)
            {
                var action = llamadaContext.call(i);

                // verificar si estamos en la ultima interacion
                if (i == llamadaContext.call().Length - 1)
                {
                    if (action is LanguageParser.GetAtrContext porpertyAccess)
                    {
                        if (llamadaEmb is InstanciaValue instanciaValue)
                        {
                            var intancia = instanciaValue.instancia;
                            var propertyName = porpertyAccess.ID().GetText();
                            intancia.Set(propertyName, value); // guardar justo la ultima interacion del recorrido de acciones
                        }
                        else if (llamadaEmb is ModuleValue moduleValue)
                        {
                            // Esto indicará al usuario que el intento de hacer algo como strconv.Atoi = algovalor no está permitido
                            // No permitir asignación a funciones de módulos embebidos
                            throw new SemanticError($"ERROR: No es posible asignar valores a funciones de módulos embebidos como '{moduleValue.GetType().Name}'", context.Start);
                        }
                        else
                        {
                            throw new SemanticError($"ERROR: La INSTANCIACION es inválida. Se esperaba una función pero se recibió {llamadaEmb.GetType().Name}", context.Start);
                        }
                    }

                    // implementar el acceso a slice

                    else if (action is LanguageParser.AccesoSliceContext arraryAccess)
                    {
                        // la llamada debe ser una instancia que es lo que retorna una instancia de arreglo:
                        if (llamadaEmb is InstanciaValue instanciaValue)
                        {
                            var index = Visit(arraryAccess.expr());
                            // los indices deben ser unicamente numericos
                            if (index is IntValue intValue)
                            {
                                Console.WriteLine("ultimo valor  ", value);
                                instanciaValue.instancia.Set(intValue.Value.ToString(), value);
                            }
                            else
                            {
                                throw new SemanticError("ERROR: acesso invalido al slice por el tipo", context.Start);
                            }
                        }
                        else
                        {
                            throw new SemanticError("ERROR: accesos invalido al slice no es una instancia", context.Start);
                        }
                    }

                    else
                    {
                        throw new SemanticError($"ERROR: Asignacion invalida", context.Start);
                    }
                }

                // si es una llamada a funcion:
                if (action is LanguageParser.FuncCallContext funcall)
                {
                    if (llamadaEmb is FuncionValue funtionValue)
                    {
                        // esta parte no siempre van a ser parametros, sino tambien accesos a propiedades
                        llamadaEmb = VisitCall(funtionValue.invocable, funcall.parametros());
                        // Verificar que el resultado de la llamada no sea null
                        if (llamadaEmb == null)
                        {
                            throw new SemanticError($"ERROR: La llamada a la función {funtionValue.name} retornó null", context.Start);
                        }
                    }
                    else
                    {
                        throw new SemanticError($"ERROR: La llamada es inválida. Se esperaba una función pero se recibió {llamadaEmb.GetType().Name}", context.Start);
                    }

                }

                else if (action is LanguageParser.GetAtrContext porpertyAccess)
                {
                    if (llamadaEmb is InstanciaValue instanciaValue)
                    {
                        llamadaEmb = instanciaValue.instancia.Get(porpertyAccess.ID().GetText(), porpertyAccess.Start);
                    }
                    else if (llamadaEmb is ModuleValue moduleValue)
                    {
                        // Si es un módulo, obtener la función correspondiente
                        llamadaEmb = moduleValue.GetFunction(porpertyAccess.ID().GetText());
                    }
                    else
                    {
                        throw new SemanticError($"ERROR: La INSTANCIACION es inválida. Se esperaba una función pero se recibió {llamadaEmb.GetType().Name}", context.Start);
                    }
                }

                // implementar el acceso a slice --> si esta accion es un contexto de acceso a arreglos
                else if (action is LanguageParser.AccesoSliceContext arraryAccess){
                    // la llamada debe ser una instancia que es lo que retorna una instancia de arreglo:
                    if (llamadaEmb is InstanciaValue instanciaValue)
                    {
                        var index = Visit(arraryAccess.expr());
                        // los indices deben ser unicamente numericos
                        if (index is IntValue intValue){
                            llamadaEmb = instanciaValue.instancia.Get(intValue.Value.ToString(), arraryAccess.Start);
                        }else{
                            throw new SemanticError("ERROR: acesso invalido al slice por el tipo", context.Start);
                        }

                    }else{
                        throw new SemanticError("ERROR: accesos invalido al slice no es una instancia", context.Start);
                    }
                }

            }

            return llamadaEmb;

        }
        else
        {
            throw new SemanticError($"ERROR: asignacion invalida para {asignee.GetText} .", context.Start);
        }
        
       
        


        
        /*if (value.Equals(null) && (!op.Equals("++") || !op.Equals("--")))
        {
            Console.WriteLine("el valor es nulo");
            throw new Exception($"ERROR: Para la asignacion {op} sea valida se le debe asignar un valor");
        }*/

        //return entornoActual.Asignacion(id, value, op, context.Start);
    }

    public override ValueWrapper VisitUpdateVar(LanguageParser.UpdateVarContext context)
    {
        // retornara lo asignado
        string id = context.ID().GetText(); // obtener nombre de la variable
        ValueWrapper value = new IntValue(1); // obtener el valor de la variable
       
        var op = context.op.Text;
        Console.WriteLine("---> op actualizador: "+ op);

        return entornoActual.Asignacion(id, value, op, context.Start);
    }




  
    // Identificador--> VisitIdentifier
    public override ValueWrapper VisitIdentifier( LanguageParser.IdentifierContext context)
    {
        // se debe ir a buscar a la tabla de simbolos
        string id = context.ID().GetText();
        
        // Console.WriteLine($"DEBUG: Accediendo a variable '{id}'");

        // ENTORNOS
        return entornoActual.Get(id, context.Start);
    }

    // PARENTESIS --> VisitParens
    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }




    //       -----------> PRINTLN <-----------    
    // VisitPrint ---> publica ya que se accedera desde el controlador
    public override ValueWrapper VisitPrintStmt(LanguageParser.PrintStmtContext context)
    {
        Console.WriteLine("\n--> Print");

        string outputStr = "";

        // Si hay una lista de expresiones
        if (context.exprList() != null)
        {
            // Recorrer cada expresión en la lista
            foreach (var exprContext in context.exprList().expr())
            {
                ValueWrapper value = Visit(exprContext);

                // Convertir el valor a string según su tipo
                outputStr += value switch
                {
                    IntValue i => i.Value.ToString(),
                    FloatValue f => f.Value.ToString(),
                    StringValue s => s.Value,
                    BoolValue b => b.Value.ToString(),
                    RuneValue r => Convert.ToByte(r.Value).ToString(),
                    VoidValue v => "void",
                    FuncionValue fn => "-> fn " + fn.name + " <-",
                    StructValue st => st.Nombre,
                    InstanciaValue ins => FormatearInstancia(ins),
                    NilValue nulo => "<nil>",
                    _ => throw new SemanticError("ERROR: tipo de valor no valido", exprContext.Start)
                };
            }
        }

        output += outputStr + "\n";
        Console.WriteLine("output --> : " + output);

        return defaultValue;
    }




// Método auxiliar para formatear una instancia de struct como {valor1 valor2 valor3 ...}
private string FormatearInstancia(InstanciaValue instanciaValue)
{
    var instancia = instanciaValue.instancia;
    
    // Si es un slice, usar formato especial para slices
    if (instancia.GetTypeName().StartsWith("[]"))
    {
        return FormatearSlice(instanciaValue);
    }
    
    // Para structs normales, obtener todos los valores de atributos
    try
    {
        // Intentar obtener la definición del struct en el entorno actual
        ValueWrapper tipoValor = entornoActual.Get(instancia.GetTypeName(), null);
        
        if (tipoValor is StructValue structValue)
        {
            // Obtener los atributos en el orden definido en el struct
            var valores = new List<string>();
            
            // Para cada atributo definido en el struct
            foreach (var atributo in structValue.Atributos)
            {
                string nombreAtributo = atributo.Key;
                
                // Obtener el valor del atributo en la instancia
                if (instancia.values.TryGetValue(nombreAtributo, out ValueWrapper valor))
                {
                    // Convertir el valor a string según su tipo
                    string valorStr = valor switch
                    {
                        IntValue i => i.Value.ToString(),
                        FloatValue f => f.Value.ToString(),
                        StringValue s => s.Value,
                        BoolValue b => b.Value.ToString().ToLower(), // Usamos ToLower para que "True" se muestre como "true"
                        RuneValue r => r.Value.ToString(),
                        InstanciaValue nestedIns => FormatearInstancia(nestedIns), // Formateo recursivo para structs anidados
                        NilValue _ => "<nil>",
                        _ => "<valor desconocido>"
                    };
                    
                    valores.Add(valorStr);
                }
            }
            
            // Formatear como {valor1 valor2 valor3 ...}
            return "{" + string.Join(" ", valores) + "}";
        }
    }
    catch (SemanticError)
    {
        // Si hay algún error, simplemente devolver el tipo
    }
    
    // Si no podemos obtener los valores específicos, devolver solo el nombre del tipo
    return instancia.GetTypeName();
}

// Método auxiliar para formatear slices
private string FormatearSlice(InstanciaValue sliceInstancia)
{
    var instancia = sliceInstancia.instancia;
    
    // Obtener la longitud del slice
    if (!instancia.values.TryGetValue("length", out ValueWrapper lengthWrapper) || 
        !(lengthWrapper is IntValue lengthValue))
    {
        return instancia.GetTypeName(); // Si no podemos obtener la longitud, devolver solo el tipo
    }
    
    int length = lengthValue.Value;
    var elementos = new List<string>();
    
    // Recolectar todos los elementos del slice
    for (int i = 0; i < length; i++)
    {
        if (instancia.values.TryGetValue(i.ToString(), out ValueWrapper elemento))
        {
            // Convertir el elemento a string según su tipo
            string elementoStr = elemento switch
            {
                IntValue intVal => intVal.Value.ToString(),
                FloatValue floatVal => floatVal.Value.ToString(),
                StringValue strVal => strVal.Value,
                BoolValue boolVal => boolVal.Value.ToString().ToLower(),
                InstanciaValue nestedIns => FormatearInstancia(nestedIns), // Para slices anidados
                _ => "<valor desconocido>"
            };
            
            elementos.Add(elementoStr);
        }
    }
    
    // Formatear como [elemento1 elemento2 elemento3 ...]
    return "[" + string.Join(" ", elementos) + "]";
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

        try
        {
            // Ejecutar todas las declaraciones dentro del caso
            foreach (var declaracion in context.dcl())
            {
                try
                {
                    Visit(declaracion);
                }
                catch (BreakException)
                {
                    // Si se encuentra un break dentro de una declaración,
                    // interrumpir el bucle y salir del caso
                    Console.WriteLine("\t-> BREAK encontrado en CASE - saliendo del caso");
                    break;
                }
            }
        }
        finally
        {
            // Restaurar el entorno anterior
            entornoActual = entornoAnterior;
        }

        return defaultValue;
    }

    public override ValueWrapper VisitCaseDefault(LanguageParser.CaseDefaultContext context)
    {
        Console.WriteLine("\t-> Ejecutando caso DEFAULT --> nuevo entorno");

        // Crear un nuevo entorno para el default
        Entorno entornoAnterior = entornoActual;
        entornoActual = new Entorno(entornoAnterior);


        try
        {
            // Ejecutar todas las declaraciones dentro del caso default
            foreach (var declaracion in context.dcl())
            {
                try
                {
                    Visit(declaracion);
                }
                catch (BreakException)
                {
                    // Si se encuentra un break dentro de una declaración,
                    // interrumpir el bucle y salir del caso default
                    Console.WriteLine("\t-> BREAK encontrado en DEFAULT - saliendo del caso");
                    break;
                }
            }
        }
        finally
        {
            // Restaurar el entorno anterior
            entornoActual = entornoAnterior;
        }

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
    
    // 1. Crear un nuevo entorno para el ciclo for while
    Entorno entornoAnterior = entornoActual;
    entornoActual = new Entorno(entornoAnterior);
    
    try
    {
        // 2. Evaluar la condición inicial
        VisitWhileBody(context);
    }
    finally
    {
        // 3. Restaurar el entorno anterior al finalizar
        entornoActual = entornoAnterior;
    }
    
    return defaultValue;
}

/*
 * VisitWhileBody - Método auxiliar para manejar la ejecución del cuerpo del while
 * 
 * Ejecuta el cuerpo del while y maneja las excepciones de break y continue.
 */
private void VisitWhileBody(LanguageParser.WhileStmtContext context)
{
    // 1. Evaluar la condición
    ValueWrapper condition = Visit(context.expr());
    
    // 2. Verificar que la condición sea booleana
    if (condition is not BoolValue)
    {
        throw new SemanticError($"ERROR: la condicion {condition} del For debe de ser booleana", context.Start);
    }
    
    // 3. Guardar referencia al entorno para manejar continue/break
    var ultimoEntorno = entornoActual;
    
    try
    {
        // 4. Ejecutar el ciclo mientras la condición sea verdadera
        while (condition is BoolValue boolCondition && boolCondition.Value)
        {
            try
            {
                // Ejecutar el cuerpo del while
                Visit(context.statement());
            }
            catch (ContinueException)
            {
                // Si se encuentra un continue, simplemente continuamos con la siguiente iteración
                // No hacemos nada especial aquí, solo capturas la excepción para evitar que suba más
            }
            
            // Reevaluar la condición para la siguiente iteración
            condition = Visit(context.expr());
        }
    }
    catch (BreakException)
    {
        // Si se encuentra un break, salir del ciclo
        // No hacemos nada específico, solo capturamos la excepción
    }
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

    /*
  VisitForRangeStmt - Implementa la funcionalidad del ciclo "for range" para slices
  
  Permite recorrer un slice obteniendo el índice y el valor de cada elemento.
  Sintaxis: for índice, valor := range slice { ... }
 */
public override ValueWrapper VisitForRangeStmt(LanguageParser.ForRangeStmtContext context)
{
    Console.WriteLine("\t---> FOR RANGE <---\n");
    
    // 1. Obtener los identificadores para el índice y el valor
    string idIndice = context.rangeStmt().ID(0).GetText();
    string idValor = context.rangeStmt().ID(1).GetText();
    
    // 2. Crear un nuevo entorno para el ciclo for ANTES de la evaluación
    // Este entorno es donde vivirán las variables de índice y valor
    Entorno entornoAnterior = entornoActual;
    entornoActual = new Entorno(entornoAnterior);
    
    // 3. Evaluar la expresión después de "range" (debe ser un slice)
    ValueWrapper sliceExpr = Visit(context.rangeStmt().expr());
    
    // 4. Verificar que la expresión evaluada sea un slice
    if (!(sliceExpr is InstanciaValue instanciaValue && 
          instanciaValue.instancia.GetTypeName().StartsWith("[]")))
    {
        // Restaurar el entorno si hay error
        entornoActual = entornoAnterior;
        throw new SemanticError(
            $"ERROR: La expresión después de 'range' debe ser un slice, se encontró '{sliceExpr.GetType().Name}'", 
            context.Start);
    }
    
    // 5. Obtener la instancia del slice y su tamaño
    var sliceInstancia = instanciaValue.instancia;
    int length = 0;
    
    // Obtener la longitud del slice (propiedad "length")
    if (sliceInstancia.values.ContainsKey("length"))
    {
        ValueWrapper lengthValue = sliceInstancia.values["length"];
        if (lengthValue is IntValue intLength)
        {
            length = intLength.Value;
        }
    }
    
    // 6. Obtener el tipo de elementos del slice para crear un valor inicial del tipo correcto
    string tipoSlice = sliceInstancia.GetTypeName();
    string tipoElemento = tipoSlice.Substring(2); // Remover "[]" para obtener el tipo base
    
    // Crear un valor inicial del tipo correcto
    ValueWrapper valorInicial;
    switch (tipoElemento)
    {
        case "int":
            valorInicial = new IntValue(0);
            break;
        case "float64":
            valorInicial = new FloatValue(0.0f);
            break;
        case "string":
            valorInicial = new StringValue("");
            break;
        case "bool":
            valorInicial = new BoolValue(false);
            break;
        case "rune":
            valorInicial = new RuneValue('\0');
            break;
        default:
            // Si es un tipo estructurado o no reconocido, usamos nil
            valorInicial = new NilValue();
            break;
    }
    
    // 7. Declarar las variables índice y valor UNA SOLA VEZ en el nuevo entorno
    // Inicializamos con valores por defecto del tipo correcto
    entornoActual.Declaracion(idIndice, new IntValue(0), context.Start);
    entornoActual.Declaracion(idValor, valorInicial, context.Start);
    
    // 8. Ejecutar el bucle
    try 
    {
        for (int i = 0; i < length; i++)
        {
            string posicionKey = i.ToString();
            
            if (sliceInstancia.values.ContainsKey(posicionKey))
            {
                // Actualizar los valores usando Asignacion
                entornoActual.Asignacion(idIndice, new IntValue(i), "=", context.Start);
                entornoActual.Asignacion(idValor, sliceInstancia.values[posicionKey], "=", context.Start);
                
                // Ejecutar el cuerpo del for
                try {
                    Visit(context.statement());
                }
                catch (ContinueException)
                {
                    // Si encontramos un continue, simplemente continuamos con la siguiente iteración
                    continue;
                }
            }
        }
    }
    catch (BreakException)
    {
        // Si encontramos un break, simplemente salimos del bucle
        // No se hace nada específico aquí
    }
    
    // 9. Restaurar el entorno anterior
    entornoActual = entornoAnterior;
    
    return defaultValue;
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
        if (context.expr() != null)
        {
            value = Visit(context.expr());

            // Verificar que el valor no sea null
            if (value == null)
            {
                throw new SemanticError($"ERROR: El valor de retorno es nulo", context.Start);
            }
            //Console.WriteLine($"DEBUG: Valor de retorno: {value}"); // Añade este log para depuración
        }
        // Lanza una ReturnException con el valor que se debe devolver.
        throw new ReturnException(value);
    }





    //       -----------> STRUCTS <-----------
    /*
        ---> declaracion basica:
        
        type <NombreStruct> struct 
        { 
            <NombreAtributo1> <Tipo1>  
            <NombreAtributo2> <Tipo2> 
            <NombreAtributo3> <Tipo3> 
        }

        los tipos pueden ser:
            int, string, float64, bool, rune o struct

    */
public override ValueWrapper VisitStructDcl(LanguageParser.StructDclContext context) {
    Console.WriteLine($"Procesando declaración de struct: {context.ID().GetText()}");
    
    string nombreStruct = context.ID().GetText();

    // Verificar que el struct tenga al menos un atributo de lo contrario es un error
    if (context.atriBody().Length == 0) {
        throw new SemanticError($"Error: El struct '{context.ID().GetText()}' debe tener al menos un atributo", context.Start);
    }
    
    // Elementos necesarios para el struct
    Dictionary<string, (string, bool, bool)> atributos = new Dictionary<string, (string, bool, bool)>();
    
    // Recorrer los atributos del struct
    foreach (var atributo in context.atriBody()) {
        string nombreAtributo = atributo.ID(0).GetText(); // El primer ID es el nombre del atributo
        
        // Validar que el atributo no esté duplicado
        if (atributos.ContainsKey(nombreAtributo)) {
            throw new SemanticError($"ERROR: El atributo '{nombreAtributo}' ya está definido en el struct '{context.ID().GetText()}'", context.Start);
        }
        
        // Determinar el tipo y si es un struct
        string tipoAtributo;
        bool esStruct = false; // solo una bandera la validacion sera en el uso del mismo
        bool esPuntero = false;


            if (atributo.tiposD() != null)
            {
                // Es un tipo primitivo
                tipoAtributo = atributo.tiposD().GetText();
                esStruct = false;
                esPuntero = false;
            }
            else if (atributo.ID().Length > 1)
            { // si hay más de un ID en la regla
              // Es un ID (otro struct) ---> aquie no estoy validando que este id tenga ya el tipo Struct, unicamente lo estoy asumindo
                tipoAtributo = atributo.ID(1).GetText();
                esStruct = true;

                // Verificar si es un puntero al mismo struct (autorreferencia)
                if (tipoAtributo == nombreStruct)
                {
                    Console.WriteLine($"\t (struct) --> Detectado puntero autorreferenciado: {nombreAtributo} -> {tipoAtributo}");
                    esPuntero = true;
                }
                else
                {
                    // Verificar que exista y sea un struct
                    try
                    {
                        ValueWrapper tipoValor = entornoActual.Get(tipoAtributo, atributo.Start);
                        if (!(tipoValor is StructValue))
                        {
                            throw new SemanticError($"ERROR: El tipo '{tipoAtributo}' del atributo '{nombreAtributo}' debe ser un struct", atributo.Start);
                        }
                    }
                    catch (SemanticError)
                    {
                        // Si no existe, lanzar un error
                        throw new SemanticError($"ERROR: El tipo '{tipoAtributo}' del atributo '{nombreAtributo}' no está definido", atributo.Start);
                    }


                }

            }
            else
            {
                throw new SemanticError($"ERROR: No se pudo determinar el tipo del atributo '{nombreAtributo}'", atributo.Start);
            }

            Console.WriteLine($"\t (struct) -->  Atributo: {nombreAtributo}, Tipo: {tipoAtributo}, Es struct: {esStruct}, Es puntero: {esPuntero}");
        
        // Guardar el atributo
        atributos.Add(nombreAtributo, (tipoAtributo, esStruct, esPuntero));
    }
    
    // Crear el valor del struct
    StructValue structValue = new StructValue(context.ID().GetText(), atributos);
    
    // Registrar el struct en el entorno actual
    entornoActual.Declaracion(context.ID().GetText(), structValue, context.Start);
    
    Console.WriteLine($"Struct '{context.ID().GetText()}' declarado correctamente con {atributos.Count} atributos");
    
    return defaultValue;
}


// ----> para inicializarlos:

// Procesa la inicialización de un atributo con una expresión simple
public override ValueWrapper VisitInitAttrExpr(LanguageParser.InitAttrExprContext context) {
    // Obtener el nombre del atributo
    string nombreAtributo = context.ID().GetText();
    
    // Evaluar la expresión que define el valor
    ValueWrapper valorAtributo = Visit(context.expr());
    
    Console.WriteLine($"\t (struct) -> Inicializando atributo simple: {nombreAtributo} = {valorAtributo}");
    
    // Devolver un par (nombre, valor) para ser procesado por el inicializador de struct
    return new AtributoInicializacionValue(nombreAtributo, valorAtributo);
}


//  Procesa la inicialización de un atributo con un struct anidado
//  Ejemplo: Capital: Ciudad{ Nombre: "CDMX", Poblacion: 20000000 }
public override ValueWrapper VisitInitAttrStruct(LanguageParser.InitAttrStructContext context) {
    // Obtener el nombre del atributo y el tipo del struct
    string nombreAtributo = context.ID(0).GetText();
    string tipoStruct = context.ID(1).GetText();
    
    Console.WriteLine($"\t (struct) -> Inicializando atributo struct: {nombreAtributo} (tipo {tipoStruct})");
    
    // Verificar si el tipo struct existe en el entorno
    ValueWrapper tipoValor;
    try {
        tipoValor = entornoActual.Get(tipoStruct, context.Start);
    } catch (SemanticError) {
        throw new SemanticError($"ERROR: El struct '{tipoStruct}' no está definido", context.Start);
    }
    
    // Verificar que sea un struct (StructValue)
    if (!(tipoValor is StructValue structValue)) {
        throw new SemanticError($"ERROR: '{tipoStruct}' no es un struct", context.Start);
    }
    
    // Recolectar los valores de inicialización
    List<ValueWrapper> inicializaciones = new List<ValueWrapper>();
    
    foreach (var init in context.initAttrList().initAttr()) {
        ValueWrapper atributoInit = Visit(init);
        inicializaciones.Add(atributoInit);
    }
    
    // Crear una instancia del struct anidado
    InstanciaValue estructuraAnidada = CrearInstanciaConInicializaciones(structValue, inicializaciones, context.Start);
    
    // Devolver un par (nombre, valor) para ser procesado por el inicializador de struct principal
    return new AtributoInicializacionValue(nombreAtributo, estructuraAnidada);
}

/*
        | ID DCLIMPL ID LBRACE initAttr (COMMA initAttr)* RBRACE  # NewStructInit //manejará la inicialización con valores

*/
public override ValueWrapper VisitNewStructInit(LanguageParser.NewStructInitContext context) {
    // Obtener el nombre de la variable y el tipo del struct
    string nombreVariable = context.ID(0).GetText(); // Nombre de la variable
    string tipoStruct = context.ID(1).GetText();     // Nombre del tipo struct

        Console.WriteLine($"\t (struct) -> Inicializando struct '{tipoStruct}' en variable '{nombreVariable}'");

    
    // Verificar si el tipo struct existe en el entorno
    ValueWrapper tipoValor;
    try {
        tipoValor = entornoActual.Get(tipoStruct, context.Start);
    } catch (SemanticError) {
        // Si no existe, lanzar un error semántico
        throw new SemanticError($"ERROR: El struct '{tipoStruct}' no está definido", context.Start);
    }
    
    // Verificar que sea un struct (StructValue)
    if (!(tipoValor is StructValue structValue)) {
        throw new SemanticError($"'{tipoStruct}' no es un struct", context.Start);
    }

    // Recolectar todos los valores de inicialización
    List<ValueWrapper> inicializaciones = new List<ValueWrapper>();

    foreach (var init in context.initAttrList().initAttr()) {
        ValueWrapper atributoInit = Visit(init);
        inicializaciones.Add(atributoInit);
    }

    // Crear la instancia con las inicializaciones
    InstanciaValue instanciaValue = CrearInstanciaConInicializaciones(structValue, inicializaciones, context.Start);
    
    // Declarar o asignar la variable en el entorno actual
    if (entornoActual.variables.ContainsKey(nombreVariable)) {
        // Si la variable ya existe, actualizamos su valor
        entornoActual.Asignacion(nombreVariable, instanciaValue, "=", context.Start);
    } else {
        // Si no existe, creamos una nueva declaración
        entornoActual.Declaracion(nombreVariable, instanciaValue, context.Start);
    }
    
    Console.WriteLine($"Struct '{tipoStruct}' inicializado correctamente en variable '{nombreVariable}'");
    
    return instanciaValue;


}

/*
 Crea una instancia de struct a partir de una lista de inicializaciones

 "structValue"      --> Definición del struct
 "inicializaciones" --> Lista de inicializaciones (AtributoInicializacionValue)

regresa --> Instancia del struct inicializada
*/
private InstanciaValue CrearInstanciaConInicializaciones(StructValue structValue, List<ValueWrapper> inicializaciones,  Antlr4.Runtime.IToken token) {
    Console.WriteLine($"\t (struct) -> Creando instancia de struct '{structValue.Nombre}' con {inicializaciones.Count} inicializaciones");
    
    // Crear un diccionario para almacenar los valores de los atributos
    Dictionary<string, ValueWrapper> instanciaAtributos = new Dictionary<string, ValueWrapper>();
    
    // PASO 1: Inicializar todos los atributos con valores por defecto
    foreach (var atributo in structValue.Atributos) {
        string nombreAtributo = atributo.Key;
        string tipoAtributo = atributo.Value.Item1;
        bool esStruct = atributo.Value.Item2;
        bool esPuntero = atributo.Value.Item3;

        
        Console.WriteLine($"\t (struct) -> Inicializando por defecto: {nombreAtributo} (tipo {tipoAtributo})");
        
        if (esPuntero) {
            // Si es un puntero, inicializar con nil
            instanciaAtributos.Add(nombreAtributo, new NilValue());
        } else if (!esStruct) {
            // Es un tipo primitivo, asignar valor por defecto
            ValueWrapper valorDefecto = tipoAtributo switch {
                "int" => new IntValue(0),
                "float64" => new FloatValue(0.0f),
                "string" => new StringValue(""),
                "bool" => new BoolValue(false),
                "rune" => new RuneValue('\0'),
                _ => defaultValue
            };
            
            instanciaAtributos.Add(nombreAtributo, valorDefecto);
        } else {
            // Es un struct, crear una instancia recursiva vacía
            try {
                var otroTipoValor = entornoActual.Get(tipoAtributo, token);
                if (otroTipoValor is StructValue otroStructValue) {
                    // Crear instancia recursiva
                    var otroStruct = CrearInstanciaStruct(otroStructValue, token);
                    instanciaAtributos.Add(nombreAtributo, otroStruct);
                }else {
                    instanciaAtributos.Add(nombreAtributo, defaultValue);
                }
            } catch (SemanticError) {
                // Si hay error, usar valor por defecto
                instanciaAtributos.Add(nombreAtributo, defaultValue);
            }
        }
    }
    
    // PASO 2: Sobrescribir con los valores proporcionados en las inicializaciones
    foreach (var init in inicializaciones) {
        if (init is AtributoInicializacionValue atributoInit) {
            string nombreAtributo = atributoInit.Nombre;
            ValueWrapper valorAtributo = atributoInit.Valor;
            
            Console.WriteLine($"\t (struct) -> Sobrescribiendo: {nombreAtributo} con valor personalizado");
            
            // Verificar si el atributo existe en el struct
            if (!structValue.Atributos.ContainsKey(nombreAtributo)) {
                throw new SemanticError($"ERROR: El atributo '{nombreAtributo}' no existe en el struct '{structValue.Nombre}'", token);
            }
            
            // Verificar compatibilidad de tipos
            string tipoAtributo = structValue.Atributos[nombreAtributo].Item1;
            bool esStruct = structValue.Atributos[nombreAtributo].Item2;
            bool esPuntero = structValue.Atributos[nombreAtributo].Item3;

            
            if (esPuntero) {
                // Si es un puntero, puede ser nil o una referencia a otro struct del mismo tipo
                if (valorAtributo is NilValue) {
                    // Es válido asignar nil a un puntero
                } else if (valorAtributo is InstanciaValue instanciaVal) {
                    // Verificar que sea del tipo correcto
                    if (instanciaVal.instancia.GetTypeName() != tipoAtributo) {
                        throw new SemanticError($"ERROR: No se puede asignar una instancia de tipo '{instanciaVal.instancia.GetTypeName()}' al puntero '{nombreAtributo}' que espera tipo '{tipoAtributo}'", token);
                    }
                } else {
                    throw new SemanticError($"ERROR: No se puede asignar un valor de tipo {valorAtributo.GetType().Name} al puntero '{nombreAtributo}' que espera tipo '{tipoAtributo}' o nil", token);
                }
            } else if (!esStruct) {
                // Es un tipo primitivo, verificar compatibilidad
                bool compatible = false;
                
                switch (tipoAtributo) {
                    case "int":
                        compatible = valorAtributo is IntValue;
                        break;
                    case "float64":
                        compatible = valorAtributo is FloatValue || valorAtributo is IntValue;
                        break;
                    case "string":
                        compatible = valorAtributo is StringValue;
                        break;
                    case "bool":
                        compatible = valorAtributo is BoolValue;
                        break;
                    case "rune":
                        compatible = valorAtributo is RuneValue;
                        break;
                }
                
                if (!compatible) {
                    throw new SemanticError($"ERROR: No se puede asignar un valor de tipo {valorAtributo.GetType().Name} al atributo '{nombreAtributo}' de tipo '{tipoAtributo}'", token);
                }
                
                // Realizar conversión implícita si es necesario (int -> float64)
                if (tipoAtributo == "float64" && valorAtributo is IntValue intValue) {
                    valorAtributo = new FloatValue(intValue.Value);
                }
            } else {
                // Es un struct, verificar compatibilidad
                if (!(valorAtributo is InstanciaValue instanciaVal)) {
                    throw new SemanticError($"ERROR: No se puede asignar un valor de tipo {valorAtributo.GetType().Name} al atributo '{nombreAtributo}' que debería ser un struct de tipo '{tipoAtributo}'", token);
                }
                
                // Verificar que el tipo sea correcto
                if (instanciaVal.instancia.GetTypeName() != tipoAtributo) {
                    throw new SemanticError($"ERROR: No se puede asignar un struct de tipo '{instanciaVal.instancia.GetTypeName()}' al atributo '{nombreAtributo}' que debería ser un struct de tipo '{tipoAtributo}'", token);
                }
            }
            
            // Asignar el valor al atributo
            instanciaAtributos[nombreAtributo] = valorAtributo;
        }
    }
    
    // PASO 3: Crear la instancia del struct con los atributos inicializados
    InstanciaValue instanciaValue = new InstanciaValue(
        new Instancia(structValue.Nombre, instanciaAtributos)
    );
    
    Console.WriteLine($"\t (struct) -> Instancia de struct '{structValue.Nombre}' creada correctamente");
    
    return instanciaValue;
}

    /*

    structFunc: STFUNC LPAREN ID ID RPAREN ID parametrosF? tiposD? LBRACE dcl* RBRACE;

        * El primer ID es el nombre del receptor (p)
        * El segundo ID es el tipo de struct (Persona)
        * El tercer ID es el nombre de la función (Saludar)
        * Parámetros opcionales
        * Tipo de retorno opcional
        * Un cuerpo con declaraciones

    Función asociada a un struct (método)
    ---> func ( p Persona ) Saludar() string { ... }


    */
    public override ValueWrapper VisitStructFunc(LanguageParser.StructFuncContext context)
    {
        // Obtener información básica de la función
        string nombreReceptor = context.ID(0).GetText();  // nombre del receptor "p"
        string tipoStruct = context.ID(1).GetText();      // es el tipo de struct --> deberría esta ya declarado --> Persona (debería  ser un puntero)
        string nombreFuncion = context.ID(2).GetText();   // nombre de la función --> Saludar

        Console.WriteLine($"\t (struct) --> Procesando función de struct: {nombreFuncion} para tipo {tipoStruct}");

        // Verificar si el struct existe
        ValueWrapper tipoValor;
        try
        {
            tipoValor = entornoActual.Get(tipoStruct, context.Start);
        }
        catch (SemanticError)
        {
            throw new SemanticError($"ERROR: El struct '{tipoStruct}' no está definido", context.Start);
        }

        // Verificar que sea un struct
        if (!(tipoValor is StructValue structDef))
        {
            throw new SemanticError($"ERROR: '{tipoStruct}' no es un struct", context.Start);
        }

        // Verificar si ya existe un método con el mismo nombre
        if (structDef.Methods.ContainsKey(nombreFuncion))
        {
            throw new SemanticError($"ERROR: Ya existe un método '{nombreFuncion}' para el struct '{tipoStruct}'", context.Start);
        }

        // Crear la función asociada al struct
        var nuevaFuncion = new FuncionStructForanea(entornoActual, nombreReceptor, tipoStruct, context);

        // Agregar el método al struct
        structDef.Methods.Add(nombreFuncion, nuevaFuncion);

        Console.WriteLine($"\t (struct) --> Método '{nombreFuncion}' registrado para struct '{tipoStruct}'");

        return defaultValue;
    }






    // para las instancias --> llamar al constructo o a la clase para saber si es algo invocable
    public override ValueWrapper VisitNewInstan( LanguageParser.NewInstanContext context)
    {
        // buscamos la clase que instaciamos en el entorno actual
        ValueWrapper classValue = entornoActual.Get(context.ID().GetText(), context.Start);

        // si no es de tipo Clase es un error (no se puede instanciar algo que no es una clase)
        if(classValue is not ClassValue){
            throw new SemanticError("ERROR: Instancia de clase Invalida", context.Start);

        }

        // recorrer los argumentos
        List<ValueWrapper> arguments = new List<ValueWrapper>();
        if(context.parametros() != null){
            foreach(var arg in context.parametros().expr()){
                arguments.Add(Visit(arg));
            }
        }

        var instancia = ((ClassValue)classValue).structsDef.Invoke(arguments, this, context.Start);

        return instancia;
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
        ValueWrapper llamadaEmb = Visit(context.expr()); // lo primero que se debe resolver

        // Verificar que el resultado de la expresión no sea null
        if (llamadaEmb == null)
        {
            throw new SemanticError($"ERROR: La expresión de la llamada evaluó a null", context.Start);
        }

        // recorrer cada llamada:
        foreach (var action in context.call())
        {
            // si es una llamada a funcion:
            if (action is LanguageParser.FuncCallContext funcall)
            {
                if (llamadaEmb is FuncionValue funtionValue)
                {
                    // CAMBIO: esta parte no siempre van a ser parametros, sino tambien accesos a propiedades
                    llamadaEmb = VisitCall(funtionValue.invocable, funcall.parametros());
                    // Verificar que el resultado de la llamada no sea null
                    if (llamadaEmb == null)
                    {
                        throw new SemanticError($"ERROR: La llamada a la función {funtionValue.name} retornó null", context.Start);
                    }
                }
                else
                {
                    throw new SemanticError($"ERROR: La llamada es inválida. Se esperaba una función pero se recibió {llamadaEmb.GetType().Name}", context.Start);
                }

            }

            else if (action is LanguageParser.GetAtrContext porpertyAccess)
            {
                if (llamadaEmb is InstanciaValue instanciaValue)
                {
                    llamadaEmb = instanciaValue.instancia.Get(porpertyAccess.ID().GetText(), porpertyAccess.Start);
                }
                else if (llamadaEmb is ModuleValue moduleValue)
                {
                    // Si es un módulo, obtener la función correspondiente
                    llamadaEmb = moduleValue.GetFunction(porpertyAccess.ID().GetText());
                }
                else
                {
                    throw new SemanticError($"ERROR: La INSTANCIACION es inválida. Se esperaba una función pero se recibió {llamadaEmb.GetType().Name}", context.Start);
                }
            }// implementar el acceso a slice
            else if (action is LanguageParser.AccesoSliceContext arraryAccess)
            {
                // la llamada debe ser una instancia que es lo que retorna una instancia de arreglo:
                if (llamadaEmb is InstanciaValue instanciaValue)
                {
                    var index = Visit(arraryAccess.expr());
                    // los indices deben ser unicamente numericos
                    if (index is IntValue intValue)
                    {
                        llamadaEmb = instanciaValue.instancia.Get(intValue.Value.ToString(), arraryAccess.Start);
                    }
                    else
                    {
                        throw new SemanticError("ERROR: acesso invalido al slice por el tipo", context.Start);
                    }

                }
                else
                {
                    throw new SemanticError("ERROR: accesos invalido al slice no es una instancia", context.Start);
                }
            }

        }

        return llamadaEmb;
    }

    // call: LPAREN parametros? RPAREN
    public ValueWrapper VisitCall(Invocable invocable, LanguageParser.ParametrosContext context)
    {
        // definir una lista de argunmentos:
        List<ValueWrapper> argumentos = new List<ValueWrapper>();

        if (context != null)
        {
            // si el contexto es diferente de nulo hay que recorrer todos los parametros ---> parametros?
            foreach (var expr in context.expr())
            {
                ValueWrapper arg = Visit(expr);

                // Verificar que el argumento no sea null
                if (arg == null)
                {
                    throw new SemanticError($"ERROR: Uno de los argumentos de la llamada evaluó a null", context.Start);
                }

                argumentos.Add(arg);
            }
        }


        // validar tipos

        // validar cantidad de parametros:
        if (context != null && argumentos.Count != invocable.Arity())
        {
            throw new SemanticError($"ERROR: La función esperaba {invocable.Arity()} parámetros, pero se recibieron {argumentos.Count}", context.Start);
        }

        try
        {
                    // Pasar el context original, que podría ser null
            return invocable.Invoke(argumentos, this, context?.Start);
        }
        catch (Exception e) when (!(e is SemanticError))
        {
            // Capturar excepciones inesperadas y convertirlas en SemanticError
            throw new SemanticError($"ERROR: Ocurrió un error durante la llamada a la función: {e.Message}", context?.Start);
        }
    }



    /*
        ---> funciones FORANEAS

        // Función sin parámetros y sin retorno
        func <nombreFuncion>() {
            // <cuerpo de la función>
        }

        // Función con parámetros y sin retorno
        func <nombreFuncion>(<param1> <tipo1>, <param2> <tipo2>) {
            // <cuerpo de la función>
        }
        
        // Función con parámetros y con retorno
        func <nombreFuncion>(<param1> <tipo1>, <param2> <tipo2>) <tipoRetorno> {
            // <cuerpo de la función>
            return <valorDeRetorno>
        }
    */
    public override ValueWrapper VisitFuncionDcl(LanguageParser.FuncionDclContext context)
    {
        Console.WriteLine("\t --> funcion {");
        
        var nuevaFun = new FuncionForanea(entornoActual, context); // crear la funcion
        // nombre de la funcion // un valor tipo Funcion // token de inicio 
        entornoActual.Declaracion(context.ID().GetText(), new FuncionValue(nuevaFun, context.ID().GetText()), context.Start);
        
        Console.WriteLine("\t -->         }");
        return defaultValue;
    }







/*
    //       -----------> SLICE <-----------
    public override ValueWrapper VisitSlice(LanguageParser.SliceContext context)
    {

        // recorrer los argumentos
        List<ValueWrapper> arguments = new List<ValueWrapper>();
        if(context.parametros() != null){
            foreach(var arg in context.parametros().expr()){
                arguments.Add(Visit(arg));
            }
        }

        // generar una clase cada vez que se cree un arreglo
        var sliceClase = new SliceDef();
        var instancia = sliceClase.Invoke(arguments, this); // conectar el mundo de los arreglos al mundo de las instancias

        return instancia;
    }


    // public override ValueWrapper VisitAccesoSlice(LanguageParser.AccesoSliceContext context){ }


*/


// Visitar una expresión de slice literal: [1, 2, 3]
    public override ValueWrapper VisitSlice(LanguageParser.SliceContext context)
    {
        Console.WriteLine("\t (slice) -->   Visitando expresión de slice literal");
        
        // Recopilar los elementos del slice
        List<ValueWrapper> elementos = new List<ValueWrapper>();
        if (context.parametros() != null)
        {
            foreach (var expr in context.parametros().expr())
            {
                elementos.Add(Visit(expr));
            }
        }
        
        // Determinar el tipo del slice basado en el primer elemento
        // Si no hay elementos, se usa int como tipo predeterminado
        string tipoElemento = "int";
        
        if (elementos.Count > 0)
        {
            ValueWrapper primerElemento = elementos[0];
            
            if (primerElemento is IntValue) tipoElemento = "int";
            else if (primerElemento is FloatValue) tipoElemento = "float64";
            else if (primerElemento is StringValue) tipoElemento = "string";
            else if (primerElemento is BoolValue) tipoElemento = "bool";
            else if (primerElemento is RuneValue) tipoElemento = "rune";
        }
        
        // Crear el SliceDef y la instancia
        SliceDef sliceDef = new SliceDef(tipoElemento);
        return sliceDef.Invoke(elementos, this, context.Start);
    }


// Visitar declaración de slice sin inicialización: var slice []int
    public override ValueWrapper VisitSlcDcl1(LanguageParser.SlcDcl1Context context)
    {
        string id = context.ID().GetText();
        string tipo = context.tiposD().GetText();
        
        Console.WriteLine($"\t (slice) -->   Declarando slice vacío '{id}' de tipo '[]{tipo}'");
        
        // Crear un slice vacío
        SliceDef sliceDef = new SliceDef(tipo);
        ValueWrapper sliceValue = sliceDef.Invoke(new List<ValueWrapper>(), this, context.Start);
        
        // Declarar la variable en el entorno actual
        entornoActual.Declaracion(id, sliceValue, context.Start);
        
        return sliceValue;
    }

// Visitar declaración de slice con inicialización: numeros := []int { 10, 20, 30 }
    public override ValueWrapper VisitSlcDcl2(LanguageParser.SlcDcl2Context context)
    {
        // Obtener el ID del slice y su tipo
        string id = context.ID().GetText(); // Accedemos con índice porque puede haber múltiples IDs
        string tipo = context.tiposD().GetText();
        
        Console.WriteLine($"\t (slice) -->   Declarando slice '{id}' de tipo '[]{tipo}' con inicialización");
        
        // Lista para almacenar todos los elementos del slice
        List<ValueWrapper> elementos = new List<ValueWrapper>();
        
        // Iterar por cada parámetro del slice (pueden ser valores directos o slices anidados)
        foreach (var param in context.slcParam())
        {
            // Verificar si este parámetro es un slice anidado (contiene LBRACE)
            if (param.LBRACE() != null)
            {
                // Es un slice anidado como {1, 2, 3}
                // Crear una lista para los elementos de este subslice
                List<ValueWrapper> subElementos = new List<ValueWrapper>();
                
                // Cada parametros es un array, necesitamos iterar
                // CORRECCIÓN: parametros() devuelve un array de ParametrosContext
                if (param.parametros() != null && param.parametros().Length > 0)
                {
                    // Iteramos por cada contexto de parámetros
                    foreach (var parametro in param.parametros())
                    {
                        // Ahora podemos acceder a las expresiones dentro de este contexto de parámetros
                        foreach (var expr in parametro.expr())
                        {
                            // Evaluar la expresión y añadirla al subslice
                            subElementos.Add(Visit(expr));
                        }
                    }
                }
                
                // Crear el subslice y añadirlo como un elemento del slice principal
                SliceDef subSliceDef = new SliceDef(tipo);
                elementos.Add(subSliceDef.Invoke(subElementos, this, context.Start));
            }
            // Si es un parámetro directo (sin LBRACE)
            else if (param.parametros() != null && param.parametros().Length > 0)
            {
                // Iteramos por cada contexto de parámetros (similar al caso anterior)
                foreach (var parametro in param.parametros())
                {
                    // Procesamos cada expresión en este contexto
                    foreach (var expr in parametro.expr())
                    {
                        // Evaluar y añadir al slice principal
                        elementos.Add(Visit(expr));
                    }
                }
            }
        }
        
        // Crear el slice principal con todos los elementos recopilados
        SliceDef sliceDef = new SliceDef(tipo);
        ValueWrapper sliceValue = sliceDef.Invoke(elementos, this, context.Start);
        
        // Declarar la variable en el entorno actual
        entornoActual.Declaracion(id, sliceValue, context.Start);
        
        return sliceValue;
    }


    // Este es un método auxiliar que se puede llamar desde VisitLlamada para el acceso a slice
    private ValueWrapper AccederSlice(ValueWrapper sliceValue, int indice, Antlr4.Runtime.IToken token)
    {
        if (sliceValue is InstanciaValue instanciaValue)
        {
            // Verificar que sea un slice
            if (!instanciaValue.instancia.GetTypeName().StartsWith("[]"))
            {
                throw new SemanticError($"ERROR: No se puede acceder con índice a un valor de tipo '{instanciaValue.instancia.GetTypeName()}'", token);
            }
            
            // Verificar límites del índice
            int longitud = 0;
            if (instanciaValue.instancia.values.ContainsKey("length") && 
                instanciaValue.instancia.values["length"] is IntValue lengthValue)
            {
                longitud = lengthValue.Value;
            }
            
            if (indice < 0 || indice >= longitud)
            {
                throw new SemanticError($"ERROR: Índice fuera de rango. El slice tiene {longitud} elementos, pero se intentó acceder al índice {indice}", token);
            }
            
            // Obtener el elemento
            return instanciaValue.instancia.Get(indice.ToString(), token);
        }
        
        throw new SemanticError($"ERROR: No se puede acceder con índice a un valor de tipo '{sliceValue.GetType().Name}'", token);
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

        // Comprobar que los operandos no sean null
        if (left == null)
        {
            throw new SemanticError($"ERROR: El operando izquierdo de {context.op.Text} es nulo", context.Start);
        }

        if (right == null)
        {
            throw new SemanticError($"ERROR: El operando derecho de {context.op.Text} es nulo", context.Start);
        }

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
        Console.WriteLine("---> operador: " + op);

        // Comprobar que los operandos no sean null
        if (left == null)
        {
            throw new SemanticError($"ERROR: El operando izquierdo de {context.op.Text} es nulo", context.Start);
        }

        if (right == null)
        {
            throw new SemanticError($"ERROR: El operando derecho de {context.op.Text} es nulo", context.Start);
        }




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
                throw new SemanticError($"ERROR: Operador no reconocido {context.op.Text}", context.Start);
        }
    }


    // Negación unitaria 
    public override ValueWrapper VisitNegateU(LanguageParser.NegateUContext context)
    {
        ValueWrapper value = Visit(context.expr());
        var op = context.op.Text;
        Console.WriteLine("---> operador: " + op);

        // Comprobar que los operandos no sean null
        if (value == null)
        {
            throw new SemanticError($"ERROR: El operando {value} es nulo", context.Start);
        }


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

        if (left == null || right == null) {
        throw new SemanticError($"ERROR: Operando nulo en comparación {context.op.Text}", context.Start);
    }
        
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
                    case (NilValue l, NilValue r): // rune == rune = bool
                        Console.WriteLine($"---> valor izq: {l} - {l.GetType()} == valor der: {r} - {r.GetType()}");
                        return new BoolValue(l == r);
                    case (InstanciaValue l, NilValue r): // rune == rune = bool
                        Console.WriteLine($"---> valor izq: {l} - {l.GetType()} == valor der: {r} - {r.GetType()}");
                        return new BoolValue(l == r); 
                    case (NilValue l, InstanciaValue r): // rune == rune = bool
                        Console.WriteLine($"---> valor izq: {l} - {l.GetType()} == valor der: {r} - {r.GetType()}");
                        return new BoolValue(l == r);
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

        // Comprobar que los operandos no sean null
        if (left == null)
        {
            throw new SemanticError($"ERROR: El operando izquierdo de {context.op.Text} es nulo", context.Start);
        }

        if (right == null)
        {
            throw new SemanticError($"ERROR: El operando derecho de {context.op.Text} es nulo", context.Start);
        }
        
        
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

        // Comprobar que los operandos no sean null
        if (left == null)
        {
            throw new SemanticError($"ERROR: El operando izquierdo de {left} es nulo", context.Start);
        }

        if (right == null)
        {
            throw new SemanticError($"ERROR: El operando derecho de {right} es nulo", context.Start);
        }

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

        // Comprobar que los operandos no sean null
        if (left == null)
        {
            throw new SemanticError($"ERROR: El operando izquierdo de {left} es nulo", context.Start);
        }

        if (right == null)
        {
            throw new SemanticError($"ERROR: El operando derecho de {right} es nulo", context.Start);
        }

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

    public override ValueWrapper VisitValorNulo( LanguageParser.ValorNuloContext context)
    {
        Console.WriteLine("Procesando valor nil (referencia nula)");
        return new NilValue();
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



