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
     *      char suffix = expression2.type.promoteToInt()
     *      value[[ expression3 ]]
     *      expression3.type.promoteToInt()
     *      switch (expression1.operator) {
     *          case ">":
     *              <gt> suffix
     *              break
     *          case "<":
     *              <gt> suffix
     *              break
     *          case ">=":
     *              <gt> suffix
     *              break
     *          case "<=":
     *              <gt> suffix
     *              break
     *          case "==":
     *              <gt> suffix
     *              break
     *          case "!=":
     *              <gt> suffix
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
     *
     *
     * Indexing
     * value[[ Indexing: expression1 -> expression2 expression3 ]] =
     *      address[[ expression1 ]]
     *      <load> expression1.type.suffix()
     *
     *
     * FieldAccess
     * value[[ FieldAccess: expression1 -> expression2 ID ]] =
     *      address[[ expression1 ]]
     *      <load> expression1.type.suffix()
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
        arithmetic.getLeft().getType().convertTo(arithmetic.getType(), getCG());
        arithmetic.getRight().accept(this, null);
        arithmetic.getRight().getType().convertTo(arithmetic.getType(), getCG());
        getCG().arithmetic(arithmetic.getOperator(), arithmetic.getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(Module module, Void param) {
        module.getLeft().accept(this, null);
        module.getLeft().getType().convertTo(module.getType(), getCG());
        module.getRight().accept(this, null);
        module.getRight().getType().convertTo(module.getType(), getCG());
        getCG().module(module.getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getLeft().accept(this, null);
        comparison.getLeft().getType().promoteToInt(getCG());
        comparison.getRight().accept(this, null);
        // suffix returned on second param
        getCG().comparison(comparison.getOperator(), comparison.getRight().getType().promoteToInt(getCG()));
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
        cast.getExpression().getType().convertTo(cast.getCastType(), getCG());
        return null;
    }

    @Override
    public Void visit(Negation negation, Void param) {
        negation.getExpression().accept(this, null);
        getCG().not();
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.accept(addressCGVisitor, null);
        getCG().load(indexing.getType().getSuffix());
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.accept(addressCGVisitor, null);
        getCG().load(fieldAccess.getType().getSuffix());
        return null;
    }
}
