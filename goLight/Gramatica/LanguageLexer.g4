lexer grammar LanguageLexer;

// ---------------- TOKENS -------------
// ---> Simbolos delimitadores
LPAREN    : '(' ;
RPAREN    : ')' ;
LBRACE    : '{' ;
RBRACE    : '}' ;
LBRACKET  : '[' ;
RBRACKET  : ']' ;
SEMICOLON : ';' ;
DOT       : '.' ;
COLON     : ':' ;
COMMA     : ',' ;

// ---> Operadores aritmeticos
MAS        : '+'  ;
MENOS      : '-'  ;
MULTI      : '*'  ;
POTENCIA   : '^'  ;
DIV        : '/'  ;
MODULO     : '%'  ;

ASIGSUM    : '+=' ;
ASIGMIN    : '-=' ;
INCREMENTO : '++' ;
DECREMENTO : '--' ;

// ---> Operadores comparacion
IGUAL    : '='  ;
EQUALS   : '==' ;
DIFF     : '!=' ;

// ---> Operadores relacionales
MENOR    : '<'  ;
MENIGUAL : '<=' ;
MAYOR    : '>'  ;
MAYIGUAL : '>=' ;



// ---> Operadores logicos
OR   : '||' ;
AND  : '&&' ;
NOT  : '!'  ;

// ---> 
PRINT  : 'Println' ;
FMT    : 'fmt' ;
VAR    : 'var' ;
DCLIMPL: ':=' ;

// ---> sentencias de contro de flujo
IF     : 'if'      ;
ELSE   : 'else'    ;
SWITCH : 'switch'  ;
CASE   : 'case'    ;
DEFAUL : 'default' ;

// ---> ciclos
FOR : 'for';

// --> Sentecncias de transferencia
STBREAK    : 'break'    ;
STCONTINUE : 'continue' ;
STRETURN   : 'return'   ;

STFUNC : 'func'   ;

STRUCT : 'struct' ;
STTYPE : 'type'   ;
NUEVO  : 'new' ;


// --------- VALORES de datos ------------
INT: [0-9]+;              // entero
FLOAT: [0-9]+ '.' [0-9]+; // float64
STRING: '"' ( '\\' '"' | ~'"' )* '"' ; // cadena
BOOL: 'true' | 'false';   // Booleano
RUNE: '\'' ~'\''* '\'';   // Rune equivalente al Char

// --------- TIPOS de datos ------------
T_INT:   'int';
T_FLOAT: 'float64';
T_STR:   'string';
T_BOOL:  'bool';
T_RUNE:  'rune';

ID: [a-zA-Z][a-zA-Z0-9_]*;



// Espacios en blanco
WS:  [ \r\t\f\n]+ -> skip; 

// ---- COMENTARIOS ------
COMENT: '//' ~[\r\n]* -> skip;
MCOMENT: '/*' .*? '*/' -> skip;

