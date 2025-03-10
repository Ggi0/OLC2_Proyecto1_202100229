'use client';

export default function Header({ title }: { title: string }) {
    return (
        <header className="p-4 bg-gray-800 text-white text-center text-xl">
            {title}
        </header>
    );
}
