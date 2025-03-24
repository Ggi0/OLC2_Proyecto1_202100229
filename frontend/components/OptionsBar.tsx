'use client';
import { useRef } from 'react';

export default function OptionsBar({ onFileContent }) {
    const fileInputRef = useRef(null);

    const handleOptionChange = (e) => {
        if (e.target.value === "option1") {
            // Activar el selector de archivos
            fileInputRef.current.click();
        }
        else if (e.target.value === "option2") {
            // Abrir el archivo HTML de tabla de símbolos en una nueva ventana o pestaña
            window.open("/Users/gio/Desktop/compi2_1s25/LAB_compi2/proyecto1/OLC2_Proyecto1_202100229/goLight/tablaSimbolos.html", "_blank");
        }
    };

    const handleFileChange = (e) => {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = (event) => {
                // Pasar el contenido del archivo al componente padre
                onFileContent(event.target.result);
            };
            reader.readAsText(file);
        }
    };

    return (
        <div className="p-4 flex justify-right gap-4">
            <select 
                className="p-2 border rounded"
                onChange={handleOptionChange}
                defaultValue=""
            >
                <option value="" disabled>Selecciona una opción</option>
                <option value="option1">Abrir archivo</option>
                <option value="option2">Opción 2</option>
                <option value="option3">Opción 3</option>
            </select>
            <select className="p-2 border rounded">
                <option value="optionA">Opción A</option>
                <option value="optionB">Opción B</option>
                <option value="optionC">Opción C</option>
            </select>
            
            {/* Input oculto para seleccionar archivos */}
            <input 
                type="file" 
                ref={fileInputRef} 
                style={{ display: 'none' }} 
                onChange={handleFileChange}
                accept=".glt"
            />
        </div>
    );
}