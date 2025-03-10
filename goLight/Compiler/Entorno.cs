

public class Entorno{
    public Dictionary<string, ValueWrapper> variables= new Dictionary<string, ValueWrapper>();

    // obtener una variable
    public ValueWrapper GetVariable(string id){
        if (variables.ContainsKey(id)){
            return variables[id];
        }else{
            throw new Exception("Variable " + id + "no existe");
        }
    }

    public void DeclaracionVar(string id, ValueWrapper value)
    {
        if (variables.ContainsKey(id)){
            throw new Exception("ERROR: La varible `" + id + " ya existe");
        }else{
            variables[id] = value;
        }
    }

    public ValueWrapper AsignarVar(string id, ValueWrapper value)
    {
        if (variables.ContainsKey(id))
        {
            variables[id] = value;
            return value;
        }
        throw new Exception("Variable " + id + " not found");

    }
}