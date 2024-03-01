package Ast;

import Exceptions.*;
import values.*;

public class ASTSeq implements ASTNode{

    ASTNode  lhs, rhs;

    public ASTSeq(ASTNode lhs, ASTNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }



    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterException {

        lhs.eval(env);
        return rhs.eval(env);
    }

    @Override
    public void compile(CodeBlock c) {

    }
}
