

// Guardar informacion sobre que tipo de dato se esta manejando 
// esta clase hererdara a las otras especificas

/*

    record es un tipo de clase inmutable que sirve para representar datos.
    ValueWrapper es la clase base abstracta para representar valores en el lenguaje.

*/
public abstract record ValueWrapper;

public record IntValue (int Value) : ValueWrapper;
public record FloatValue (float Value) : ValueWrapper;
public record StringValue (string Value) : ValueWrapper;
public record BoolValue (bool Value) : ValueWrapper;
public record RuneValue(char Value) : ValueWrapper;
public record VoidValue : ValueWrapper;

// FuncionValue envuelve un Invocable, lo que significa que cualquier Invocable (como FuncionForanea) se almacena como ValueWrapper
public record FuncionValue(Invocable invocable, string name) : ValueWrapper;

public record InstanciaValue(Instancia instancia) : ValueWrapper;

// valor para las clases --> que se volvera para las structs
public record ClassValue(StructsDef structsDef) : ValueWrapper;


/*

Clave: nombre del atributo
Valor: (nombre del tipo, esStruct), donde esStruct es un booleano que indica si el tipo es un struct o un tipo primitivo.

 Valor para los structs
 Nombre: Nombre del tipo de struct
 Atributos: Diccionario de atributos con sus tipos y una bandera que indica si son structs


*/
public record StructValue(string Nombre, Dictionary<string, (string, bool, bool)> Atributos) : ValueWrapper;



// Clase para representar un atributo inicializado temporalmente durante la construcción
public record AtributoInicializacionValue(string Nombre, ValueWrapper Valor) : ValueWrapper;


// Representa el valor 'nil' (nulo/referencia vacía)
public record NilValue : ValueWrapper;

