package codegeneration;

import ast.expression.*;
import ast.expression.Module;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void> {

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
     * value[[ Comparison: expression1 -> expression2 (">" | "<" | ">=" | "<=" | "==" | "!=") expression3 ]] =
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
    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setAddressCGVisitor(AddressCGVisitor addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        getCG().pushi(intLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        getCG().pushb((byte)charLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        getCG().pushf(realLiteral.getValue());
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.accept(addressCGVisitor, null);
        getCG().load(variable.getDefinition().getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.getLeft().accept(this, null);
        getCG().convertTo(arithmetic.getLeft().getType(), arithmetic.getType());
        arithmetic.getRight().accept(this, null);
        getCG().convertTo(arithmetic.getRight().getType(), arithmetic.getType());
        getCG().arithmetic(arithmetic.getOperator(), arithmetic.getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(Module module, Void param) {
        module.getLeft().accept(this, null);
        getCG().convertTo(module.getLeft().getType(), module.getType());
        module.getRight().accept(this, null);
        getCG().convertTo(module.getRight().getType(), module.getType());
        getCG().module(module.getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getLeft().accept(this, null);
        char suffix = getCG().promoteToInt(comparison.getLeft().getType());
        comparison.getRight().accept(this, null);
        getCG().promoteToInt(comparison.getRight().getType());
        getCG().comparison(comparison.getOperator(), suffix);
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);
        getCG().logical(logical.getOperator());
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        cast.getExpression().accept(this, null);
        getCG().convertTo(cast.getExpression().getType(), cast.getCastType());
        return null;
    }

    @Override
    public Void visit(Negation negation, Void param) {
        negation.getExpression().accept(this, null);
        getCG().not();
        return null;
    }
}
