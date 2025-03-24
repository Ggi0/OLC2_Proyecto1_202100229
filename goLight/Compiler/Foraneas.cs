

using analyzer;

/*

    Clousure --> es una función que "recuerda" el entorno donde fue creada, 
                 incluso después de que ese entorno ha dejado de existir.

*/
public class FuncionForanea : Invocable{
    
    private Entorno clousure; // el entorno en el que se declaró la función
    private LanguageParser.FuncionDclContext context; // contexto de la funcion --> cuerpo -> se ejecuta en la llamada y no en la declaracion
    private string tipoRetorno; // Almacena el tipo de retorno esperado de la función

    // constructor
    public FuncionForanea(Entorno clousure, LanguageParser.FuncionDclContext context){
        this.clousure =  clousure; // --> en que contexto padre estaba viviendo la funcion cuando se declaro
        this.context = context;  // el contexto que tiene el "nodo" del ast

        // Determinar el tipo de retorno... si existe
        this.tipoRetorno = context.tiposD() != null ? context.tiposD().GetText() : null;
    }


    // Numero de parametros que tiene definida la funcion 
    public int Arity(){
        
        if (context.parametrosF() ==  null){ // es posible que no vengan parametros
            return 0;
        }
        return context.parametrosF().ID().Length; // --> cuantos IDs vienen (parametrosF: ID tiposD (COMMA ID tiposD)*)
    }


    private void ValidarTiposParametros(List<ValueWrapper> args) {
        if (context.parametrosF() == null) return; // si no vienen parametros regresa normal
        
        // Para cada parámetro definido, comprobar si el tipo del argumento correspondiente es compatible
        for (int i = 0; i < context.parametrosF().ID().Length; i++) {
            var tipoParametro = context.parametrosF().tiposD(i).GetText();
            var argumento = args[i];
            
            // Validación de tipos (simplificada)
            bool compatible = false;
            
            switch (tipoParametro) {
                case "int":
                    compatible = argumento is IntValue;
                    break;
                case "float64":
                    compatible = argumento is FloatValue || argumento is IntValue; // Conversión implícita int -> float64
                    break;
                case "string":
                    compatible = argumento is StringValue;
                    break;
                case "bool":
                    compatible = argumento is BoolValue;
                    break;
                case "rune":
                    compatible = argumento is RuneValue;
                    break;
            }
            
            if (!compatible) {
                throw new SemanticError($"ERROR: El parámetro '{context.parametrosF().ID(i).GetText()}' espera un valor de tipo '{tipoParametro}', pero se recibió {argumento.GetType().Name}", context.Start);
            }
        }
    }


    // Verifica que el valor de retorno coincida con el tipo esperado
    private ValueWrapper ValidarTipoRetorno(ValueWrapper valorRetorno)
    {

        if (valorRetorno == null)
        {
            throw new SemanticError($"ERROR: El valor de retorno es nulo", context.Start);
        }

        if (tipoRetorno == null)
        {
            // Si no hay tipo de retorno definido, no debería devolver un valor (excepto void)
            if (!(valorRetorno is VoidValue))
            {
                throw new SemanticError($"ERROR: La función no tiene tipo de retorno definido pero está intentando retornar un valor de tipo {valorRetorno.GetType().Name}", context.Start);
            }
            return valorRetorno;
        }

        // Comprobar que el tipo del valor de retorno sea compatible con el tipo definido
        bool compatible = false;
        
        switch (tipoRetorno) {
            case "int":
                compatible = valorRetorno is IntValue;
                break;
            case "float64":
                compatible = valorRetorno is FloatValue || valorRetorno is IntValue; // Conversión implícita int -> float64
                break;
            case "string":
                compatible = valorRetorno is StringValue;
                break;
            case "bool":
                compatible = valorRetorno is BoolValue;
                break;
            case "rune":
                compatible = valorRetorno is RuneValue;
                break;
        }
        
        if (!compatible) {
            throw new SemanticError($"ERROR: La función debe retornar un valor de tipo '{tipoRetorno}', pero se está retornando un valor de tipo {valorRetorno.GetType().Name}", context.Start);
        }
        
        // Realizar conversión implícita si es necesario (int -> float64)
        if (tipoRetorno == "float64" && valorRetorno is IntValue intValue) {
            return new FloatValue(intValue.Value);
        }
        
        return valorRetorno;
    }


    /*
    
        1) Valida que el número de argumentos coincida con Arity().
        2) Valida los tipos de los argumentos.
        3) Crea un nuevo entorno (Entorno nuevoENV) donde vivirán los parámetros.
        4) Asigna los valores de los argumentos a los parámetros de la función.
        5) Ejecuta las instrucciones de la función en el nuevo entorno.
        6) Maneja el return con una ReturnException.
        7) Restaura el entorno original y retorna el resultado.
    
    */
     public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token){
        Console.WriteLine("\t -> iniciando procesado de la funcion: ");

        // Validar cantidad de parámetros
        if (Arity() != args.Count) {
            throw new SemanticError($"ERROR: La función esperaba {Arity()} parámetros, pero se recibieron {args.Count}", context.Start);
        }

        // Validar tipos de parámetros
        ValidarTiposParametros(args);
        
        // 1) nuevo entorno --> en donde viviran los parametros de la funcion
        var nuevoENV = new Entorno(clousure); // --> el padre es el clousere --> entorno que encierra a la funcion
        var beforeCallEnv = visitor.entornoActual; // --> antes de la llamada en que entorno estabamos

        Console.WriteLine("\t ---> nuevo Entorno para la FUNCION <---");
        visitor.entornoActual = nuevoENV; // cambiar al nuevo entorno

        // 2) ir asignando a cada uno de los parametros con un argumento
        if (context.parametrosF() != null)
        { 
            Console.WriteLine($"Si hay parametros y son: {context.parametrosF().ID().Length} ");
            // SI hay parametros
            // recorrerlos y declararlos
            for (int i = 0; i < context.parametrosF().ID().Length; i++)
            {
                // public void Declaracion(string id, ValueWrapper value, Antlr4.Runtime.IToken? token)
                // --> ID --> nombre
                // --> valor --> List<ValueWrapper> args
                // --> el token donde inicia
                nuevoENV.Declaracion(context.parametrosF().ID(i).GetText(), args[i], null);
            }
        }

        ValueWrapper result = visitor.defaultValue; // Inicializar con el valor por defecto

        // ya que dentro de la funcion puede venir un return hay que capturarlo
        try
        {
            // ejecutar las instrucciones de la funcion
            foreach (var instruccion in context.dcl())
            {
                visitor.Visit(instruccion);
            }

            // Si llegamos aquí y no hubo return pero la función debe retornar un valor, es un error
            if (tipoRetorno != null && tipoRetorno != "void")
            {
                throw new SemanticError($"ERROR: La función debe retornar un valor de tipo '{tipoRetorno}'", context.Start);
            }

            return visitor.defaultValue; // void

        }
        catch (ReturnException e)
        {
            // Capturar el valor de retorno
            result = e.Value;

            // Comprobar que no sea null
            if (result == null)
            {
                throw new SemanticError($"ERROR: La función '{context.ID().GetText()}' retornó un valor nulo", context.Start);
            }

            // Debug
            //Console.WriteLine($"DEBUG: Valor capturado en ReturnException: {result}");

            // Validar el tipo
            result = ValidarTipoRetorno(result);
        }
        finally
        {
            Console.WriteLine("\t    finalizando proceso funcion <--");
            // Restaurar el entorno anterior siempre
            visitor.entornoActual = beforeCallEnv;
        }

        return result; // no regreso nada (void)
        /*
        // IMPORTANTE: Primero restaurar el entorno antes de validar
        visitor.entornoActual = beforeCallEnv; // regresar al entorno en donde estaba antes de ejecutar la funcion

        // Asegurarnos de que el valor no sea null
        if (e.Value == null)
        {
            throw new SemanticError($"ERROR: La función '{context.ID().GetText()}' retornó un valor nulo", context.Start);
        }


        // Validar el tipo de retorno
        ValueWrapper resultado = ValidarTipoRetorno(e.Value);
        return resultado;
    }
    catch (Exception ex)
    {
        // Restaurar el entorno en caso de cualquier otra excepción
        visitor.entornoActual = beforeCallEnv;
        throw; // Re-lanzar la excepción original
    }*/

        //visitor.entornoActual = beforeCallEnv;
        //return visitor.defaultValue; // no regreso nada (void)

    }


    // En Funciones foraneas vamos a validar que exita el THIS. algo
    // sera como una copia de la funcion pero en donde exista el this.
    public FuncionForanea Bind(Instancia instancia){
        // entorno oculto --> el entorno padre es el clousure
        // para esto usar un ValueWrapper tipo instancia.
        var entornoOculto = new Entorno(clousure);
        entornoOculto.Declaracion("this", new InstanciaValue(instancia), null);
        return new FuncionForanea(entornoOculto, context); // una nueva copia pero se le cambia el entorno

    }

}
