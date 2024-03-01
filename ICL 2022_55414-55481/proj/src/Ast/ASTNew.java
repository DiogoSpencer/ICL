package Ast;

import Exceptions.*;
import values.*;

public class ASTNew implements ASTNode{

    ASTNode exp;

    public ASTNew(ASTNode exp) {

        this.exp = exp;
    }

    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue v = exp.eval(env);
        return new VCell(v);
    }

    @Override
    public void compile(CodeBlock c) {

    }


}
