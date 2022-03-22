package semantic;

import ast.FuncDefinition;
import ast.Program;
import ast.VarDefinition;
import ast.expression.*;
import ast.expression.Module;
import ast.statements.*;
import ast.types.*;

public class TypeCheckVisitor extends AbstractVisitor<Void,Void> {

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
