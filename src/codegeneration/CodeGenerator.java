package codegeneration;

import ast.VarDefinition;
import ast.types.CharType;
import ast.types.DoubleType;
import ast.types.Type;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class CodeGenerator {

    private PrintWriter out;
    private PrintStream err;

    public CodeGenerator(String inputFilename, String outputFilename) {
        try {
            this.out = new PrintWriter(outputFilename);
            this.err = System.err;
        }
        catch (FileNotFoundException e) {
            err.println(String.format("--- FILE %s NOT FOUND ---", inputFilename));
        }
        this.out.println(String.format("\n#source \"%s\"\n", inputFilename));
        this.out.flush();
    }

    public String nextLabel() {
        // TODO
        return null;
    }

    public void line(int line) {
        this.out.println(String.format("\n#line\t%d", line));
        this.out.flush();
    }

    public void comment(String text) {
        this.out.println(String.format("\t' * %s", text));
        this.out.flush();
    }

    public void mainInvocation() {
        this.out.println("\n' Invocation to the main function");
        this.out.println("call main");
        this.out.println("halt\n");
        this.out.flush();
    }

    public void label(String name) {
        this.out.println(String.format("\n %s:", name));
        this.out.flush();
    }

    public void enter(int bytes) {
        this.out.println(String.format("\tenter\t%s", bytes));
        this.out.flush();
    }

    public void ret(int typeBytes, int localsBytes, int paramsBytes) {
        this.out.println(String.format("\tret\t%d, %d, %d", typeBytes, localsBytes, paramsBytes));
        this.out.flush();
    }

    public void commentVariable(VarDefinition varDefinition) {
        comment(String.format("%s %s (offset %d)", varDefinition.getType().toString(),
                varDefinition.getName(), varDefinition.getOffset()));
    }

    public void arithmetic(String operator, char suffix) {
        switch(operator) {
            case "+":
                add(suffix);
                break;
            case "-":
                sub(suffix);
                break;
            case "*":
                mul(suffix);
                break;
            case "/":
                div(suffix);
                break;
        }
    }

    public void comparison(String operator, char suffix) {

        switch(operator) {
            case ">":
                gt(suffix);
                break;
            case "<":
                lt(suffix);
                break;
            case ">=":
                ge(suffix);
                break;
            case "<=":
                le(suffix);
                break;
            case "==":
                eq(suffix);
                break;
            case "!=":
                ne(suffix);
                break;
        }
    }

    public void logical(String operator) {
        switch(operator) {
            case "&&":
                and();
                break;
            case "||":
                or();
                break;
        }
    }

    public void in(char suffix) {
        this.out.println(String.format("\tin%c", suffix));
        this.out.flush();
    }

    public void out(char suffix) {
        this.out.println(String.format("\tout%c", suffix));
        this.out.flush();
    }

    public void store(char suffix) {
        this.out.println(String.format("\tstore%c", suffix));
        this.out.flush();
    }

    public void load(char suffix) {
        this.out.println(String.format("\tload%c", suffix));
        this.out.flush();
    }

    public void pushi(int value) {
        this.out.println(String.format("\tpushi\t%d", value));
        this.out.flush();
    }

    public void pushb(int value) {
        this.out.println(String.format("\tpushb\t%d", value));
        out.flush();
    }

    public void pushf(double value) {
        this.out.println("\tpushf\t" + value);
        this.out.flush();
    }

    public void pusha(int offset) {
        this.out.println(String.format("\tpusha\t%d", offset));
        this.out.flush();
    }

    public void pushBP() {this.out.println("\tpush\tbp");
        this.out.flush();
    }

    public void add(char suffix) {
        this.out.println(String.format("\tadd%c", suffix));
        this.out.flush();
    }

    public void sub(char suffix) {
        this.out.println(String.format("\tsub%c", suffix));
        this.out.flush();
    }

    public void mul(char suffix) {
        this.out.println(String.format("\tmul%c", suffix));
        this.out.flush();
    }

    public void div(char suffix) {
        this.out.println(String.format("\tdiv%c", suffix));
        this.out.flush();
    }

    public void module(char suffix) {
        this.out.println(String.format("\tmod%c", suffix));
        this.out.flush();
    }

    public void gt(char suffix) {
        this.out.println(String.format("\tgt%c", suffix));
        this.out.flush();
    }

    public void lt(char suffix) {
        this.out.println(String.format("\tlt%c", suffix));
        this.out.flush();
    }

    public void ge(char suffix) {
        this.out.println(String.format("\tge%c", suffix));
        this.out.flush();
    }

    public void le(char suffix) {
        this.out.println(String.format("\tle%c", suffix));
        this.out.flush();
    }

    public void eq(char suffix) {
        this.out.println(String.format("\teq%c", suffix));
        this.out.flush();
    }

    public void ne(char suffix) {
        this.out.println(String.format("\tne%c", suffix));
        this.out.flush();
    }

    public void and() {
        out.println("\tand");
        this.out.flush();
    }

    public void or() {
        out.println("\tor");
        this.out.flush();
    }

    public void not() {
        out.println("\tnot");
        this.out.flush();
    }

    public void convertTo(Type from, Type to) {
        if (from.equals(to)) {
            return;
        }
        if(from instanceof CharType) {
            b2i();
            if(to instanceof DoubleType) {
                i2f();
            }
        }
        else if (from instanceof DoubleType) {
            f2i();
            if (to instanceof CharType) {
                i2b();
            }
        }
        else {
            if(to instanceof DoubleType) {
                i2f();
            }
            else if (to instanceof CharType) {
                i2b();
            }
        }
    }

    public char promoteToInt(Type type) {
        if (type instanceof DoubleType) {
            return 'f';
        }
        if (type instanceof CharType) {
            b2i();
        }
        return 'i';
    }

    public void b2i() {
        this.out.println("\tb2i");
        this.out.flush();
    }

    public void i2f() {
        this.out.println("\ti2f");
        this.out.flush();
    }

    public void f2i() {
        this.out.println("\tf2i");
        this.out.flush();
    }

    public void i2b() {
        this.out.println("\ti2b");
        this.out.flush();
    }

    public void jmp(String label) {
        this.out.println(String.format("\tjmp\t%s", label));
        this.out.flush();
    }

    public void jz(String label) {
        this.out.println(String.format("\tjz\t%s", label));
        this.out.flush();
    }
}
