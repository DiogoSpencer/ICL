package Ast;


import values.*;

public class ASTBool implements  ASTNode{

boolean val;

    public ASTBool(boolean n) {
        val = n;
    }


    public IValue eval(Environment<IValue> env) {

        return new VBool(val);
    }

    @Override
    public void compile(CodeBlock c) {

    }


}
