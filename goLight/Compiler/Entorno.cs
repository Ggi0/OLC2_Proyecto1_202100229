

public class Entorno{
    public Dictionary<string, ValueWrapper> variables= new Dictionary<string, ValueWrapper>();

    private Entorno? parent; // entorno padre, puede ser nulo

    public Entorno(Entorno? parent){
        // al construir un nuevo entorno se le puede mandar un padre si es necesario
        this.parent = parent;
    }

    // obtener una variable
    public ValueWrapper GetVariable(string id, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            return variables[id];
        }

        if (parent != null)
        {
            return parent.GetVariable(id, token);
        }

        throw new SemanticError($"ERROR: La variable {id} no existe", token);
    }

    // DECLARACION
    public void DeclaracionVar(string id, ValueWrapper value, Antlr4.Runtime.IToken? token)
    {
        if (variables.ContainsKey(id)){
            if (token != null) throw new SemanticError($"ERROR: Declaracion, la variable  {id} ya existe", token);
        }else{
            variables[id] = value;
        }
    }

    public ValueWrapper AsignarVar(string id, ValueWrapper valorNuevo, string op, Antlr4.Runtime.IToken token)
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
            return parent.AsignarVar(id, valorNuevo, op, token);
        }

        throw new SemanticError($"ERROR: No se puede ASIGNAR el valor a la variable \"{id}\" porque no existe.", token);
    }


    //para verificar si el tipo de la asignación es válido.
    private bool TiposCompatibles(ValueWrapper existente, ValueWrapper nuevo)
    {
        return existente.GetType() == nuevo.GetType() // Tipos exactamente iguales
            || (existente is FloatValue && nuevo is IntValue); // Permitir int -> float64
    }

}