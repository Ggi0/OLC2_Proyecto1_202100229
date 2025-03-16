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
        env.DeclaracionVar("time", new FuncionValue(new TimeEmbeded(), "time"), null);
    }
}

public class TimeEmbeded : Invocable{
    public int Arity() => 0;

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor){
        return new StringValue(DateTime.Now.ToString());
    }
}