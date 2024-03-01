package Ast;

import Exceptions.*;
import values.*;

public class ASTNegBool implements ASTNode{


    ASTNode n;

    public ASTNegBool(ASTNode n) {
        this.n = n;
    }




    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue val = n.eval(env);

        if(!(val instanceof VBool))
            throw new InvalidTypeException("Invalid type while performing minus operation");

        VBool bool_val = (VBool)val;

        return new VBool( !bool_val.getVal() );
    }

    @Override
    public void compile(CodeBlock c) {

    }
}
