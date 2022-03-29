package semantic;

import ast.expression.*;
import ast.expression.Module;
import ast.statements.*;
import ast.types.*;

public class TypeCheckVisitor extends AbstractVisitor<Void,Void> {

    /**
     * Rules for typechecking (AG)
     *
     *
     * P:   FuncDefinition: definition -> type vardefinition* statement*
     * R:   for (Statement s : statement*) {
     *          s.returnType = type.returnType
     *      }
     *
     * P:   FuncInvocation: expression1 -> expression2 expression3*
     * R:   List<Type> argTypes = expression3*.stream()
     *                              .map(exp -> exp.type)
     *                              .toList();
     *      expression1.type = expression2.type.parenthesis(argTypes)
     *
     * P:   FuncInvocation: statement -> expression1 expression2*
     * R:   List<Type> argTypes = expression3*.stream()
     *                             .map(exp -> exp.type)
     *                             .toList();
     *      expression2.type.parenthesis(argTypes)
     *
     * P:   WriteStatement: statement -> expression
     * R:   expression.type.isWritable()
     *
     * P:   ReadStatement:  statement -> expression
     * R:   expression.type.isReadable()
     *
     * P:   Assignment:     statement -> expression1 expression2
     * R:   expression1.type.assign(expression2.type)
     *
     * P:   WhileStmt:      statement1 -> expression statement2*
     * R:   for (Statement s : statement2*) {
     *          s.returnType = statement1.returnType
     *      }
     *      expression.type.asBoolean()
     *
     * P:   IfElse:         statement1 -> expression statement2* statement3*
     * R:   for (Statement s : statement2*) {
     *          s.returnType = statement1.returnType
     *      }
     *      expression.type.asBoolean()
     *
     * P:   ReturnStatement: statement -> expression
     * R:   expression.type.isReturning(statement.returnType)
     *
     * P:   Indexing:       expression1 -> expression2 expression3
     * R:   expression1.type = expression2.type.squareBrackets(expression3.type)
     *
     * P:   FieldAccess:    expression1 -> expression2 ID
     * R:   expression1.type = expression2.type.dot(ID)
     *
     * P:   Cast:           expression1 -> expression2 type
     * R:   expression1.type = expression2.type.castTo(type)
     *
     * P:   UnaryMinus:     expression1 -> expression2
     * R:   expression1.type = expression2.type.minus()
     *
     * P:   Negation:       expression1 -> expression2
     * R:   expression1.type = expression2.type.negation()
     *
     * P:   Arithmetic:     expression1 -> expression2 (+|-|*|/) expression3
     * R:   expression1.type = expression2.type.arithmetic(expression3.type)
     *
     * P:   Module:         expression1 -> expression2 expression3
     * R:   expression1.type = expression2.type.module(expression3.type)
     *
     * P:   Comparison:     expression1 -> expression2 expression3
     * R:   expression1.type = expression2.type.compare(expression3.type)
     *
     * P:   Logical:        expression1 -> expression2 expression3
     * R:   expression1.type = expression2.type.logical(expression3.type)
     *
     * P:   Variable:       expression -> ID
     * R:   if (expression.definition == null) {
     *          expression.type = new ErrorType(expression.getLine(),
     *              expression.getColumn(), "variable is not defined")
     *      }
     *      else {
     *          expression.type = expression.definition.type
     *      }
     *
     * P:   IntLiteral:     expression -> INT_CONSTANT
     * R:   expression.type = new IntegerType()
     *
     * P:   CharLiteral:    expression -> CHAR_CONSTANT
     * R:   expression.type = new CharType()
     *
     * P:   RealLiteral:    expression -> REAL_CONSTANT
     * R:   expression.type = new DoubleType()
     */

    @Override
    public Void visit(Assignment assignment, Void param) {
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);
        if (!assignment.getLeft().getLvalue()) {
            new ErrorType(assignment.getLeft().getLine(), assignment.getLeft().getColumn(),
                    "L-value required.");
        }
        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, Void param) {
        readStatement.getExpression().accept(this, null);
        if (!readStatement.getExpression().getLvalue()) {
            new ErrorType(readStatement.getLine(), readStatement.getColumn(), "L-value required.");
        }
        return null;
    }

    @Override
    public Void visit(FuncInvocation funcInvocation, Void param) {
        funcInvocation.getVariable().accept(this, null);
        funcInvocation.getParams().forEach(p -> p.accept(this, null));
        funcInvocation.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.getLeft().accept(this, null);
        indexing.getRight().accept(this, null);
        indexing.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getExpression().accept(this, null);
        fieldAccess.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        cast.getCastType().accept(this, null);
        cast.getExpression().accept(this, null);
        cast.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.getExpression().accept(this, null);
        unaryMinus.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Negation negation, Void param) {
        negation.getExpression().accept(this, null);
        negation.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.getLeft().accept(this, null);
        arithmetic.getRight().accept(this, null);
        arithmetic.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Module module, Void param) {
        module.getLeft().accept(this, null);
        module.getRight().accept(this, null);
        module.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        comparison.getLeft().accept(this, null);
        comparison.getRight().accept(this, null);
        comparison.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);
        logical.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        intLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        charLiteral.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        realLiteral.setLvalue(false);
        return null;
    }
}
