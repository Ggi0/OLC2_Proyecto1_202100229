//instancia a la clase --> struct

// una instancia solo guarda las propiedades y las referecias a la clase

public class Instancia{

    // propiedades
    // 1) una referencia a la clase --> cada instancia parte de una clase
    private StructsDef structsDef;

    // 2) un diccionario --> de propiedades
    private Dictionary<string, ValueWrapper> Propiedades;

    // constructor --> a que clase pertenece esta Instancia
    public Instancia( StructsDef structsDef){
        // 1) lo ejecuta a que clase pertenece
        this.structsDef = structsDef; 

        // 2) genera un entorno limpio, diccionario de que propiedades tiene
        Propiedades = new Dictionary<string, ValueWrapper>();
    }

    // el equivalente a asignar dentro de la instacia sera el metodo SET
    public void Set(string name, ValueWrapper value){
        // Guardame en tal punto el valor
        Propiedades[name] = value;
    }

    public ValueWrapper Get(string name, Antlr4.Runtime.IToken token){
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
    }


}