package semantic;

import ast.FuncDefinition;
import ast.expression.*;
import ast.expression.Module;
import ast.statements.*;
import ast.types.*;

public class TypeCheckVisitor extends AbstractVisitor<Type,Void> {

    /**
     * Rules for typechecking (AG)
     *
     *
     * P:   FuncDefinition: definition -> type definition* statement*
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
     * R:   expression.type.asBoolean()
     *      for (Statement s : statement2*) {
     *          s.returnType = statement1.returnType
     *      }
     *
     * P:   IfElse:         statement1 -> expression statement2* statement3*
     * R:   expression.type.asBoolean()
     *      for (Statement s : statement2*) {
     *          s.returnType = statement1.returnType
     *      }
     *      for (Statement s : statement3*) {
     *          s.returnType = statement1.returnType
     *      }
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
     * R:   expression1.type = expression2.type.not()
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
    public Void visit(FuncDefinition funcDefinition, Type param) {
        funcDefinition.getType().accept(this, null);
        funcDefinition.getStatements().forEach(st -> st.accept(this,
                ((FunctionType)funcDefinition.getType()).getReturnType()
        ));
        return null;
    }

    @Override
    public Void visit(FuncInvocation funcInvocation, Type param) {
        funcInvocation.getVariable().accept(this, null);
        funcInvocation.getParams().forEach(p -> p.accept(this, null));
        funcInvocation.setLvalue(false);
        funcInvocation.setType(
                funcInvocation.getVariable().getType().parenthesis(
                        funcInvocation.getParams().stream()
                        .map(Expression::getType)
                        .toList()
        ));
        return null;
    }

    @Override
    public Void visit(WriteStatement writeStatement, Type param) {
        writeStatement.getExpression().accept(this, null);
        writeStatement.getExpression().getType().isWritable();
        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, Type param) {
        readStatement.getExpression().accept(this, null);
        if (!readStatement.getExpression().getLvalue()) {
            new ErrorType(readStatement.getLine(), readStatement.getColumn(), "L-value required.");
        }
        readStatement.getExpression().getType().isReadable();
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Type param) {
        assignment.getLeft().accept(this, null);
        assignment.getRight().accept(this, null);
        if (!assignment.getLeft().getLvalue()) {
            new ErrorType(assignment.getLeft().getLine(), assignment.getLeft().getColumn(),
                    "L-value required.");
        }
        assignment.getLeft().getType().assign(assignment.getRight().getType());
        return null;
    }

    @Override
    public Void visit(While whileStmt, Type param) {
        whileStmt.getCondition().accept(this, null);
        whileStmt.getBody().forEach(st -> st.accept(this, param));
        whileStmt.getCondition().getType().asBoolean();
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Type param) {
        ifElse.getCondition().accept(this, null);
        ifElse.getBody().forEach(st -> st.accept(this, param));
        ifElse.getElseBody().forEach(st -> st.accept(this, param));
        ifElse.getCondition().getType().asBoolean();
        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement, Type param) {
        returnStatement.getExpression().accept(this, null);
        returnStatement.getExpression().getType().isReturning(param);
        return null;
    }

    @Override
    public Void visit(Indexing indexing, Type param) {
        indexing.getLeft().accept(this, null);
        indexing.getRight().accept(this, null);
        indexing.setLvalue(true);
        indexing.setType(indexing.getLeft().getType().squareBrackets(indexing.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Type param) {
        fieldAccess.getExpression().accept(this, null);
        fieldAccess.setLvalue(true);
        fieldAccess.setType(fieldAccess.getExpression().getType().dot(fieldAccess.getField()));
        return null;
    }

    @Override
    public Void visit(Cast cast, Type param) {
        cast.getCastType().accept(this, null);
        cast.getExpression().accept(this, null);
        cast.setLvalue(false);
        cast.setType(cast.getExpression().getType().castTo(cast.getType()));
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Type param) {
        unaryMinus.getExpression().accept(this, null);
        unaryMinus.setLvalue(false);
        unaryMinus.setType(unaryMinus.getExpression().getType().minus());
        return null;
    }

    @Override
    public Void visit(Negation negation, Type param) {
        negation.getExpression().accept(this, null);
        negation.setLvalue(false);
        negation.setType(negation.getExpression().getType().not());
        return null;
    }

    @Override
    public Void visit(Arithmetic arithmetic, Type param) {
        arithmetic.getLeft().accept(this, null);
        arithmetic.getRight().accept(this, null);
        arithmetic.setLvalue(false);
        arithmetic.setType(arithmetic.getLeft().getType().arithmetic(arithmetic.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(Module module, Type param) {
        module.getLeft().accept(this, null);
        module.getRight().accept(this, null);
        module.setLvalue(false);
        module.setType(module.getLeft().getType().module(module.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Type param) {
        comparison.getLeft().accept(this, null);
        comparison.getRight().accept(this, null);
        comparison.setLvalue(false);
        comparison.setType(comparison.getLeft().getType().compare(comparison.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(Logical logical, Type param) {
        logical.getLeft().accept(this, null);
        logical.getRight().accept(this, null);
        logical.setLvalue(false);
        logical.setType(logical.getLeft().getType().logical(logical.getRight().getType()));
        return null;
    }

    @Override
    public Void visit(Variable variable, Type param) {
        variable.setLvalue(true);
        variable.setType(
                variable.getDefinition() == null ?
                        new ErrorType(variable.getLine(), variable.getColumn(),
                                String.format("variable %s is not defined", variable.getName()))
                        :
                        variable.getDefinition().getType()
        );
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Type param) {
        intLiteral.setLvalue(false);
        intLiteral.setType(new IntegerType(intLiteral.getLine(), intLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Type param) {
        charLiteral.setLvalue(false);
        charLiteral.setType(new CharType(charLiteral.getLine(), charLiteral.getColumn()));
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Type param) {
        realLiteral.setLvalue(false);
        realLiteral.setType(new DoubleType(realLiteral.getLine(), realLiteral.getColumn()));
        return null;
    }
}
