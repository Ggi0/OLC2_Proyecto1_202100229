

// BreakException
public class BreakException : Exception{
    public BreakException(): base("Break statement"){

    }
}


// ContinueException
public class ContinueException : Exception{
    public ContinueException() : base("Continue statement"){

    }
}

// ReturnException ---> puede guardar un valor de forma interna por si se debe regresar algo
public class ReturnException : Exception
{
    // Evalúa la expresión del return si existe
    public ValueWrapper Value { get; }

    public ReturnException(ValueWrapper value) : base("Return statement"){
        Value = value;  // Asegúrate de que esta asignación esté presente
        
        // Para depuración
        Console.WriteLine($"DEBUG: ReturnException creada con valor: {value}");

    }

}