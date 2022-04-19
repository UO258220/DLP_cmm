package codegeneration;

public class AddressCGVisitor {

    /**
     * Rules for address code generation
     *
     * Variable
     * address[[ Variable: expression -> ID ]] =
     *      if (exp.definition.scope == 0) {
     *          <pusha> expression.definition.offset
     *      }
     *      else {
     *          <push> bp
     *          <pushi> expression.definition.offset
     *          <addi>
     *      }
     */

}
