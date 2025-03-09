

public class Entorno{
    public Dictionary<string, int> variables= new Dictionary<string, int>();

    public int GetVariable(string id){
        if (variables.ContainsKey(id)){
            return variables[id];
        }else{
            throw new Exception("Variable " + id + "no existe");
        }
    }

    public void SetVariable(string id, int value){
        if(variables.ContainsKey(id)){
            // si la variable existe la sobreescribe
            // si hay que declara un Error Semantico si ya esta declarado una variable (aqui se hace)
            variables[id] = value;
        }else{
            variables.Add(id, value);
        }
    }
}