package ast.expression;

import ast.types.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression {

    private Expression expression;
    private Type castType;

    public Cast(int line, int column, Expression expression, Type castType) {
        super(line, column);
        this.expression = expression;
        this.castType = castType;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getCastType() {
        return castType;
    }

    @Override
    public String toString() {
        return String.format("Cast[expression=%s, type=%s]", expression.toString(), castType.toString());
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }
}
