package Ast;

import Exceptions.*;
import values.*;

public class ASTPlus implements ASTNode {

    ASTNode lhs, rhs;

    public IValue eval(Environment<IValue> env) throws InterpreterException {
        IValue v1 = lhs.eval(env);
        IValue v2 = rhs.eval(env);


        if(!(v1 instanceof VInt) || !(v2 instanceof VInt))
            throw new InvalidTypeException("Invalid type while adding");


        VInt v1_int = (VInt)v1;
        VInt v2_int = (VInt)v2;

        return new VInt(v1_int.getVal() + v2_int.getVal());
    }

    public ASTPlus(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    public void compile(CodeBlock c) {
        lhs.compile(c);
        rhs.compile(c);
        c.emit("iadd");
    }
}

