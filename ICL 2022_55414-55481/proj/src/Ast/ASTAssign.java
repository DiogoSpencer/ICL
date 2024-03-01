package Ast;

import Exceptions.*;
import values.*;

public class ASTAssign implements ASTNode{

    ASTNode lhs, rhs;

    public ASTAssign(ASTNode lhs, ASTNode rhs) {

        this.lhs = lhs;
        this.rhs = rhs;
    }


    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue lval = lhs.eval(env);

        if(! (lval instanceof VCell) )
            throw new InvalidTypeException("Assign error: Expected CellVal");


        VCell cell = (VCell)lval;
        IValue rval = rhs.eval(env);

        if(!cell.get().getClass().isAssignableFrom(rval.getClass()))
            throw new InvalidTypeException("Assign error: Expected " + cell.get().getClass().getName());

        cell.set(rval);
        return rval;
    }

    @Override
    public void compile(CodeBlock c) {

    }


}
