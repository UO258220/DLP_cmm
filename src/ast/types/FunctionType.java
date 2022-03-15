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
}
