parser grammar LanguageParser;

options { tokenVocab=LanguageLexer; }  // Importa los tokens del lexer

program: dcl*;

dcl: varDcl // |funcDcl |classDcl | structDcl
   | statement // stamtement No declarativo
;

varDcl: VAR ID IGUAL expr SEMICOLON
;

statement: expr SEMICOLON      # ExprStmt
         | PRINT LPAREN expr RPAREN SEMICOLON # PrintStmt
;

expr:
    MENOS expr                    # NegateU
    | expr op=(MULTI | DIV) expr  # MulDiv
    | expr op=(MAS | MENOS) expr  # AddSub
    | INT                         # Int
    | FLOAT                       # Float
    | STRING                      # String
    | BOOL                        # Bool
    | RUNE                        # Rune
    | ID IGUAL expr               # Assign
    | ID                          # Identifier
    | LPAREN expr RPAREN          # Parens
;
