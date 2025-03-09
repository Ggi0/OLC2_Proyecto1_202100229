lexer grammar LanguageLexer;

// Definición de tokens
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
WS: [ \t\r\n]+ -> skip;
