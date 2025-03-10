'use client';

export default function OptionsBar() {
    return (
        <div className="p-4 flex justify-right gap-4">
            <select className="p-2 border rounded">
                <option value="option1">Opción 1</option>
                <option value="option2">Opción 2</option>
                <option value="option3">Opción 3</option>
            </select>
            <select className="p-2 border rounded">
                <option value="optionA">Opción A</option>
                <option value="optionB">Opción B</option>
                <option value="optionC">Opción C</option>
            </select>
        </div>
    );
}
