import codegeneration.CodeGenerator;
import codegeneration.ExecuteCGVisitor;
import codegeneration.OffsetVisitor;
import errorhandler.ErrorHandler;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import parser.*;

import org.antlr.v4.runtime.*;
import ast.Program;
import semantic.IdentificationVisitor;
import semantic.TypeCheckVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		CmmParser parser = new CmmParser(tokens);

		// parser.program();
		Program ast = parser.program().ast;
		ast.accept(new IdentificationVisitor(), null);
		ast.accept(new TypeCheckVisitor(), null);
		ast.accept(new OffsetVisitor(), null);
		if (ErrorHandler.getInstance().anyErrors())
			ErrorHandler.getInstance().showErrors(System.err);
		else {
			CodeGenerator cg = new CodeGenerator(args[0], args[1]);
			ast.accept(new ExecuteCGVisitor(cg), null);
			// * The AST is shown
			IntrospectorModel model=new IntrospectorModel(
					"Program", ast);
			new IntrospectorTree("Introspector", model);
		}
	}
	

}
