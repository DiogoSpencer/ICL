package Ast;

import Exceptions.*;
import values.*;

public class ASTDeref implements ASTNode{

    ASTNode exp;

    public ASTDeref(ASTNode exp) {

        this.exp = exp;
    }

    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue v = exp.eval(env);

        if(! (v instanceof VCell) )
            throw new InterpreterException("Dereference error: Expected");

        return ( (VCell)v ).get();
    }

    @Override
    public void compile(CodeBlock c) {

    }


}
