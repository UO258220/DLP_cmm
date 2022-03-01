grammar Cmm;

@header {
    import program.*;
    import program.expression.*;
    import program.statements.*;
    import program.types.*;
}

program:            definition* main_definition EOF
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

statement returns [List<Statement> ast = new ArrayList<Statement>()]:
                    ID '(' arguments ')'
                        { $ast.add(new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine() + 1,
                        new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text), $arguments.ast)); }
                    | w='write' e1=expression
                        { $ast.add(new WriteStatement($w.getLine(), $w.getCharPositionInLine() + 1, $e1.ast)); }
                        (
                            ',' e2=expression
                            { $ast.add(new WriteStatement($w.getLine(), $w.getCharPositionInLine() + 1, $e2.ast)); }
                        )*
                        ';'
                    | r='read' e1=expression
                        { $ast.add(new ReadStatement($r.getLine(), $r.getCharPositionInLine() + 1, $e1.ast)); }
                        (
                            ',' e2=expression
                            { $ast.add(new ReadStatement($r.getLine(), $r.getCharPositionInLine() + 1, $e2.ast)); }
                        )*
                        ';'
                    | e1=expression '=' e2=expression ';'
                        { $ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast)); }
                    | w='while' '(' e1=expression ')' body
                        { $ast.add(new While($w.getLine(), $w.getCharPositionInLine() + 1, $e1.ast, $body.ast)); }
                    | i='if' '(' e1=expression ')' b1=body
                        { $ast.add(new IfElse($i.getLine(), $i.getCharPositionInLine() + 1, $e1.ast, $b1.ast)); }
                    | i='if' '(' e1=expression ')' b1=body 'else' b2=body
                        { $ast.add(new IfElse($i.getLine(),
                        $i.getCharPositionInLine() + 1, $e1.ast, $b1.ast, $b2.ast)); }
                    | 'return' e1=expression
                        { $ast.add(new ReturnStatement($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast)); }
                        ';'
                    ;

body returns [List<Statement> ast = new ArrayList<Statement>()]:
                    s1=statement { $s1.ast.forEach(s -> $ast.add(s)); }
                    | '{' (
                        s2=statement { $s2.ast.forEach(s -> $ast.add(s)); }
                    )* '}'
                    ;

expression returns [Expression ast]:
                    '(' e1=expression ')' { $ast = $e1.ast; }
                    | e1=expression '[' e2=expression ']'
                        { $ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast); }
                    | e1=expression '.' ID
                        { $ast = new FieldAccess($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $ID.text); }
                    | '(' built_in_type ')' expression
                        // TODO
                    | '-' e1=expression
                        { $ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast); }
                    | '!' e1=expression
                        { $ast = new Negation($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast); }
                    | e1=expression op=('*'|'/'|'%') e2=expression
                        { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
                    | e1=expression op=('+'|'-') e2=expression
                        { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
                    | e1=expression op=('>'|'>='|'<'|'<='|'!='|'==') e2=expression
                        { $ast = new Comparison($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
                    | e1=expression op=('&&'|'||') e2=expression
                        { $ast = new Logical($e1.ast.getLine(), $e1.ast.getColumn(), $op.text, $e1.ast, $e2.ast); }
                    | ID '(' arguments ')'
                        { $ast = new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine() + 1,
                        new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text), $arguments.ast); }
                    | ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text); }
                    | ic=INT_CONSTANT { $ast = new IntLiteral($ic.getLine(), $ic.getCharPositionInLine() + 1,
                        LexerHelper.lexemeToInt($ic.text)); }
                    | cc=CHAR_CONSTANT { $ast = new CharLiteral($cc.getLine(), $cc.getCharPositionInLine() + 1,
                        LexerHelper.lexemeToChar($cc.text)); }
                    | rc=REAL_CONSTANT { $ast = new RealLiteral($rc.getLine(), $rc.getCharPositionInLine() + 1,
                        LexerHelper.lexemeToReal($rc.text)); }
                    ;

arguments returns [List<Expression> ast = new ArrayList<Expression>()]:
                    (
                        e1=expression { $ast.add($e1.ast); }
                        (
                            ',' e2=expression  { $ast.add($e2.ast); }
                        )*
                    )?
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