
using analyzer;

// Representa una función asociada a un struct
public class FuncionStructForanea : Invocable {

    private Entorno clousure;
    private LanguageParser.StructFuncContext context;
    private string tipoRetorno;



    // Nombre del parámetro receptor (ej: "p" en func (p Persona) Saludar())
    private string nombreReceptor;
    
    // Nombre del struct al que está asociada esta función
    private string tipoStruct;
    
    // Constructor para funciones de struct
     public FuncionStructForanea(Entorno clousure, string nombreReceptor, string tipoStruct, 
                              LanguageParser.StructFuncContext context) {
        this.clousure = clousure;
        this.nombreReceptor = nombreReceptor;
        this.tipoStruct = tipoStruct;
        this.context = context;
        this.tipoRetorno = context.tiposD() != null ? context.tiposD().GetText() : null;
        
        Console.WriteLine($"\t (struct) --> Creando función struct para '{tipoStruct}' con receptor '{nombreReceptor}'");
    }
    
    public int Arity() {
        if (context.parametrosF() == null) {
            return 0;
        }
        return context.parametrosF().ID().Length;
    }
    
    private void ValidarTiposParametros(List<ValueWrapper> args) {
        // Código similar al de FuncionForanea...
        if (context.parametrosF() == null) return;
        
        for (int i = 0; i < context.parametrosF().ID().Length; i++) {
            var tipoParametro = context.parametrosF().tiposD(i).GetText();
            var argumento = args[i];
            
            bool compatible = false;
            
            switch (tipoParametro) {
                case "int":
                    compatible = argumento is IntValue;
                    break;
                case "float64":
                    compatible = argumento is FloatValue || argumento is IntValue;
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
    
    private ValueWrapper ValidarTipoRetorno(ValueWrapper valorRetorno) {
        // Código similar al de FuncionForanea...
        // (Copia el método completo)
        return valorRetorno;
    }
    
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token) {
        Console.WriteLine($"\t (struct) --> Invocando método para struct '{tipoStruct}'");
        
        // Validar cantidad de parámetros
        if (Arity() != args.Count) {
            throw new SemanticError($"ERROR: El método esperaba {Arity()} parámetros, pero se recibieron {args.Count}", context.Start);
        }

        // Validar tipos de parámetros
        ValidarTiposParametros(args);
        
        // Crear nuevo entorno
        var nuevoENV = new Entorno(clousure);
        var beforeCallEnv = visitor.entornoActual;
        
        visitor.entornoActual = nuevoENV;
        
        // Asignar argumentos a parámetros
        if (context.parametrosF() != null) {
            for (int i = 0; i < context.parametrosF().ID().Length; i++) {
                nuevoENV.Declaracion(context.parametrosF().ID(i).GetText(), args[i], null);
            }
        }
        
        ValueWrapper result = visitor.defaultValue;
        
        try {
            // Ejecutar instrucciones
            foreach (var instruccion in context.dcl()) {
                visitor.Visit(instruccion);
            }
            
            // Verificar retorno
            if (tipoRetorno != null && tipoRetorno != "void") {
                throw new SemanticError($"ERROR: El método debe retornar un valor de tipo '{tipoRetorno}'", context.Start);
            }
            
            return visitor.defaultValue;
        }
        catch (ReturnException e) {
            result = e.Value;
            
            if (result == null) {
                throw new SemanticError($"ERROR: El método retornó un valor nulo", context.Start);
            }
            
            result = ValidarTipoRetorno(result);
        }
        finally {
            visitor.entornoActual = beforeCallEnv;
        }
        
        return result;
    }
    
    public FuncionStructForanea Bind(Instancia instancia) {
        // Verificar tipo
        if (instancia.GetTypeName() != tipoStruct) {
            throw new SemanticError($"ERROR: No se puede enlazar un método de struct '{tipoStruct}' con una instancia de tipo '{instancia.GetTypeName()}'", null);
        }
        
        Console.WriteLine($"\t (struct) --> Enlazando método con instancia de '{tipoStruct}', usando receptor '{nombreReceptor}'");
        
        // Crear entorno con el receptor
        var entornoOculto = new Entorno(clousure);
        entornoOculto.Declaracion(nombreReceptor, new InstanciaValue(instancia), null);
        
        // Devolver nueva función con el mismo contexto pero entorno modificado
        return new FuncionStructForanea(entornoOculto, nombreReceptor, tipoStruct, context);
    }
}