grammar Cmm;	

program: REAL_CONSTANT+
       ;

ID:                 ('_' | LETTER) ('_' | LETTER | [0-9])*
                    ;

CHAR_CONSTANT:      '\'' ( . | '\\' INT_CONSTANT | '\\' 'n' | '\\' 't' ) '\''
                    ;

REAL_CONSTANT:      INT_CONSTANT? '.' [0-9]+ EXPONENT?
                    | INT_CONSTANT '.' [0-9]* EXPONENT?
                    | INT_CONSTANT EXPONENT?
                    ;

fragment EXPONENT:  [eE] [-+]? INT_CONSTANT
                    ;
  		 
INT_CONSTANT:       [1-9][0-9]*
                    | '0'
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