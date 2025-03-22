//instancia a la clase --> struct

// una instancia solo guarda las propiedades y las referecias a la clase
// Representa una instancia de un struct en memoria


public class Instancia{

    // Nombre del tipo de struct al que pertenece esta instancia
    public string typeName;
    
    // Diccionario que almacena los valores de los atributos
    public Dictionary<string, ValueWrapper> values;

    // constructor --> a que clase pertenece esta Instancia
    public Instancia(string typeName, Dictionary<string, ValueWrapper> values) {
        // 1) lo ejecuta a que clase pertenece
        this.typeName = typeName;

        // 2) genera un entorno limpio, diccionario de que propiedades tiene
        this.values = values;
    }

    // Método para obtener un atributo
    // name -->  Nombre del atributo 
    // token --> Token para el error, si ocurre
    // regresa valor de atributos
    public ValueWrapper Get(string name, Antlr4.Runtime.IToken token)
    {
        // Si el atributo existe, devolver su valor
        if (values.ContainsKey(name))
        {
            return values[name];
        }

        // Si no es un atributo, buscar un método en el tipo struct
        try
        {
            ValueWrapper tipoValor = CompilerVisitor.Instance.entornoActual.Get(typeName, token);
            if (tipoValor is StructValue structValue && structValue.Methods.ContainsKey(name))
            {
                // Obtener el método y enlazarlo con esta instancia
                var metodo = structValue.Methods[name];
                if (metodo is FuncionStructForanea funcStruct)
                {
                    return new FuncionValue(funcStruct.Bind(this), name);
                }
            }
        }
        catch (SemanticError)
        {
            // Ignorar, simplemente significa que no se encontró el struct
        }

        // Si no se encuentra como atributo ni como método, lanzar error
        throw new SemanticError($"ERROR: El atributo o método '{name}' no existe en el struct '{typeName}'", token);

        // Si no existe, lanzar un error semántico
        //throw new SemanticError($"ERROR: El atributo '{name}' no existe en el struct '{typeName}'", token);
    }




    /* Método para establecer un atributo
    
    name  -->  Nombre del atributo
    value -->  Nuevo valor

    */
    public void Set(string name, ValueWrapper value) {
        // Guardar el valor en el diccionario
        values[name] = value;
    }

    /*
    Obtiene el nombre del tipo de struct
    regresa : Nombre del tipo
    */
    public string GetTypeName() {
        return typeName;
    }

   

    /*public ValueWrapper Get(string name, Antlr4.Runtime.IToken token){
        if(Propiedades.ContainsKey(name)){
            return Propiedades[name];
        }

        var method = structsDef.GetMethod(name);
        if (method != null){
            // para que en la funcion en donde se pretende Instanciar exista el this.
            return new FuncionValue(method.Bind(this), name);
        }
        // sino es una propiedad y no es un metodo es un error
        throw new SemanticError($"La propiedad: {name} no ha sido encontrada", token);
    }*/


}