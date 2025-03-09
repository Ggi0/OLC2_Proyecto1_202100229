# OLC2_Proyecto1_202100229

Este proyecto es para desarrollar un intérprete para el lenguaje GoLight, inspirado en Go, usando C# y ANTLR. Se enfoca en análisis léxico, sintáctico y semántico, generación del AST y manejo de errores. Incluye la creación de una interfaz y gramática para GoLight

---

### Para ejecutar los analizadores:
desde la carpeta `Gramatica` ejecutar:

```bash
antlr4 -Dlanguage=CSharp -o ../analyzer -package analyzer -visitor ./*.g4
```

---

### Para levantar el servidor:
```bash
dotnet watch run
```