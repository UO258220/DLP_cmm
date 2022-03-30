package ast.types;

import ast.VarDefinition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

    private Type returnType;
    private List<VarDefinition> params;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> params) {
        super(line, column);
        this.returnType = returnType;
        this.params = new ArrayList<VarDefinition>(params);
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VarDefinition> getParams() {
        return params;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("FunctionType[returnType=%s, params=[", returnType.toString()));
        for (VarDefinition p : params) {
            res.append(String.format("\n%s", p.toString()));
        }
        return res.append("]]").toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type parenthesis(List<Type> argTypes) {
        if (argTypes.size() != params.size()) {
            return new ErrorType(getLine(), getColumn(), "unexpected number of arguments on invocation");
        }
        for (int i = 0; i < params.size(); i++) {
            if (argTypes.get(i) instanceof ErrorType) {
                return argTypes.get(i);
            }
            if (!params.get(i).getType().equals(argTypes.get(i))) {
                return new ErrorType(getLine(), getColumn(),
                        String.format("type of argument number %d mismatched on invocation", i + 1));
            }
        }
        return returnType;
    }
}
