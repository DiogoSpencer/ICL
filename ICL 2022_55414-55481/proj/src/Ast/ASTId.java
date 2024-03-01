package Ast;

import Exceptions.*;
import values.*;

public class ASTId implements ASTNode {

    String id;

    public ASTId(String id) {
        this.id = id;
    }

    public IValue eval(Environment<IValue> env) throws InterpreterException {

        try {
            return env.find(id);
        }
        catch (InvalidIdException e) {
            throw new InterpreterException(e.getMessage());
        }
    }


    public void compile(CodeBlock	c)	{
        //fazer

    }
}

