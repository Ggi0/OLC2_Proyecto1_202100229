parser grammar LanguageParser;

options { tokenVocab=LanguageLexer; }  // Importa los tokens del lexer

program: dcl*;

dcl: varDcl
   | statement 
;

varDcl: VAR ID ASSIGN expr SEMICOLON
;

statement: expr SEMICOLON      # ExprStmt
         | PRINT LPAREN expr RPAREN SEMICOLON # PrintStmt
;

expr:
    MINUS expr            # Negate
    | expr op=(MULTI | DIV) expr  # MulDiv
    | expr op=(PLUS | MINUS) expr # AddSub
    | INT                 # Number
    | ID                  # Identifier
    | LPAREN expr RPAREN  # Parens
;
