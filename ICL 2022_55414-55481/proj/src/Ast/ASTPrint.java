package Ast;

import Exceptions.*;
import values.*;

public class ASTPrint implements ASTNode{

    ASTNode exp;

    public ASTPrint(ASTNode exp) {
        this.exp = exp;
    }

    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue v = exp.eval(env);
        v.print();
        return v;
    }

    @Override
    public void compile(CodeBlock c) {

    }

}
