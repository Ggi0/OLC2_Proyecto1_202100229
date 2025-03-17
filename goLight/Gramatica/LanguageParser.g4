parser grammar LanguageParser;

options { tokenVocab=LanguageLexer; }  // Importa los tokens del lexer

program: dcl*;

dcl: varDcl // |classDcl | structDcl
    | funcionDcl 
    | statement // stamtement No declarativo

;

varDcl: VAR ID tiposD IGUAL expr SEMICOLON # varDcl1
        | VAR ID tiposD SEMICOLON          # varDcl2
        | ID DCLIMPL expr SEMICOLON        # varDcl3
;

funcionDcl: STFUNC ID LPAREN parametrosF? RPAREN tiposD? LBRACE dcl* RBRACE
;

parametrosF: ID tiposD (COMMA ID tiposD)*
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
    | INT                                                # Int
    | FLOAT                                              # Float
    | STRING                                             # String
    | BOOL                                               # Bool
    | RUNE                                               # Rune
    | ID op=(IGUAL | ASIGSUM | ASIGMIN) expr             # AssignVar 
    | ID op=(INCREMENTO |DECREMENTO)                     # UpdateVar
    | ID                                                 # Identifier
    | LPAREN expr RPAREN                                 # Parens
;

call: LPAREN parametros? RPAREN
;

parametros: expr (COMMA expr)*
;

tiposD: T_INT
        |T_FLOAT
        |T_STR
        |T_BOOL
        |T_RUNE
;
