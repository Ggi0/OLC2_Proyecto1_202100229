


using System.Diagnostics.Metrics;
using analyzer;
using Microsoft.AspNetCore.SignalR.Protocol;

public class StructsDef : Invocable
{

    // nombre de la clase (Struct)
    public string Name { get; set; }

    // un Diccionario --> nombre de la propiedad y que es lo que hace referencia (el contexto de la declaracion de la variable)
    public Dictionary<string, LanguageParser.VarDcl1Context> Atributos { get; set; }
    public Dictionary<string, FuncionForanea> Methods { get; set; }

    // constructor
    public StructsDef(string name,
                       Dictionary<string, LanguageParser.VarDcl1Context> atributos,
                       Dictionary<string, FuncionForanea> methods)
    {
        Name = name;
        Atributos = atributos;
        Methods = methods;
    }

    

    // un metodo que ayuda a buscar metodos --> recibe el nombre del metodo 
    public FuncionForanea? GetMethod(string name){

        if (Methods.ContainsKey(name)){
            // si lo contiene lo regresa 
            return Methods[name];
        }
        // de lo contrario regresa null
        return null;
    }

    // ---> definir la arity
    public int Arity(){
        // si hay un contructor definido:
        var constructor = GetMethod("constructor");

        if (constructor != null){
            // se retorna la arity del constructor:
            return constructor.Arity();

        }

        return 0;
    }

    // validar el invoke
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor){
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
}