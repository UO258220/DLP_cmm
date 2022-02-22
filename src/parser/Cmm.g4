grammar Cmm;

program:            definition* main_definition
                    ;

definition:         var_definition
                    | func_type '{' var_definition* statement* '}'
                    ;

main_definition:    'void' 'main' '(' ')' '{' var_definition* statement* '}'
                    ;

var_definition:     type ID ( ',' ID )* ';'
                    ;

type:               type '[' INT_CONSTANT ']'
                    | 'struct' '{' (type ID ';')+ '}'
                    | func_type
                    | return_type
                    ;

func_type:          return_type ID '(' ( built_in_type ID ( ',' built_in_type ID )* )? ')'
                    ;

return_type:        built_in_type
                    | 'void'
                    ;

built_in_type:      'double'
                    | 'int'
                    | 'char'
                    ;

statement:          ID '(' (expression (',' expression)*)? ')' ';'
                    | 'write' expression (',' expression)* ';'
                    | 'read' expression (',' expression)* ';'
                    | expression '=' expression ';'
                    | 'while' '(' expression ')' body
                    | 'if' '(' expression ')' body
                    | 'if' '(' expression ')' body 'else' body
                    | 'return' expression ';'
                    ;

body:               statement
                    | '{' statement* '}'
                    ;

expression:         '(' expression ')'
                    | expression '[' expression ']'
                    | expression '.' ID
                    | '(' built_in_type ')' expression
                    | '-' expression
                    | '!' expression
                    | expression ('*'|'/'|'%') expression
                    | expression ('+'|'-') expression
                    | expression ('>'|'>='|'<'|'<='|'!='|'==') expression
                    | expression ('&&'|'||') expression
                    | ID '(' (expression (',' expression)*)? ')'
                    | ID
                    | INT_CONSTANT
                    | CHAR_CONSTANT
                    | REAL_CONSTANT
                    ;

ID:                 ('_' | LETTER) ('_' | LETTER | [0-9])*
                    ;

INT_CONSTANT:       [1-9][0-9]*
                    | '0'
                    ;

CHAR_CONSTANT:      '\'' ( . | '\\' INT_CONSTANT | '\\' 'n' | '\\' 't' ) '\''
                    ;

REAL_CONSTANT:      INT_CONSTANT? '.' [0-9]+ EXPONENT?
                    | INT_CONSTANT '.' [0-9]* EXPONENT?
                    | INT_CONSTANT EXPONENT?
                    ;

fragment EXPONENT:  [eE] [-+]? INT_CONSTANT
                    ;

fragment LETTER:    [a-zA-Z]
                    ;

COMMENT:            ('//' .*? (EOL|EOF)
                    | '/*' .*? '*/')
                    -> skip
                    ;

EOL:                '\r'?'\n'
                    -> skip
                    ;

WS:                 [ \t\n\r]+
                    -> skip
                    ;