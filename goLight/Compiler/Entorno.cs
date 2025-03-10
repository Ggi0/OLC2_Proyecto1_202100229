

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

        if(parent != null){
            return parent.AsignarVar(id, value);
        }
        throw new Exception("Variable " + id + " not found");

    }
}