package program.types;

import program.VarDefinition;
import program.statements.Statement;

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
}
