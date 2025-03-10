'use client';

export default function Footer({ year, author }: { year: number, author: string }) {
    return (
        <footer className="p-4 bg-gray-800 text-white text-center text-sm">
            © {year} {author}
        </footer>
    );
}
