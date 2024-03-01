package Ast;

import Exceptions.*;
import values.*;

public class ASTNeg implements ASTNode {

    ASTNode val;


    public IValue eval(Environment<IValue> env) throws InterpreterException {


        IValue v1 = val.eval(env);

        if(!(v1 instanceof VInt))
            throw new InvalidTypeException("Invalid type while performing negation operation");


        VInt val_int = (VInt)v1;

        return new VInt( -val_int.getVal() );


    }

    public ASTNeg(ASTNode n) {
        val = n;
    }

    public void compile(CodeBlock c) {
        val.compile(c);
        val.compile(c);
        c.emit("ineg");
    }

}