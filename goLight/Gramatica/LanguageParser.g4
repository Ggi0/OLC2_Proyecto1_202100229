parser grammar LanguageParser;

options { tokenVocab=LanguageLexer; }  // Importa los tokens del lexer

program: dcl*;

dcl: varDcl // |funcDcl |classDcl | structDcl
   | statement // stamtement No declarativo
;

varDcl: VAR ID tiposD IGUAL expr SEMICOLON # varDcl1
        | VAR ID tiposD SEMICOLON          # varDcl2
        | ID DCLIMPL expr SEMICOLON        # varDcl3
;

statement: expr SEMICOLON      # ExprStmt
         | FMT DOT PRINT LPAREN expr RPAREN SEMICOLON      # PrintStmt
         | LBRACE dcl* RBRACE  # Bloque
;


expr:
    MENOS expr                             # NegateU
    | expr op=(MULTI | DIV | MODULO) expr  # MulDiv
    | expr op=(MAS | MENOS) expr  # AddSub
    | expr op=(MAYOR | MAYIGUAL | MENOR | MENIGUAL) expr     # Relacionales
    | expr op=(EQUALS | DIFF) expr     # Comparation
    | INT                         # Int
    | FLOAT                       # Float
    | STRING                      # String
    | BOOL                        # Bool
    | RUNE                        # Rune
    | ID IGUAL expr               # AssignVar
    | ID                          # Identifier
    | LPAREN expr RPAREN          # Parens
;

tiposD: T_INT
        |T_FLOAT
        |T_STR
        |T_BOOL
        |T_RUNE
;
