


using System.Diagnostics.Metrics;
using analyzer;
using Microsoft.AspNetCore.SignalR.Protocol;

public class StructsDef : Invocable
{

    // nombre del struct
    public string Name { get; set; }

    // un Diccionario --> nombre de la propiedad y que es lo que hace referencia (el contexto de la declaracion de la variable)
    // Para cada atributo, guardamos su tipo y un booleano que indica si es un struct
    public Dictionary<string, (string, bool, bool)> Atributos { get; set; }
    
    // Métodos asociados (se implementarán en el futuro)
    public Dictionary<string, FuncionForanea> Methods { get; set; }
    
    // Constructor
    // Constructor de la clase StructsDef
    public StructsDef(string name, Dictionary<string, (string, bool, bool)> atributos, Dictionary<string, FuncionForanea> methods) {
        Name = name;         // Nombre del struct
        Atributos = atributos; // Atributos del struct
        Methods = methods ?? new Dictionary<string, FuncionForanea>();
    }
    

    // un metodo que ayuda a buscar metodos --> recibe el nombre del metodo 
    //  Método para buscar un método del struct por su nombre
    // Esto será útil cuando implementemos métodos asociados a structs
    public FuncionForanea GetMethod(string name) {
        // Si el diccionario de métodos existe y contiene la clave, devolver el método
        if (Methods != null && Methods.ContainsKey(name)) {
            return Methods[name];
        }
        // Si no existe, devolver null
        return null;
    }

    // ---> definir la arity
    // Método que define la aridad (número de parámetros) requerida para instanciar el struct
    // Implementa la interfaz Invocable
    public int Arity() {
        // Por ahora los structs no tienen constructor definido, así que la aridad es 0
        return 0;
        
        /*
        var constructor = GetMethod("constructor");
        if (constructor != null) {
            return constructor.Arity();
        }
        return 0;
        */
    }


/* instaciacion para clases
     // Implementar el método Invoke para la instanciación
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor){
        Console.WriteLine($"Instanciando struct '{Name}'");
        // logica de lo que sucede de cuando se trata de invocar una clase --> new ...
        var nuevaInstancia = new Instancia(this);

        // hasta que se invoca ejecutamos todos los atibutos de la clase
        foreach (var prop in Atributos){
            var name = prop.Key;
            var value = prop.Value;

            if(value.expr() != null){
                var varValue = visitor.Visit(value.expr());
                nuevaInstancia.Set(name, varValue);
            }else{
                nuevaInstancia.Set(name, visitor.defaultValue);
            }
        }

        // obtener el constructor si es que existe
        var constructor = GetMethod("constructor");
        if(constructor != null){
            constructor.Bind(nuevaInstancia).Invoke(args, visitor); // en el constructor tiene que existir el THIS
        }

        // la instancia que se hace referencia es justo la que se retorna aqui
        return new InstanciaValue(nuevaInstancia);

    }


*/


// Implementar el método Invoke para la instanciación
// Método para crear una instancia del struct (implementa Invocable)
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor) {
        Console.WriteLine($"\t (struct) -->   Instanciando struct '{Name}'");
        
        // Crear un diccionario para los valores de los atributos
        Dictionary<string, ValueWrapper> atributosValores = new Dictionary<string, ValueWrapper>();
        
        // Inicializar cada atributo con su valor por defecto
        foreach (var atributo in Atributos) {
            string nombreAtributo = atributo.Key;
            string tipoAtributo = atributo.Value.Item1;
            bool esStruct = atributo.Value.Item2;
            bool esPuntero = atributo.Value.Item3; 

            ValueWrapper valorDefecto;
            
            // Asignar valor por defecto según el tipo
            if (esPuntero)
            {
                // Si es un puntero, inicializar con nil
                Console.WriteLine($"\t (struct) -->   Inicializando puntero '{nombreAtributo}' con nil");
                valorDefecto = new NilValue();
            }
            else if (!esStruct)
            {
                // Es un tipo primitivo
                valorDefecto = tipoAtributo switch
                {
                    "int" => new IntValue(0),
                    "float64" => new FloatValue(0.0f),
                    "string" => new StringValue(""),
                    "bool" => new BoolValue(false),
                    "rune" => new RuneValue('\0'),
                    _ => visitor.defaultValue
                };
            } else {
                // Es un struct, crear una instancia recursiva
                try {
                    var otroTipoValor = visitor.entornoActual.Get(tipoAtributo, null);
                    if (otroTipoValor is StructValue otroStructValue) {
                        // Crear una instancia vacía del struct anidado
                        Dictionary<string, ValueWrapper> atributosAnidados = new Dictionary<string, ValueWrapper>();
                        
                        // Inicializar atributos del struct anidado recursivamente
                        foreach (var atributoAnidado in otroStructValue.Atributos) {
                            string nombreAnidado = atributoAnidado.Key;
                            string tipoAnidado = atributoAnidado.Value.Item1;
                            bool esStructAnidado = atributoAnidado.Value.Item2;
                            bool esPunteroAnidado = atributoAnidado.Value.Item3;

                            // Asignar valor por defecto
                        ValueWrapper valorAnidado;
                        
                        if (esPunteroAnidado) {
                            valorAnidado = new NilValue();
                        } else if (!esStructAnidado) {
                            valorAnidado = tipoAnidado switch {
                                "int" => new IntValue(0),
                                "float64" => new FloatValue(0.0f),
                                "string" => new StringValue(""),
                                "bool" => new BoolValue(false),
                                "rune" => new RuneValue('\0'),
                                _ => visitor.defaultValue
                            };
                        } else {
                            valorAnidado = visitor.defaultValue;
                        }
                            
                            atributosAnidados.Add(nombreAnidado, valorAnidado);
                        }
                        
                        // Crear instancia anidada
                        valorDefecto = new InstanciaValue(new Instancia(otroStructValue.Nombre, atributosAnidados));
                    } else {
                        valorDefecto = visitor.defaultValue;
                    }
                } catch (SemanticError) {
                    valorDefecto = visitor.defaultValue;
                }
            }
            
            // Agregar el atributo con su valor por defecto al diccionario
            atributosValores.Add(nombreAtributo, valorDefecto);
        }
        
        // Crear una instancia del struct con los valores inicializados
        return new InstanciaValue(new Instancia(Name, atributosValores));
    }

}