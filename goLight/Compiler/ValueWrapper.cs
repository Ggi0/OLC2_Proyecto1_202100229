
using analyzer;
using System.Collections.Generic;

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
//public record StructValue(string Nombre, Dictionary<string, (string, bool, bool)> Atributos) : ValueWrapper;
public record StructValue(string Nombre, Dictionary<string, (string, bool, bool)> Atributos) : ValueWrapper
{
    // Cambiamos de FuncionForanea a Invocable para mayor flexibilidad
    public Dictionary<string, Invocable> Methods { get; set; } = new Dictionary<string, Invocable>();
}


// Clase para representar un atributo inicializado temporalmente durante la construcción
public record AtributoInicializacionValue(string Nombre, ValueWrapper Valor) : ValueWrapper;


// Representa un valor de slice (array dinámico)
public record SliceValue(string TipoElemento, List<ValueWrapper> Elementos) : ValueWrapper
{
    // Método para verificar si un valor es compatible con el tipo del slice
    public bool EsCompatible(ValueWrapper valor)
    {
        // Si es otro slice, verificar que sea del mismo tipo
        if (valor is InstanciaValue instanciaValue && 
            instanciaValue.instancia.GetTypeName().StartsWith("[]"))
        {
            // Verificar que sea un slice del mismo tipo base
            string tipoSlice = instanciaValue.instancia.GetTypeName();
            return tipoSlice == "[]" + TipoElemento;
        }

        // Verificar tipos primitivos
        switch (TipoElemento)
        {
            case "int":
                return valor is IntValue;
            case "float64":
                return valor is FloatValue || valor is IntValue; // Permitir conversión implícita
            case "string":
                return valor is StringValue;
            case "bool":
                return valor is BoolValue;
            case "rune":
                return valor is RuneValue;
            default:
                return false;
        }
    }
}
// Representa el valor 'nil' (nulo/referencia vacía)
public record NilValue : ValueWrapper;

