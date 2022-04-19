package codegeneration;

public class ExecuteCGVisitor {

    /**
     * Rules for execute code generation
     *
     * Read statement
     * execute[[ ReadStatement: statement -> expression ]]
     *      -
     *
     *
     * Write statement
     * execute[[ WriteStatement: statement -> expression ]]
     *      value[[ expression ]]
     *      <out> expression.type.suffix();
     *
     *
     * Assignment
     * execute[[ Assignment: statement -> expression1 expression2 ]]
     *      address[[ expression1 ]]
     *      value[[ expression2 ]]
     *      //TODO
     */

}
