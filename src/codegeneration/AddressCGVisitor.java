package codegeneration;

import ast.VarDefinition;
import ast.expression.FieldAccess;
import ast.expression.Indexing;
import ast.expression.Variable;
import ast.types.RecordType;

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
     *
     *
     * Indexing
     * address[[ Indexing: expression1 -> expression2 expression3 ]] =
     *      address[[ expression2 ]]
     *      value[[ expression3 ]]
     *      <pushi > expression1.type.numberOfBytes()
     *      <muli>
     *      <addi>
     *
     *
     * FieldAccess
     * address[[ FieldAccess: expression1 -> expression2 ID ]] =
     *      address[[ expression2 ]]
     *      <pushi > ((RecordType)expression2.type).getField(ID).type.offset
     *      <addi>
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

    @Override
    public Void visit(Indexing indexing, Void param) {
        indexing.getLeft().accept(this, null);
        indexing.getRight().accept(valueCGVisitor, null);
        getCG().pushi(indexing.getType().numberOfBytes());
        getCG().mul('i');
        getCG().add('i');
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.getExpression().accept(this, null);
        getCG().pushi(((RecordType)fieldAccess.getExpression()).getField(fieldAccess.getField()).getOffset());
        getCG().add('i');
        return null;
    }

}
