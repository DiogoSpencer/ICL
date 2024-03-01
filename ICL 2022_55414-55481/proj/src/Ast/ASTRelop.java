package Ast;

import Exceptions.*;
import values.*;

public class ASTRelop implements ASTNode{

    ASTNode lhs, rhs;
    String op;

    public ASTRelop(ASTNode l, String operator, ASTNode r) {
        lhs = l;
        rhs = r;
        op = operator;
    }




    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue v1 = lhs.eval(env);
        IValue v2 = rhs.eval(env);

        if(!(v1 instanceof VInt) || !(v2 instanceof VInt))
            throw new InvalidTypeException("Invalid type while performing relational operation");

        int v1_int = ( (VInt)v1 ).getVal();
        int v2_int = ( (VInt)v2 ).getVal();

        switch(op) {

            case ">" : return new VBool(v1_int >  v2_int);
            case "<" : return new VBool(v1_int <  v2_int);
            case "==": return new VBool(v1_int == v2_int);
            case ">=": return new VBool(v1_int >= v2_int);
            case "<=": return new VBool(v1_int <= v2_int);
        }

        throw new InterpreterException("Invalid token");
    }

    @Override
    public void compile(CodeBlock c) {

    }
}
