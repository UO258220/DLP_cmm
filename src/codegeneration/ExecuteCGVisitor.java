package codegeneration;

public class ExecuteCGVisitor {

    /**
     * Rules for execute code generation
     *
     * Program[[ Program: program ->  ]] =
     *
     *
     *
     * Function definition
     * execute[[ FuncDefinition: definition -> type ID statement* ]] =
     *      ID <:>
     *      <' * Parameters>
     *      type.definitions.forEach( d -> execute[[ d ]] )
     *      <' * Local variables>
     *      statement*.forEach( s -> execute[[ s ]] )
     *      <enter> definition.localsBytesSum //TODO
     *      if ( type.returnType instanceof VoidType ) {
     *          <ret 0, > definition.localsBytesSum <, > definition.type.paramsBytesSum
     *      }
     *
     *
     * Variable definition
     * execute[[ VarDefinition: definition -> type ID ]] =
     *      <' * > type.toString() ID < (offset > definition.offset <)>
     *
     *
     * Read statement
     * execute[[ ReadStatement: statement -> expression ]] =
     *      <' * Read>
     *      address[[ expression ]]
     *      <in> expression.type.suffix()
     *      <store> expression.type.suffix()
     *
     *
     * Write statement
     * execute[[ WriteStatement: statement -> expression ]] =
     *      <' * Write>
     *      value[[ expression ]]
     *      <out> expression.type.suffix()
     *
     *
     * Assignment
     * execute[[ Assignment: statement -> expression1 expression2 ]] =
     *      address[[ expression1 ]]
     *      value[[ expression2 ]]
     *      <store> expression1.type.suffix();
     */

}
