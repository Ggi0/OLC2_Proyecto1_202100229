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

---

# Frontend

### Para iniciar un proyecto
 crear una aplicación Next.js con React y Monaco Editor

## Configuración inicial

### 1. Crear proyecto Next.js
Ejecuta el siguiente comando para crear un nuevo proyecto Next.js:

```bash
npx create-next-app@latest
```

Durante la instalación, selecciona las siguientes opciones:
- TypeScript: **Sí**
- ESLint: **Sí**
- Tailwind CSS: **Sí**
- Directorio `/src`: **No**
- App Router: **Sí**
- Turbopack: **Sí**
- Import alias: **No**

### 2. Navegar al directorio del proyecto
```bash
cd nombre-de-tu-proyecto
```

### 3. Instalar dependencias
Usando npm:
```bash
npm install
```

O usando pnpm:
```bash
pnpm i
```

### 4. Instalar Monaco Editor
```bash
npm install @monaco-editor/react
```

## Ejecutar la aplicación
Para iniciar el servidor de desarrollo:

```bash
npm run dev
```

O si usas pnpm:
```bash
pnpm dev
```

Accede a tu aplicación en: http://localhost:3000
