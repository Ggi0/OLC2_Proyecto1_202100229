using analyzer;
using System.Collections.Generic;

// Esta clase representa un tipo de slice y permite crear instancias de slices
public class SliceDef : Invocable
{
    // Tipo de los elementos del slice (int, float64, string, etc.)
    private string tipoElemento;
    
    // Referencia al StructsDef equivalente
    // Esto nos permite aprovechar la implementación existente para structs
    // y mantener la compatibilidad con el resto del sistema
    private StructsDef equivalentClass;

    // Constructor para slices
    public SliceDef(string tipoElemento)
    {
        this.tipoElemento = tipoElemento;
        
        // El nombre del tipo tiene la forma "[]tipo" (ej: []int, []string)
        string nombreTipo = "[]" + tipoElemento;
        
        // Creamos un StructsDef equivalente vacío
        // En lugar de usar attributes, usaremos índices numéricos como strings ("0", "1", "2")
        var indices = new Dictionary<string, (string, bool, bool)>();
        var metodos = new Dictionary<string, FuncionForanea>();
        
        // Creamos el StructsDef equivalente que nos permitirá usar la infraestructura existente
        equivalentClass = new StructsDef(nombreTipo, indices, metodos);
    }

    // Implementación de la interfaz Invocable: cuántos elementos puede tener el slice
    public int Arity()
    {
        // Un slice puede tener cualquier número de elementos
        return int.MaxValue;
    }

    // Método que se llama cuando se crea un slice - args son los elementos
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        Console.WriteLine($"\t (slice) -->   Creando slice de tipo '{tipoElemento}' con {args.Count} elementos");
        
        // Validar tipos de los elementos
        ValidarTiposElementos(args, visitor);
        
        // Crear una nueva instancia
        var valores = new Dictionary<string, ValueWrapper>();
        
        // Almacenar los elementos como propiedades con índices numéricos
        for (int i = 0; i < args.Count; i++)
        {
            valores.Add(i.ToString(), args[i]);
        }
        
        // Añadir la propiedad length para acceder al tamaño del slice
        valores.Add("length", new IntValue(args.Count));
        
        // Crear la instancia que representará al slice
        var sliceInstancia = new Instancia(equivalentClass.Name, valores);
        
        return new InstanciaValue(sliceInstancia);
    }
    
    // Validar que todos los elementos del slice sean del tipo correcto
    private void ValidarTiposElementos(List<ValueWrapper> elementos, CompilerVisitor visitor)
    {
        foreach (var elemento in elementos)
        {
            // Un slice puede contener tanto valores primitivos como otros slices del mismo tipo
            if (elemento is InstanciaValue instanciaValue)
            {
                // Si es una instancia, verificar si es un slice compatible
                if (instanciaValue.instancia.GetTypeName().StartsWith("[]"))
                {
                    // Extraer el tipo base del slice anidado
                    string tipoAnidado = instanciaValue.instancia.GetTypeName().Substring(2);
                    
                    // Verificar que el tipo sea compatible
                    if (tipoAnidado != tipoElemento)
                    {
                        throw new SemanticError(
                            $"ERROR: Se encontró un slice de tipo '[]{tipoAnidado}' dentro de un slice de tipo '[]{tipoElemento}'. " +
                            $"Los tipos deben coincidir.", null);
                    }
                }
                else
                {
                    // Si es otra instancia pero no un slice, es un error
                    throw new SemanticError(
                        $"ERROR: Se encontró una instancia de tipo '{instanciaValue.instancia.GetTypeName()}' " +
                        $"dentro de un slice de tipo '[]{tipoElemento}'. Solo se permiten valores primitivos " +
                        $"del tipo adecuado o slices anidados del mismo tipo.", null);
                }
            }
            else
            {
                // Verificar compatibilidad para tipos primitivos
                bool compatible = false;
                
                switch (tipoElemento)
                {
                    case "int":
                        compatible = elemento is IntValue;
                        break;
                    case "float64":
                        compatible = elemento is FloatValue || elemento is IntValue; // Permitir conversión implícita
                        break;
                    case "string":
                        compatible = elemento is StringValue;
                        break;
                    case "bool":
                        compatible = elemento is BoolValue;
                        break;
                    case "rune":
                        compatible = elemento is RuneValue;
                        break;
                }
                
                if (!compatible)
                {
                    throw new SemanticError(
                        $"ERROR: Se encontró un valor de tipo '{elemento.GetType().Name}' dentro de " +
                        $"un slice de tipo '[]{tipoElemento}'. Los tipos deben ser compatibles.", null);
                }
            }
        }
    }
}