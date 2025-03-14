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

  return (
    <div className="flex flex-col min-h-screen">
      <Header title="GoLight" />
      <OptionsBar />

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
        <div className="w-1/2 bg-black text-white p-4">
          <h2>Consola:</h2>
          <pre>{output}</pre>
        </div>
      </div>

      <div>
        {error && (
          <div className="error-container">
            <pre>{error}</pre>
          </div>
        )}
      </div>

      <div className="flex justify-center p-4">
        <button
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          onClick={handleExecute}
        >
          Ejecutar
        </button>
      </div>

      <Footer year={new Date().getFullYear()} author="Giovanni Concohá" />
    </div>
  );
}
