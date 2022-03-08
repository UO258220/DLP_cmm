grammar Cmm;

@header {
    import ast.*;
    import ast.expression.*;
    import ast.statements.*;
    import ast.types.*;
}


/* PROGRAM */

program returns [Program ast]:

                    { List<Definition> defs = new ArrayList<Definition>(); }
                    (
                        d1=definition
                            { $d1.ast.forEach(d -> defs.add(d)); }
                    )*
                        m1=main_definition
                            { defs.add($m1.ast); }
                    EOF
                        { $ast = new Program(1, 1, defs); }
                    ;

/* DEFINITIONS */

definition returns [List<Definition> ast = new ArrayList<Definition>()]:

                    v1=var_definition { $v1.ast.forEach(v -> $ast.add(v)); }

                    | f1=func_definition { $ast.add($f1.ast); }

                    ;


var_definition returns [List<Definition> ast = new ArrayList<Definition>()]:

                    t1=type i1=ID { $ast.add(new VarDefinition($i1.getLine(), $i1.getCharPositionInLine() + 1,
                        $i1.text, $t1.ast)); }
                        (
                            ',' i2=ID { $ast.add(new VarDefinition($i2.getLine(), $i2.getCharPositionInLine() + 1,
                                $i2.text, $t1.ast)); }
                        )*
                        ';'
                    ;

func_definition returns [FuncDefinition ast]:
                    r1=return_type i1=ID '(' p1=param_definitions ')' '{' b1=func_body '}'
                        { $ast = new FuncDefinition(
                            $i1.getLine(),
                            $i1.getCharPositionInLine() + 1,
                            $i1.text,
                            new FunctionType(
                                $r1.ast.getLine(),
                                $r1.ast.getColumn(),
                                $r1.ast,
                                $p1.ast
                            ),
                            $b1.ast
                        ); }
                    ;

main_definition returns [FuncDefinition ast]:

                    v='void' m='main' '(' ')' '{' b1=func_body '}'
                        { $ast = new FuncDefinition(
                            $v.getLine(),
                            $v.getCharPositionInLine() + 1,
                            $m.text,
                            new FunctionType(
                                $v.getLine(),
                                $v.getCharPositionInLine() + 1,
                                new VoidType($v.getLine(), $v.getCharPositionInLine() + 1),
                                new ArrayList<VarDefinition>()
                            ),
                            $b1.ast
                        ); }
                    ;

param_definitions returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:

                    t1=built_in_type i1=ID
                        { $ast.add(new VarDefinition($t1.ast.getLine(), $t1.ast.getColumn(), $i1.text, $t1.ast)); }
                        (
                            ',' t2=built_in_type i2=ID
                                { $ast.add(new VarDefinition($t2.ast.getLine(), $t2.ast.getColumn(), $i2.text,
                                    $t2.ast)); }
                        )*

                    |   // CAN BE EMPTY

                    ;

func_body returns [List<Statement> ast = new ArrayList<Statement>()]:

                    (
                        v1=var_definition { $v1.ast.forEach(v -> $ast.add((VarDefinition)v)); }
                    )*
                    (
                        s1=statement { $s1.ast.forEach(s -> $ast.add(s)); }
                    )*
                    ;


/* TYPES */

type returns [Type ast]:

                    t1=type '[' i1=INT_CONSTANT ']'
                        { $ast = ParserHelper.createArrayType(LexerHelper.lexemeToInt($i1.text), $t1.ast); }

                    | s='struct'
                        { RecordType aux = new RecordType($s.getLine(), $s.getCharPositionInLine() + 1,
                            new ArrayList<RecordField>()); }
                        '{'
                        (
                            r1=record_fields { $r1.ast.forEach(f -> aux.addField(f)); }
                        )+
                        '}'
                        { $ast = aux; }

                    | b1=built_in_type
                        { $ast = $b1.ast; }
                    ;


return_type returns [Type ast]:

                    t1=built_in_type
                        { $ast = $t1.ast; }

                    | v='void'
                        { $ast = new VoidType($v.getLine(), $v.getCharPositionInLine() + 1); }
                    ;


built_in_type returns [Type ast]:

                    d='double'
                        { $ast = new DoubleType($d.getLine(), $d.getCharPositionInLine() + 1); }

                    | i='int'
                        { $ast = new IntegerType($i.getLine(), $i.getCharPositionInLine() + 1); }

                    | c='char'
                        { $ast = new CharType($c.getLine(), $c.getCharPositionInLine() + 1); }
                    ;

record_fields returns [List<RecordField> ast = new ArrayList<RecordField>()]:

                    t1=type i1=ID { $ast.add(new RecordField($i1.getLine(), $i1.getCharPositionInLine() + 1, $t1.ast,
                        $i1.text)); }
                        (
                            ',' i2=ID { $ast.add(new RecordField($i2.getLine(), $i2.getCharPositionInLine() + 1,
                                $t1.ast, $i2.text)); }
                        )*
                        ';'
                    ;


/* STATEMENTS */

statement returns [List<Statement> ast = new ArrayList<Statement>()]:

                    ID '(' arguments ')'
                        { $ast.add(new FuncInvocation($ID.getLine(), $ID.getCharPositionInLine() + 1,
                        new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text), $arguments.ast)); }
                        ';'

                    | 'write' e1=expression
                        { $ast.add(new WriteStatement($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast)); }
                        (
                            ',' e2=expression
                            { $ast.add(new WriteStatement($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast)); }
                        )*
                        ';'

                    | 'read' e1=expression
                        { $ast.add(new ReadStatement($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast)); }
                        (
                            ',' e2=expression
                            { $ast.add(new ReadStatement($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast)); }
                        )*
                        ';'

                    | e1=expression '=' e2=expression ';'
                        { $ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast)); }

                    | 'while' '(' e1=expression ')' b1=cond_body
                        { $ast.add(new While($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast)); }

                    | 'if' '(' e1=expression ')' b1=cond_body
                        { $ast.add(new IfElse($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast)); }

                    | 'if' '(' e1=expression ')' b1=cond_body 'else' b2=cond_body
                        { $ast.add(new IfElse($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast, $b2.ast)); }

                    | 'return' e1=expression
                        { $ast.add(new ReturnStatement($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast)); }
                        ';'
                    ;


cond_body returns [List<Statement> ast = new ArrayList<Statement>()]:

                    s1=statement
                        { $s1.ast.forEach(s -> $ast.add(s)); }

                    | '{' (
                        s2=statement { $s2.ast.forEach(s -> $ast.add(s)); }
                    )* '}'
                    ;


/* EXPRESSIONS */

expression returns [Expression ast]:

                    '(' e1=expression ')'
                        { $ast = $e1.ast; }

                    | e1=expression '[' e2=expression ']'
                        { $ast = new Indexing($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast); }

                    | e1=expression '.' ID
                        { $ast = new FieldAccess($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $ID.text); }

                    | '(' t1=built_in_type ')' e1=expression
                        { $ast = new Cast($t1.ast.getLine(), $t1.ast.getColumn(), $e1.ast, $t1.ast); }

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

                    | ID
                        { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text); }

                    | ic=INT_CONSTANT
                        { $ast = new IntLiteral($ic.getLine(), $ic.getCharPositionInLine() + 1,
                        LexerHelper.lexemeToInt($ic.text)); }

                    | cc=CHAR_CONSTANT
                        { $ast = new CharLiteral($cc.getLine(), $cc.getCharPositionInLine() + 1,
                        LexerHelper.lexemeToChar($cc.text)); }

                    | rc=REAL_CONSTANT
                        { $ast = new RealLiteral($rc.getLine(), $rc.getCharPositionInLine() + 1,
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


/* TERMINALS */

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