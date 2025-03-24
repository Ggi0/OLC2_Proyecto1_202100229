/*

    Las funciones embebidas (o "built-in functions") son herramientas 
    predefinidas en los lenguajes de programación que permiten realizar 
    tareas comunes de manera eficiente y sin necesidad de que las programes 
    desde cero.

*/
using System.Data;

public class Embebidas{

    // las funciones Enbebidas estas disponibles en el entorno global
    public static void Generate(Entorno env){
        // Declarar referencia al valor --> la referencia se llama  time
        // retorna --> FuncionValue(new TimeEmbeded(), "time")
        // token  ---> null
        env.Declaracion("time", new FuncionValue(new TimeEmbeded(), "time"), null);
        
        // ---------------------------------------------------------------------------------------------
        // Crear módulo strconv con la función Atoi y ParseFloat
        var strconvFunctions = new Dictionary<string, ValueWrapper>();
        strconvFunctions["Atoi"] = new FuncionValue(new AtoiEmbeded(), "Atoi");
        strconvFunctions["ParseFloat"] = new FuncionValue(new ParseFloatEmbeded(), "ParseFloat");
        
        // Registrar el módulo strconv
        env.Declaracion("strconv", new ModuleValue(strconvFunctions), null);


        // ---------------------------------------------------------------------------------------------
        var reflectFunctions = new Dictionary<string, ValueWrapper>();
        reflectFunctions["TypeOf"] = new FuncionValue(new TypeOfEmbeded(), "TypeOf");
        
        // Registrar el módulo reflect
        env.Declaracion("reflect", new ModuleValue(reflectFunctions), null);


        // ---------------------------------------------------------------------------------------------
        // Crear módulo slices con la función Index
        var slicesFunctions = new Dictionary<string, ValueWrapper>();
        slicesFunctions["Index"] = new FuncionValue(new IndexEmbeded(), "Index");
        
        // Registrar el módulo slices
        env.Declaracion("slices", new ModuleValue(slicesFunctions), null);


        // Crear módulo strings con la función Join
        var stringsFunctions = new Dictionary<string, ValueWrapper>();
        stringsFunctions["Join"] = new FuncionValue(new JoinEmbeded(), "Join");
        
        // Registrar el módulo strings
        env.Declaracion("strings", new ModuleValue(stringsFunctions), null);

        // Registrar la función len (global, no parte de un módulo)
        env.Declaracion("len", new FuncionValue(new LenEmbeded(), "len"), null);

        // Registrar la función append (global, no parte de un módulo)
        env.Declaracion("append", new FuncionValue(new AppendEmbeded(), "append"), null);
        

    }
}

public class TimeEmbeded : Invocable{
    public int Arity() => 0;

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token){
        return new StringValue(DateTime.Now.ToString());
    }
}


/*
    Implementación de la función embebida strconv.Atoi
    
    Propósito: Convertir una cadena de texto a un valor entero (int)
    
    Comportamiento:
    - Acepta exactamente 1 parámetro de tipo string
    - Devuelve un IntValue con el número convertido
    - Genera error si la cadena contiene caracteres no numéricos
    - Genera error si la cadena representa un número decimal (contiene punto)
    - Maneja correctamente números negativos
    
    Ejemplos:
    - strconv.Atoi("123") -> 123
    - strconv.Atoi("-456") -> -456
    - strconv.Atoi("123.45") -> ERROR
    - strconv.Atoi("abc") -> ERROR
*/
public class AtoiEmbeded : Invocable
{
    // Especifica que esta función espera exactamente 1 argumento
    public int Arity()
    {
        return 1;
    }

    // Implementación de la conversión de string a int
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token)
    {
        // Verificar que recibimos exactamente un argumento
        if (args.Count != 1)
        {
            throw new SemanticError("ERROR: strconv.Atoi espera exactamente 1 argumento", token);
        }
        
        // Verificar que el argumento sea una cadena
        if (args[0] is not StringValue strValue)
        {
            throw new SemanticError("ERROR: strconv.Atoi requiere una cadena como argumento", token);
        }
        
        string valor = strValue.Value;
        
        // Verificar que la cadena no contenga un punto decimal
        if (valor.Contains("."))
        {
            throw new SemanticError("ERROR: strconv.Atoi no puede convertir números decimales", token);
        }
        
        // Intentar convertir la cadena a un entero
        if (int.TryParse(valor, out int resultado))
        {
            // Conversión exitosa, devolver un IntValue
            return new IntValue(resultado);
        }
        else
        {
            // Conversión fallida, lanzar error
            throw new SemanticError("ERROR: La cadena no representa un número entero válido", token);
        }
    }
}



/*
    Implementación de la función embebida strconv.ParseFloat
    
    Propósito: Convertir una cadena de texto a un valor de punto flotante (float64)
    
    Comportamiento:
    - Acepta exactamente 1 parámetro de tipo string
    - Devuelve un FloatValue con el número convertido
    - Maneja correctamente números enteros, convirtiéndolos automáticamente a float
    - Maneja correctamente números decimales con punto
    - Maneja correctamente números negativos
    - Genera error si la cadena contiene caracteres no numéricos
    
    Ejemplos:
    - strconv.ParseFloat("123.45") -> 123.45
    - strconv.ParseFloat("123") -> 123.0
    - strconv.ParseFloat("-456.78") -> -456.78
    - strconv.ParseFloat("abc") -> ERROR
*/
public class ParseFloatEmbeded : Invocable
{
    // Especifica que esta función espera exactamente 1 argumento
    public int Arity()
    {
        return 1;
    }

    // Implementación de la conversión de string a float
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token)
    {
        // Verificar que recibimos exactamente un argumento
        if (args.Count != 1)
        {
            throw new SemanticError("ERROR: strconv.ParseFloat espera exactamente 1 argumento", token);
        }
        
        // Verificar que el argumento sea una cadena
        if (args[0] is not StringValue strValue)
        {
            throw new SemanticError("ERROR: strconv.ParseFloat requiere una cadena como argumento", token);
        }
        
        string valor = strValue.Value;
        
        // Intentar convertir la cadena a un float
        if (float.TryParse(valor, System.Globalization.NumberStyles.Float, 
                          System.Globalization.CultureInfo.InvariantCulture, out float resultado))
        {
            // Conversión exitosa, devolver un FloatValue
            return new FloatValue(resultado);
        }
        else
        {
            // Conversión fallida, lanzar error
            throw new SemanticError("ERROR: La cadena no representa un número decimal válido", token);
        }
    }
}


/*
    Implementación de la función embebida reflect.TypeOf
    
    Propósito: Determinar el tipo de un valor en tiempo de ejecución
    
    Comportamiento:
    - Acepta exactamente 1 parámetro de cualquier tipo
    - Devuelve un StringValue con el nombre del tipo del valor
    - Funciona con tipos primitivos (int, float64, string, bool, rune)
    - Funciona con tipos compuestos (structs, slices)
    - Para instancias de structs, devuelve el nombre del struct
    - Para slices, devuelve la notación []tipo
    
    Ejemplos:
    - reflect.TypeOf(42) -> "int"
    - reflect.TypeOf(3.14) -> "float64"
    - reflect.TypeOf("hola") -> "string"
    - reflect.TypeOf(true) -> "bool"
    - reflect.TypeOf(Persona{}) -> "Persona"
    - reflect.TypeOf([]int{1,2,3}) -> "[]int"
*/
public class TypeOfEmbeded : Invocable
{
    // Especifica que esta función espera exactamente 1 argumento
    public int Arity()
    {
        return 1;
    }

    // Implementación de la obtención del tipo de un valor
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token)
    {
        // Verificar que recibimos exactamente un argumento
        if (args.Count != 1)
        {
            throw new SemanticError("ERROR: reflect.TypeOf espera exactamente 1 argumento", token);
        }
        
        // Determinar el tipo del argumento
        ValueWrapper valor = args[0];
        string nombreTipo = DeterminarTipo(valor);
        
        // Devolver el tipo como una cadena
        return new StringValue(nombreTipo);
    }
    
    // Método auxiliar para determinar el tipo de un valor
    private string DeterminarTipo(ValueWrapper valor)
    {
        return valor switch
        {
            IntValue => "int",
            FloatValue => "float64",
            StringValue => "string",
            BoolValue => "bool",
            RuneValue => "rune",
            VoidValue => "void",
            NilValue => "nil",
            FuncionValue fn => fn.name,
            // Para structs, devolver el nombre del struct
            StructValue sv => sv.Nombre,
            // Para instancias, devolver el nombre del tipo
            InstanciaValue iv => iv.instancia.GetTypeName(),
            // Para valores de tipo clase, devolver el nombre de la clase
            ClassValue cv => cv.structsDef.Name,
            // Para módulos como strconv
            ModuleValue => "module",
            // Valores desconocidos
            _ => "unknown"
        };
    }
}



/*
    Implementación de la función embebida slices.Index
    
    Propósito: Buscar un valor dentro de un slice y devolver el índice de la primera coincidencia
    
    Comportamiento:
    - Acepta exactamente 2 parámetros:
      1. Un slice (debe ser una instancia de tipo []T)
      2. El valor a buscar dentro del slice
    - Devuelve un IntValue con el índice de la primera coincidencia (base 0)
    - Devuelve -1 si el valor no se encuentra en el slice
    - Funciona con slices de cualquier tipo primitivo
    - Genera error si el primer argumento no es un slice
    
    Ejemplos:
    - slices.Index([]int{10, 20, 30, 40, 50}, 30) -> 2
    - slices.Index([]int{10, 20, 30, 40, 50}, 100) -> -1
*/
public class IndexEmbeded : Invocable
{
    // Especifica que esta función espera exactamente 2 argumentos
    public int Arity()
    {
        return 2;
    }

    // Implementación de la búsqueda de índice en un slice
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token)
    {
        // Verificar que recibimos exactamente 2 argumentos
        if (args.Count != 2)
        {
            throw new SemanticError("ERROR: slices.Index espera exactamente 2 argumentos", token);
        }
        
        // Verificar que el primer argumento es un slice (instancia con nombre que comienza con [])
        if (!(args[0] is InstanciaValue sliceInstanciaValue) || 
            !sliceInstanciaValue.instancia.GetTypeName().StartsWith("[]"))
        {
            throw new SemanticError("ERROR: El primer argumento de slices.Index debe ser un slice", token);
        }
        
        // Obtener la instancia del slice y el valor a buscar
        var sliceInstancia = sliceInstanciaValue.instancia;
        var valorBuscado = args[1];
        
        // Obtener la longitud del slice desde la propiedad "length"
        if (!sliceInstancia.values.TryGetValue("length", out ValueWrapper lengthWrapper) || 
            !(lengthWrapper is IntValue lengthValue))
        {
            throw new SemanticError("ERROR: No se pudo determinar la longitud del slice", token);
        }
        
        int length = lengthValue.Value;
        
        // Buscar el valor en el slice, iterando por cada índice
        for (int i = 0; i < length; i++)
        {
            string indiceStr = i.ToString();
            
            // Verificar si el índice existe en el diccionario de valores
            if (!sliceInstancia.values.TryGetValue(indiceStr, out ValueWrapper elemento))
            {
                continue;
            }
            
            // Verificar si es el valor buscado comparando por tipo y valor
            if (ValoresIguales(elemento, valorBuscado))
            {
                // Encontramos una coincidencia, devolver el índice
                return new IntValue(i);
            }
        }
        
        // Si no se encuentra ninguna coincidencia, devolver -1
        return new IntValue(-1);
    }
    
    // Método auxiliar para comparar valores de diferentes tipos
    private bool ValoresIguales(ValueWrapper a, ValueWrapper b)
    {
        // Si son de diferentes tipos, hacer algunas verificaciones especiales
        if (a.GetType() != b.GetType())
        {
            // Caso especial: permitir comparación entre int y float
            if ((a is IntValue intA && b is FloatValue floatB && intA.Value == floatB.Value) ||
                (a is FloatValue floatA && b is IntValue intB && floatA.Value == intB.Value))
            {
                return true;
            }
            return false;
        }
        
        // Comparar según el tipo específico
        return (a, b) switch
        {
            (IntValue intA, IntValue intB) => intA.Value == intB.Value,
            (FloatValue floatA, FloatValue floatB) => floatA.Value == floatB.Value,
            (StringValue strA, StringValue strB) => strA.Value == strB.Value,
            (BoolValue boolA, BoolValue boolB) => boolA.Value == boolB.Value,
            (RuneValue runeA, RuneValue runeB) => runeA.Value == runeB.Value,
            // Para otros tipos (como objetos complejos), consideramos que no son iguales
            _ => false
        };
    }
}



/*
    Implementación de la función embebida strings.Join
    
    Propósito: Unir todos los elementos de un slice de cadenas ([]string) en una sola cadena
    
    Comportamiento:
    - Acepta exactamente 2 parámetros:
      1. Un slice de tipo []string
      2. Un separador de tipo string
    - Devuelve un StringValue con todos los elementos del slice unidos por el separador
    - Genera error si el primer argumento no es un slice de tipo []string
    - Genera error si el segundo argumento no es un string
    
    Ejemplos:
    - strings.Join([]string{"hola", "mundo", "go"}, " ") -> "hola mundo go"
    - strings.Join([]string{"a", "b", "c"}, ",") -> "a,b,c"
*/
public class JoinEmbeded : Invocable
{
    // Especifica que esta función espera exactamente 2 argumentos
    public int Arity()
    {
        return 2;
    }

    // Implementación de la unión de elementos de un slice
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token)
    {
        // Verificar que recibimos exactamente 2 argumentos
        if (args.Count != 2)
        {
            throw new SemanticError("ERROR: strings.Join espera exactamente 2 argumentos", token);
        }
        
        // Verificar que el primer argumento es un slice
        if (!(args[0] is InstanciaValue sliceInstanciaValue) || 
            !sliceInstanciaValue.instancia.GetTypeName().StartsWith("[]"))
        {
            throw new SemanticError("ERROR: El primer argumento de strings.Join debe ser un slice", token);
        }
        
        // Verificar que el slice es de tipo []string
        var sliceInstancia = sliceInstanciaValue.instancia;
        if (!sliceInstancia.GetTypeName().Equals("[]string"))
        {
            throw new SemanticError("ERROR: strings.Join solo puede usarse con slices de tipo []string", token);
        }
        
        // Verificar que el segundo argumento es un string
        if (!(args[1] is StringValue separatorValue))
        {
            throw new SemanticError("ERROR: El segundo argumento de strings.Join debe ser una cadena", token);
        }
        
        string separador = separatorValue.Value;
        
        // Obtener la longitud del slice desde la propiedad "length"
        if (!sliceInstancia.values.TryGetValue("length", out ValueWrapper lengthWrapper) || 
            !(lengthWrapper is IntValue lengthValue))
        {
            throw new SemanticError("ERROR: No se pudo determinar la longitud del slice", token);
        }
        
        int length = lengthValue.Value;
        
        // Recolectar todos los elementos como strings
        List<string> elementos = new List<string>();
        
        for (int i = 0; i < length; i++)
        {
            string indiceStr = i.ToString();
            
            // Verificar si el índice existe en el diccionario de valores
            if (!sliceInstancia.values.TryGetValue(indiceStr, out ValueWrapper elemento))
            {
                continue;
            }
            
            // Verificar que el elemento es un string
            if (!(elemento is StringValue stringElemento))
            {
                throw new SemanticError($"ERROR: El elemento en la posición {i} del slice no es una cadena", token);
            }
            
            elementos.Add(stringElemento.Value);
        }
        
        // Unir todos los elementos con el separador
        string resultado = string.Join(separador, elementos);
        
        // Devolver el resultado como un StringValue
        return new StringValue(resultado);
    }
}



/*
    Implementación de la función embebida len
    
    Propósito: Obtener la cantidad de elementos en un slice
    
    Comportamiento:
    - Acepta exactamente 1 parámetro que debe ser un slice (instancia de tipo []T o [][]T)
    - Devuelve un IntValue con la cantidad de elementos en el nivel superior del slice
    - Funciona con slices de una dimensión (ej: []int) y matrices (ej: [][]int)
    - Para accesos a elementos de matrices como matrizIrregular[1], devuelve la longitud
      del slice específico accedido
    - Genera error si el argumento no es un slice
    
    Ejemplos:
    - len([]int{1, 2, 3, 4, 5}) -> 5
    - len([][]int{{1, 2}, {3, 4, 5}}) -> 2
    - len(matriz[0]) -> longitud del primer slice dentro de la matriz
*/
public class LenEmbeded : Invocable
{
    // Especifica que esta función espera exactamente 1 argumento
    public int Arity()
    {
        return 1;
    }

    // Implementación para obtener la longitud de un slice
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token)
    {
        // Verificar que recibimos exactamente 1 argumento
        if (args.Count != 1)
        {
            throw new SemanticError("ERROR: La función len espera exactamente 1 argumento", token);
        }
        
        // Verificar que el argumento es un slice (debe ser una instancia)
        if (!(args[0] is InstanciaValue sliceInstanciaValue))
        {
            throw new SemanticError("ERROR: La función len requiere un slice como argumento", token);
        }
        
        // Verificar que es realmente un slice (su nombre de tipo debe comenzar con [])
        var sliceInstancia = sliceInstanciaValue.instancia;
        string tipoNombre = sliceInstancia.GetTypeName();
        
        if (!tipoNombre.StartsWith("[]"))
        {
            throw new SemanticError($"ERROR: La función len no puede usarse con valores de tipo '{tipoNombre}', solo con slices", token);
        }
        
        // Obtener la longitud del diccionario de valores
        // Los slices almacenan su longitud en la propiedad "length"
        if (!sliceInstancia.values.TryGetValue("length", out ValueWrapper lengthWrapper) || 
            !(lengthWrapper is IntValue lengthValue))
        {
            throw new SemanticError("ERROR: No se pudo determinar la longitud del slice (propiedad 'length' no encontrada)", token);
        }
        
        // Devolver la longitud como un IntValue
        return lengthValue;
    }
}




/*
    Implementación de la función embebida append
    
    Propósito: Agregar elementos a un slice, devolviendo un nuevo slice con los elementos añadidos
    
    Comportamiento:
    - Acepta al menos 2 argumentos:
      1. Un slice (debe ser una instancia de tipo []T)
      2. Uno o más elementos a agregar, compatibles con el tipo del slice
    - Devuelve un nuevo slice con todos los elementos (originales + nuevos)
    - Funciona con slices de una dimensión (ej: []int) y matrices (ej: [][]int)
    - Puede agregar un slice completo a otro slice si los tipos son compatibles
    - Valida la compatibilidad de tipos entre el slice y los elementos a agregar
    
    Ejemplos:
    - append([]int{1, 2, 3}, 4) -> []int{1, 2, 3, 4}
    - append([][]int{{1, 2}, {3, 4}}, []int{5, 6}) -> [][]int{{1, 2}, {3, 4}, {5, 6}}
    - append(matriz[1], 3) -> agrega 3 al slice en la posición 1 de la matriz
*/
public class AppendEmbeded : Invocable
{
    // Aridad variable: al menos 2 argumentos (slice + al menos un elemento a agregar)
    public int Arity()
    {
        return 2; // Mínimo 2 argumentos, pero puede aceptar más
    }

    // Implementación para agregar elementos a un slice
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token)
    {
        // Verificar que recibimos al menos 2 argumentos
        if (args.Count < 2)
        {
            throw new SemanticError("ERROR: La función append espera al menos 2 argumentos (slice y elemento(s) a agregar)", token);
        }
        
        // Verificar que el primer argumento es un slice (debe ser una instancia)
        if (!(args[0] is InstanciaValue sliceInstanciaValue))
        {
            throw new SemanticError("ERROR: El primer argumento de append debe ser un slice", token);
        }
        
        // Verificar que es realmente un slice (su nombre de tipo debe comenzar con [])
        var sliceInstancia = sliceInstanciaValue.instancia;
        string tipoNombre = sliceInstancia.GetTypeName();
        
        if (!tipoNombre.StartsWith("[]"))
        {
            throw new SemanticError($"ERROR: La función append no puede usarse con valores de tipo '{tipoNombre}', solo con slices", token);
        }
        
        // Obtener la longitud del slice original
        if (!sliceInstancia.values.TryGetValue("length", out ValueWrapper lengthWrapper) || 
            !(lengthWrapper is IntValue lengthValue))
        {
            throw new SemanticError("ERROR: No se pudo determinar la longitud del slice (propiedad 'length' no encontrada)", token);
        }
        
        int longitudOriginal = lengthValue.Value;
        
        // Extraer el tipo base del slice (por ejemplo, "int" de "[]int" o "[]int" de "[][]int")
        string tipoBase = tipoNombre.Substring(2); // Eliminar los primeros dos caracteres "[]"
        
        // Crear un nuevo diccionario para el slice resultante
        Dictionary<string, ValueWrapper> nuevosDatos = new Dictionary<string, ValueWrapper>();
        
        // Copiar todos los elementos del slice original
        for (int i = 0; i < longitudOriginal; i++)
        {
            if (sliceInstancia.values.TryGetValue(i.ToString(), out ValueWrapper valor))
            {
                nuevosDatos.Add(i.ToString(), valor);
            }
        }
        
        // Variable para contar cuántos elementos nuevos hemos agregado
        int elementosAgregados = 0;
        
        // Procesar cada elemento a agregar (args[1] en adelante)
        for (int argIndex = 1; argIndex < args.Count; argIndex++)
        {
            ValueWrapper elementoAAgregar = args[argIndex];
            
            // Caso especial: Agregar un slice completo a otro slice
            if (elementoAAgregar is InstanciaValue otroSliceInstancia && 
                otroSliceInstancia.instancia.GetTypeName().StartsWith("[]"))
            {
                // Verificar compatibilidad de tipos entre slices
                string otroTipoBase = otroSliceInstancia.instancia.GetTypeName().Substring(2);
                
                // Si estamos agregando a un slice de slices (matriz)
                if (tipoNombre.StartsWith("[][]"))
                {
                    // Verificar que el slice a agregar coincida con el tipo esperado
                    if (!otroSliceInstancia.instancia.GetTypeName().Equals(tipoBase))
                    {
                        throw new SemanticError(
                            $"ERROR: No se puede agregar un slice de tipo '{otroSliceInstancia.instancia.GetTypeName()}' " +
                            $"a un slice de tipo '{tipoNombre}'. Los tipos deben ser compatibles.", token);
                    }
                    
                    // Agregar el slice completo como un nuevo elemento
                    nuevosDatos.Add((longitudOriginal + elementosAgregados).ToString(), elementoAAgregar);
                    elementosAgregados++;
                }
                // Si estamos agregando elementos individuales de un slice a otro slice
                else
                {
                    // Verificar que ambos slices son del mismo tipo base
                    if (!otroTipoBase.Equals(tipoBase))
                    {
                        throw new SemanticError(
                            $"ERROR: No se pueden agregar elementos de un slice de tipo '[]{ otroTipoBase}' " +
                            $"a un slice de tipo '{tipoNombre}'. Los tipos deben ser compatibles.", token);
                    }
                    
                    // Obtener la longitud del otro slice
                    if (!otroSliceInstancia.instancia.values.TryGetValue("length", out ValueWrapper otroLengthWrapper) || 
                        !(otroLengthWrapper is IntValue otroLengthValue))
                    {
                        throw new SemanticError("ERROR: No se pudo determinar la longitud del slice a agregar", token);
                    }
                    
                    int otroLongitud = otroLengthValue.Value;
                    
                    // Agregar cada elemento del otro slice al nuevo slice
                    for (int j = 0; j < otroLongitud; j++)
                    {
                        if (otroSliceInstancia.instancia.values.TryGetValue(j.ToString(), out ValueWrapper otroValor))
                        {
                            nuevosDatos.Add((longitudOriginal + elementosAgregados).ToString(), otroValor);
                            elementosAgregados++;
                        }
                    }
                }
            }
            // Caso normal: Agregar un elemento individual
            else
            {
                // Verificar compatibilidad de tipos para el elemento a agregar
                bool compatible = false;
                
                // Si es un slice de slices (matriz)
                if (tipoNombre.StartsWith("[][]"))
                {
                    // Solo permitimos agregar slices completos como elementos
                    compatible = elementoAAgregar is InstanciaValue instanciaValor && 
                                instanciaValor.instancia.GetTypeName().Equals(tipoBase);
                }
                // Si es un slice de tipos primitivos
                else
                {
                    switch (tipoBase)
                    {
                        case "int":
                            compatible = elementoAAgregar is IntValue;
                            break;
                        case "float64":
                            compatible = elementoAAgregar is FloatValue || elementoAAgregar is IntValue; // Permitir conversión implícita int -> float64
                            break;
                        case "string":
                            compatible = elementoAAgregar is StringValue;
                            break;
                        case "bool":
                            compatible = elementoAAgregar is BoolValue;
                            break;
                        case "rune":
                            compatible = elementoAAgregar is RuneValue;
                            break;
                    }
                }
                
                if (!compatible)
                {
                    throw new SemanticError(
                        $"ERROR: No se puede agregar un valor de tipo '{elementoAAgregar.GetType().Name}' " +
                        $"a un slice de tipo '{tipoNombre}'. Los tipos deben ser compatibles.", token);
                }
                
                // Realizar conversión implícita de int a float64 si es necesario
                if (tipoBase == "float64" && elementoAAgregar is IntValue intValue)
                {
                    elementoAAgregar = new FloatValue(intValue.Value);
                }
                
                // Agregar el elemento al nuevo slice
                nuevosDatos.Add((longitudOriginal + elementosAgregados).ToString(), elementoAAgregar);
                elementosAgregados++;
            }
        }
        
        // Actualizar la propiedad length del nuevo slice
        nuevosDatos["length"] = new IntValue(longitudOriginal + elementosAgregados);
        
        // Crear y devolver el nuevo slice
        var nuevoSlice = new Instancia(tipoNombre, nuevosDatos);
        return new InstanciaValue(nuevoSlice);
    }
}


/*
public class PrintEmbeded : Invocable
{

    public int Arity()
    {
        return 1;
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        var output = "";
        foreach (var arg in args)
        {
            output += arg switch
            {
                IntValue i => i.Value.ToString(),
                FloatValue f => f.Value.ToString(),
                StringValue s => s.Value,
                BoolValue b => b.Value.ToString(),
                RuneValue r => Convert.ToByte(r.Value).ToString(),
                VoidValue v => "void",
                FuncionValue fn => "-> fn " + fn.name + " <-",
                StructValue st => st.Nombre,
                InstanciaValue ins => ins.instancia.GetTypeName(),
                NilValue nulo => "<nil>",
                _ => throw new SemanticError("ERROR: tipo de valor no valido", null)

            };
            
        }
        output += "\n";
        visitor.output += output;

        return visitor.defaultValue;
    }
}

*/