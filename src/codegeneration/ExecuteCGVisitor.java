package codegeneration;

public class ExecuteCGVisitor {

    /**
     * Rules for execute code generation
     *
     * Function definition
     * execute[[ FuncDefinition: definition -> type ID statement* ]] =
     *      ID <:>;
     *      <' * Parameters:>;
     *      //TODO
     *
     *
     * Read statement
     * execute[[ ReadStatement: statement -> expression ]] =
     *      address[[ expression ]]
     *      <in> expression.type.suffix();
     *      <store> expression.type.suffix();
     *
     *
     * Write statement
     * execute[[ WriteStatement: statement -> expression ]] =
     *      value[[ expression ]]
     *      <out> expression.type.suffix();
     *
     *
     * Assignment
     * execute[[ Assignment: statement -> expression1 expression2 ]] =
     *      address[[ expression1 ]]
     *      value[[ expression2 ]]
     *      <store> expression2.type.suffix();
     */

}
