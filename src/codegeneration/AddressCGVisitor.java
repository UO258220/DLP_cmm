package codegeneration;

import ast.VarDefinition;
import ast.expression.Variable;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    /**
     * Rules for address code generation
     *
     * Variable
     * address[[ Variable: expression -> ID ]] =
     *      if (exp.definition.scope == 0) {
     *          <pusha> expression.definition.offset
     *      }
     *      else {
     *          <push> bp
     *          <pushi> expression.definition.offset
     *          <addi>
     *      }
     */
    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        if( variable.getDefinition().getScope() == 0){
            getCG().pusha(((VarDefinition)variable.getDefinition()).getOffset());
        } else{
            getCG().pushBP();
            getCG().pushi(((VarDefinition)variable.getDefinition()).getOffset());
            getCG().add('i');
        }
        return null;
    }

}
