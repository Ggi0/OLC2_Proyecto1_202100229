

public class Entorno{
    public Dictionary<string, ValueWrapper> variables= new Dictionary<string, ValueWrapper>();

    private Entorno? parent; // entorno padre, puede ser nulo

    public Entorno(Entorno? parent){
        // al construir un nuevo entorno se le puede mandar un padre si es necesario
        this.parent = parent;
    }

    // obtener una variable
    public ValueWrapper GetVariable(string id)
    {
        if (variables.ContainsKey(id))
        {
            return variables[id];
        }

        if (parent != null)
        {
            return parent.GetVariable(id);
        }

        throw new Exception("Variable " + id + "no existe");
    }

    public void DeclaracionVar(string id, ValueWrapper value)
    {
        if (variables.ContainsKey(id)){
            throw new Exception("ERROR: (Declaracion) La varible `" + id + " ya existe");
        }else{
            variables[id] = value;
        }
    }

    public ValueWrapper AsignarVar(string id, ValueWrapper valorNuevo, string op)
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
                        _ => throw new Exception($"ERROR: Operación `+=` no soportada entre {valorActual.GetType().Name} y {valorNuevo.GetType().Name}.")
                    },

                    "-=" => (valorActual, valorNuevo) switch
                    {   // var (float) = var - nuevoValor(float)
                        (IntValue intActual, IntValue intNuevo) => new IntValue(intActual.Value - intNuevo.Value),               // var (int) = var - nuevoValor(int)
                        (FloatValue floatActual, FloatValue floatNuevo) => new FloatValue(floatActual.Value - floatNuevo.Value), // var (float) = var - nuevoValor(float)
                        _ => throw new Exception($"ERROR: Operación `-=` no soportada entre {valorActual.GetType().Name} y {valorNuevo.GetType().Name}.")
                    },

                    "=" => valorNuevo,

                    _ => throw new Exception($"ERROR: Símbolo de asignación no reconocido `{op}`.")
                };

                variables[id] = nuevoValor;
                return nuevoValor;

            }
            else
            {
                throw new Exception($"ERROR: No se puede asignar un valor de tipo {valorNuevo.GetType().Name} a la variable {id} de tipo {valorActual.GetType().Name}.");
            }
        }

        // Si no está en el entorno actual, buscar en el entorno padre
        if (parent != null)
        {
            return parent.AsignarVar(id, valorNuevo, op);
        }

        throw new Exception($"ERROR: (asig) Variable {id} no existe.");
    }


    //para verificar si el tipo de la asignación es válido.
    private bool TiposCompatibles(ValueWrapper existente, ValueWrapper nuevo)
    {
        return existente.GetType() == nuevo.GetType() // Tipos exactamente iguales
            || (existente is FloatValue && nuevo is IntValue); // Permitir int -> float64
    }

}