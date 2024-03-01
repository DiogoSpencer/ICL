package Ast;

import Exceptions.*;
import values.*;

public class ASTAnd implements ASTNode{

    ASTNode lhs, rhs;

    public ASTAnd(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }


    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue v1 = lhs.eval(env);
        IValue v2 = rhs.eval(env);

        if(!(v1 instanceof VBool) || !(v2 instanceof VBool))
            throw new InvalidTypeException("Boolean multiplication Error: Expected a VBool");

        VBool v1_bool = (VBool)v1;
        VBool v2_bool = (VBool)v2;

        return new VBool(v1_bool.getVal() && v2_bool.getVal());
    }

    @Override
    public void compile(CodeBlock c) {

    }


}
