lexer grammar LanguageLexer;

// Definición de TOKENS
VAR: 'var';
PRINT: 'print';
LPAREN: '(';
RPAREN: ')';
SEMICOLON: ';';
ASSIGN: '=';
PLUS: '+';
MINUS: '-';
MULTI: '*';
DIV: '/';

ID: [a-zA-Z]+;
INT: [0-9]+;
WS:  [ \r\t\f\n]+ -> skip; // Espacios en blanco

// ---- COMENTARIOS ------
COMENT: '//' ~[\r\n]* -> skip;
MCOMENT: '/*' .*? '*/' -> skip;

