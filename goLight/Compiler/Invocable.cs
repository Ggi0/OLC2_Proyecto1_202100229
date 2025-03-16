
// interfas para las funciones

public interface Invocable{
    int Arity(); // ---> numero de parametros para la funcion
    
    /*
        List<ValueWrapper> args --> lista de parametros
        CompilerVisitor visitor --> referencia al Visitor
            -->  almacenar el bloque de la funcion y cuando se requiera devolverla.
    */
    ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor);
}