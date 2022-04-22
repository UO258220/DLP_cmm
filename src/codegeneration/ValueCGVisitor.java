package codegeneration;

public class ValueCGVisitor {

    /**
     * Rules for value code generation
     *
     * Integer constant
     * value[[ IntLiteral: expression -> INT_CONSTANT ]] =
     *      <pushi> INT_CONSTANT
     *
     *
     * Character constant
     * value[[ CharLiteral: expression -> CHAR_CONSTANT ]] =
     *      <pushb> (byte)CHAR_CONSTANT
     *
     *
     * Real constant
     * value[[ RealLiteral: expression -> REAL_CONSTANT ]] =
     *      <pushf> REAL_CONSTANT
     *
     *
     * Variable
     * value[[ Variable: expression -> ID ]] =
     *      address[[ expression ]]
     *      <load> expression.definition.type.suffix()
     *
     *
     * Arithmetic
     * value[[ Arithmetic: expression1 -> expression2 (+ - * /) expression3 ]] =
     *      value[[ expression2 ]]
     *      expression2.type.convertTo(expression1.type)
     *      value[[ expression3 ]]
     *      expression3.type.convertTo(expression1.type)
     *      switch (expression1.operator) {
     *          case "+":
     *              <add> expression1.type.suffix()
     *              break
     *          case "-":
     *              <sub> expression1.type.suffix()
     *              break
     *          case "*":
     *              <mul> expression1.type.suffix()
     *              break
     *          case "/":
     *              <div> expression1.type.suffix()
     *              break
     *      }
     *
     *
     * Comparison
     * value[[ Comparison: expression1 -> expression2 (">" | "<" | ">=" | "<=" | "==" | "!=") ]] =
     *      value[[ expression2 ]]
     *      expression2.type.promoteToInt()
     *      value[[ expression3 ]]
     *      expression3.type.promoteToInt()
     *      switch (expression1.operator) {
     *          case ">":
     *              <gt> expression2.type.suffix()
     *              break
     *          case "<":
     *              <gt> expression2.type.suffix()
     *              break
     *          case ">=":
     *              <gt> expression2.type.suffix()
     *              break
     *          case "<=":
     *              <gt> expression2.type.suffix()
     *              break
     *          case "==":
     *              <gt> expression2.type.suffix()
     *              break
     *          case "!=":
     *              <gt> expression2.type.suffix()
     *              break
     *      }
     *
     *
     * Logical Expression
     * value[[ Logical: expression1 -> expression2 ("&&" | "||") ]] =
     *      value[[ expression2 ]]
     *      value[[ expression3 ]]
     *      switch (expression1.operator) {
     *          case "&&":
     *              <and>
     *              break
     *          case "||":
     *              <and>
     *              break
     *      }
     *
     *
     * Cast
     * value[[ Cast: expression1 -> type expression2 ]] =
     *      value[[ expression2 ]]
     *      expression2.type.convertTo(expression1.type)
     */

}
