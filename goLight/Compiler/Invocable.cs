
/*
    interfas para las funciones

    Define una interfaz para todas las entidades que pueden ser invocadas (como funciones).

    Permite que diferentes tipos de funciones 
    por ejemplo, funciones definidas por el usuario y funciones nativas 
    compartan un mismo comportamiento.
*/ 

public interface Invocable{
    int Arity(); // ---> Retorna el número de parámetros que la función espera.
    
    /*
        List<ValueWrapper> args --> lista de parametros
        CompilerVisitor visitor --> referencia al Visitor
            -->  almacenar el bloque de la funcion y cuando se requiera devolverla.
    */
    ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor, Antlr4.Runtime.IToken token);
}