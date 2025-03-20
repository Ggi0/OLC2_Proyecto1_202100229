parser grammar LanguageParser;

options { tokenVocab=LanguageLexer; }  // Importa los tokens del lexer

program: dcl*;

// |classDcl | structDcl
dcl: varDcl | funcionDcl | statement | structDcl // stamtement No declarativo
;

varDcl: VAR ID ID SEMICOLON                 # varDclStruct //La producción varDclStruct manejará la declaración de variables de tipo struct
        |VAR ID tiposD IGUAL expr SEMICOLON # varDcl1
        | VAR ID tiposD SEMICOLON          # varDcl2
        | ID DCLIMPL expr SEMICOLON        # varDcl3
;

funcionDcl: STFUNC ID LPAREN parametrosF? RPAREN tiposD? LBRACE dcl* RBRACE
;

parametrosF: ID tiposD (COMMA ID tiposD)*
;

// -------- structs declaracion ---------------
structDcl : STTYPE ID STRUCT LBRACE atriBody* RBRACE 
;

atriBody : ID (tiposD | ID)
;

statement: expr (SEMICOLON)?                                         # ExprStmt
         | FMT DOT PRINT LPAREN expr RPAREN (SEMICOLON)?             # PrintStmt
         | LBRACE dcl* RBRACE                                        # Bloque
         | IF (LPAREN)? expr (RPAREN)? statement (ELSE statement)?   # IfStatement
         | SWITCH expr LBRACE (caseStmt)+ RBRACE                     # SwitchStmt
         | FOR (LPAREN)? expr (RPAREN)? statement                    # WhileStmt
         | FOR (LPAREN)? forInit expr SEMICOLON expr (RPAREN)? statement   # ForStmt
         | STBREAK (SEMICOLON)?           # ST_break
         | STCONTINUE (SEMICOLON)?        # ST_continue
         | STRETURN expr? (SEMICOLON)?    # ST_return
;

forInit: varDcl 
        | expr SEMICOLON
;

// para el switch
caseStmt: CASE expr COLON dcl*    # caseNormal
          | DEFAUL COLON dcl*     # caseDefault
;


expr:
    op=(MENOS | NOT) expr                                # NegateU
    | expr call+ # Llamada
    | expr op=(MULTI | DIV | MODULO) expr                # MulDiv
    | expr op=(MAS | MENOS) expr                         # AddSub
    | expr op=(MAYOR | MAYIGUAL | MENOR | MENIGUAL) expr    # Relacionales
    | expr op=(EQUALS | DIFF) expr                       # Comparation
    | expr AND expr                                      # And
    | expr OR expr                                       # Or
    | expr op=(IGUAL | ASIGSUM | ASIGMIN) expr             # AssignVar // estoy cambiando el ID por un expr --> para las llamadas
    | ID op=(INCREMENTO |DECREMENTO)                     # UpdateVar
    | ID DCLIMPL ID LBRACE (initAttr COMMA (initAttr COMMA )*)* RBRACE  # NewStructInit //manejará la inicialización con valores
    | INT                                                # Int
    | FLOAT                                              # Float
    | STRING                                             # String
    | BOOL                                               # Bool
    | RUNE                                               # Rune
    | NUEVO ID LPAREN parametros? RPAREN # NewInstan // hacer la instacia de una clase -> id hace referencia a la clase
    | ID                                                 # Identifier
    | LPAREN expr RPAREN                                 # Parens
;

// declaracion de funcion    o    acceso a una propiedad por punto
call: LPAREN parametros? RPAREN # FuncCall | DOT ID # GetAtr
;

parametros: expr (COMMA expr)*
;


// Inicialización de un atributo
initAttr: ID COLON expr;

tiposD: T_INT
        |T_FLOAT
        |T_STR
        |T_BOOL
        |T_RUNE
;
