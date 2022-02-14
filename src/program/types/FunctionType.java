package program.types;

import program.VarDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

    private Type returnType;
    private List<VarDefinition> paramDefinitions;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> paramDefinitions) {
        super(line, column);
        this.returnType = returnType;
        this.paramDefinitions = new ArrayList<VarDefinition>(paramDefinitions);
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VarDefinition> getParamDefinitions() {
        return paramDefinitions;
    }
}
