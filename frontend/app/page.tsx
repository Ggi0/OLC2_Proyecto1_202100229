'use client';
import { Editor } from "@monaco-editor/react";
import { useState } from "react";

import Header from "@/components/Header";
import Footer from "@/components/Footer";
import OptionsBar from "@/components/OptionsBar";

export default function Home() {
  const API_URL = "http://localhost:5106"; // así se llama la API del back

  const [code, setCode] = useState<string>(""); // definir un estado
  const [output, setOutput] = useState<string>(""); // todo lo que resuelva la ejecucion del programa
  const [astSvg, setAstSvg] = useState<string>(""); // para guardar el SVG del AST
  const [activeTab, setActiveTab] = useState<"console" | "ast">("console"); // para controlar qué tab está activo

  const [error, setError] = useState<string>("");

  const handleExecute = async () => {
    try {
      const response = await fetch(`${API_URL}/compile`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ code }),
      });

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.error || "Error desconocido");
      }

      setOutput(data.result);
      setError("");
    } catch (err) {
      setOutput("");
      setError(err instanceof Error ? err.message : "Error desconocido");
    }
  };

  // Función para obtener y mostrar el AST
  const handleGetAst = async () => {
    try {
      const response = await fetch(`${API_URL}/compile/ast`, { // URL corregida
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ code }),
      });
  
      if (!response.ok) {
        const errorData = await response.json().catch(() => ({
          error: "Error desconocido en la respuesta del servidor",
        }));
        throw new Error(errorData.error);
      }
  
      // Como el backend devuelve SVG, usamos .text() en lugar de .json()
      const svgContent = await response.text();
      setAstSvg(svgContent);
      setActiveTab("ast");
      setError("");
    } catch (err) {
      setAstSvg("");
      setError(err instanceof Error ? err.message : "Error desconocido");
    }
  };
  

  // Nueva función para manejar el contenido del archivo
  const handleFileContent = (content) => {
    setCode(content);
  };

  return (
    <div className="flex flex-col min-h-screen">
      <Header title="GoLight" />
      <OptionsBar onFileContent={handleFileContent} />

      <div className="flex flex-1 p-4">
        <div className="w-1/2">
          <Editor
            height="70vh"
            defaultLanguage="go"
            theme="vs-dark"
            value={code}
            onChange={(value) => setCode(value || "")}
          />
        </div>
        <div className="w-1/2 flex flex-col">
          {/* Tabs para navegar entre consola y AST */}
          <div className="flex border-b">
            <button
              className={`py-2 px-4 ${activeTab === "console" ? "bg-gray-700 text-white" : "bg-gray-200"}`}
              onClick={() => setActiveTab("console")}
            >
              Consola
            </button>
            <button
              className={`py-2 px-4 ${activeTab === "ast" ? "bg-gray-700 text-white" : "bg-gray-200"}`}
              onClick={() => setActiveTab("ast")}
            >
              AST
            </button>
          </div>
          
          {/* Contenido de la pestaña activa */}
          {activeTab === "console" ? (
            <div className="bg-black text-white p-4 flex-1 overflow-auto">
              <h2>Consola:</h2>
              <pre>{output}</pre>
            </div>
          ) : (
            <div className="bg-white p-4 flex-1 overflow-auto">
              <h2 className="mb-2 text-black">Árbol de Sintaxis Abstracta:</h2>
              {astSvg ? (
                <div dangerouslySetInnerHTML={{ __html: astSvg }} />
              ) : (
                <p className="text-gray-500">No hay AST para mostrar. Haz clic en "Ver AST" para generarlo.</p>
              )}
            </div>
          )}
        </div>
      </div>

      <div>
        {error && (
          <div className="error-container bg-red-100 border border-red-400 text-red-700 p-2 rounded">
            <pre>{error}</pre>
          </div>
        )}
      </div>

      <div className="flex justify-center p-4 gap-4">
        <button
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          onClick={handleExecute}
        >
          Ejecutar
        </button>
        <button
          className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded"
          onClick={handleGetAst}
        >
          Ver AST
        </button>
      </div>

      <Footer year={new Date().getFullYear()} author="Giovanni Concohá" />
    </div>
  );
}