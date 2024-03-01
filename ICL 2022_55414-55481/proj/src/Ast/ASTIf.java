package Ast;

import Exceptions.*;
import values.*;

public class ASTIf implements ASTNode{


    ASTNode cond, exp_a, exp_b;

    public ASTIf(ASTNode cond, ASTNode exp_a, ASTNode exp_b) {
        this.cond = cond;
        this.exp_a = exp_a;
        this.exp_b = exp_b;
    }

    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue cv = cond.eval(env);
        if( !(cv instanceof VBool) )
            throw new InterpreterException("Eval error: Expected bool");

        return ((VBool)cv).getVal() ? exp_a.eval(env) : exp_b.eval(env);
    }

    @Override
    public void compile(CodeBlock c) {

    }
}
