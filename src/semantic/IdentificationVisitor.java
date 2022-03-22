package semantic;

import ast.Definition;
import ast.FuncDefinition;
import ast.VarDefinition;
import ast.expression.Variable;
import ast.statements.FuncInvocation;
import ast.types.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {

    private SymbolTable st = new SymbolTable();

    public Void visit(FuncDefinition funcDefinition, Void param) {
        if (!st.insert(funcDefinition)) {
            new ErrorType(funcDefinition.getLine(), funcDefinition.getColumn(),
                    String.format("variable %s already exists on current scope", funcDefinition.getName()));
        }
        st.set();
        funcDefinition.getType().accept(this, null);
        funcDefinition.getStatements().forEach(st -> st.accept(this, null));
        st.reset();
        return null;
    }

    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        if (!st.insert(varDefinition)) {
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(),
                    String.format("variable %s already exists on current scope", varDefinition.getName()));
        }
        varDefinition.getType().accept(this, null);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        Definition definition = st.find(variable.getName());
        if (definition == null) {
            new ErrorType(variable.getLine(), variable.getColumn(),
                    String.format("variable %s has not been defined", variable.getName()));
            return null;
        }
        variable.setDefinition(definition);
        return null;
    }

}
