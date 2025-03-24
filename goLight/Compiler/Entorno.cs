

public class Entorno{
    public Dictionary<string, ValueWrapper> variables= new Dictionary<string, ValueWrapper>();

    private Entorno? parent; // entorno padre, puede ser nulo

    private static bool htmlInitialized = false;

    public Entorno(Entorno? parent){
        // al construir un nuevo entorno se le puede mandar un padre si es necesario
        this.parent = parent;

        /// Initialize HTML file if not done yet
        if (!htmlInitialized)
        {
            InitializeHtmlFile();
            htmlInitialized = true;
        }
    }

    // obtener una variable
    public ValueWrapper Get(string id, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            return variables[id];
        }

        if (parent != null)
        {
            return parent.Get(id, token);
        }

        throw new SemanticError($"ERROR: La variable {id} no existe", token);
    }

    // DECLARACION --> funciones, clases  y variables
    public void Declaracion(string id, ValueWrapper value, Antlr4.Runtime.IToken? token)
    {
        
        if (variables.ContainsKey(id)){
            if (token != null) throw new SemanticError($"ERROR: Declaracion, la variable  {id} ya existe", token);
        }else{
            Console.WriteLine($"Declaracion correcta -> id: {id}, valor: {value}");
            variables[id] = value;

            // Actualizar la tabla HTML si hay un token disponible
            if (token != null)
            {
                AppendToHtmlTable(id, value, token);
            }
        }
    }

    public ValueWrapper Asignacion(string id, ValueWrapper valorNuevo, string op, Antlr4.Runtime.IToken token)
    {
        // Buscar la variable en el entorno actual
        if (variables.ContainsKey(id))
        {
            ValueWrapper valorActual = variables[id]; // Obtener el valor actual de la variable

            // Validar si el tipo coincide o si es una conversión int -> float64
            if (TiposCompatibles(valorActual, valorNuevo))
            {

                // Si es una conversión implícita de int a float64, convertirlo antes de asignarlo
                if (valorActual is FloatValue && valorNuevo is IntValue intValue)
                {
                    valorNuevo = new FloatValue(intValue.Value); // Convertir int a float64
                }


                // Determinar el nuevo valor basado en el operador
                ValueWrapper nuevoValor = op switch
                {
                    "+=" => (valorActual, valorNuevo) switch
                    {   
                        (IntValue intActual, IntValue intNuevo) => new IntValue(intActual.Value + intNuevo.Value),               // var (int) = var + nuevoValor(int)
                        (FloatValue floatActual, FloatValue floatNuevo) => new FloatValue(floatActual.Value + floatNuevo.Value), // var (float) = var + nuevoValor(float)
                        (StringValue strActual, StringValue strNuevo) => new StringValue(strActual.Value + strNuevo.Value),      // var (str) = var + nuevoValor(str)
                        _ => throw new SemanticError($"ERROR: Operación `+=` no soportada entre {valorActual.GetType().Name} y {valorNuevo.GetType().Name}.", token)
                    },

                    "-=" => (valorActual, valorNuevo) switch
                    {   // var (float) = var - nuevoValor(float)
                        (IntValue intActual, IntValue intNuevo) => new IntValue(intActual.Value - intNuevo.Value),               // var (int) = var - nuevoValor(int)
                        (FloatValue floatActual, FloatValue floatNuevo) => new FloatValue(floatActual.Value - floatNuevo.Value), // var (float) = var - nuevoValor(float)
                        _ => throw new SemanticError($"ERROR: Operación `-=` no soportada entre {valorActual.GetType().Name} y {valorNuevo.GetType().Name}.", token)
                    },

                    "++" => valorActual switch
                    {   
                        IntValue intActual => new IntValue(intActual.Value + 1),               // var (int) = var + 1
                        _ => throw new SemanticError($"ERROR: Operación `++` no soportada valores tipo {valorActual.GetType().Name}", token)
                    },
                    "--" => valorActual switch
                    { 
                    IntValue intActual => new IntValue(intActual.Value - 1),               // var (int) = var + 1
                        _ => throw new SemanticError($"ERROR: Operación `--` no soportada valores tipo {valorActual.GetType().Name}", token)
                    },

                    "=" => valorNuevo,

                    _ => throw new SemanticError($"ERROR: Símbolo de asignación no reconocido `{op}`.", token)
                };

                variables[id] = nuevoValor;
                return nuevoValor;

            }
            else
            {
                throw new SemanticError($"ERROR: No se puede asignar un valor de tipo {valorNuevo.GetType().Name} a la variable \"{id}\" de tipo {valorActual.GetType().Name}.", token);
            }
        }

        // Si no está en el entorno actual, buscar en el entorno padre
        if (parent != null)
        {
            return parent.Asignacion(id, valorNuevo, op, token);
        }

        throw new SemanticError($"ERROR: No se puede ASIGNAR el valor a la variable \"{id}\" porque no existe.", token);
    }


    //para verificar si el tipo de la asignación es válido.
    private bool TiposCompatibles(ValueWrapper existente, ValueWrapper nuevo)
    {
        return existente.GetType() == nuevo.GetType() // Tipos exactamente iguales
            || (existente is FloatValue && nuevo is IntValue); // Permitir int -> float64
    }











private void InitializeHtmlFile()
    {
        string html = @"<!DOCTYPE html>
<html lang='es'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Tabla de Símbolos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            position: sticky;
            top: 0;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <h1>Tabla de Símbolos</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tipo</th>
                <th>Valor</th>
                <th>Columna</th>
                <th>Fila</th>
            </tr>
        </thead>
        <tbody id='tablaBody'>
            <!-- Aquí se agregarán las filas dinámicamente -->
        </tbody>
    </table>
</body>
</html>";

        File.WriteAllText("tablaSimbolos.html", html);
    }

    private void AppendToHtmlTable(string id, ValueWrapper value, Antlr4.Runtime.IToken token)
    {
        try
        {
            // Read the existing HTML file
            string htmlContent = File.ReadAllText("tablaSimbolos.html");
            
            // Get the type name in a more user-friendly format
            string typeName = GetFriendlyTypeName(value);
            
            // Create the new table row
            string newRow = $@"
            <tr>
                <td>{id}</td>
                <td>{typeName}</td>
                <td>{value}</td>
                <td>{token.Column}</td>
                <td>{token.Line}</td>
            </tr>";

            // Insert the new row before the closing tbody tag
            int insertPosition = htmlContent.IndexOf("</tbody>");
            if (insertPosition != -1)
            {
                htmlContent = htmlContent.Insert(insertPosition, newRow);
                File.WriteAllText("tablaSimbolos.html", htmlContent);
                Console.WriteLine($"Actualizada tabla de símbolos con {id}");
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error al actualizar la tabla de símbolos HTML: {ex.Message}");
        }
    }

    private string GetFriendlyTypeName(ValueWrapper value)
    {
        if (value is IntValue) return "int";
        if (value is FloatValue) return "float64";
        if (value is StringValue) return "string";
        if (value is BoolValue) return "bool";
        if (value is SliceValue) return "array";
        if (value is FuncionValue) return "function";
        // Add other types as needed
        return value.GetType().Name;
    }
}