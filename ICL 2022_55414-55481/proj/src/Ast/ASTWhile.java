package Ast;

import Exceptions.*;
import values.*;

public class ASTWhile implements ASTNode{

    ASTNode cond, exp;


    public ASTWhile(ASTNode cond, ASTNode exp) {
        this.cond = cond;
        this.exp = exp;
    }


    @Override
    public IValue eval(Environment<IValue> env) throws InterpreterException {

        IValue res = null;
        IValue cv = cond.eval(env);

        try {

            while( ((VBool)cv).getVal() ) {

                res = exp.eval(env);
                cv = cond.eval(env);
            }
        }
        catch(ClassCastException e) {

            throw new InterpreterException("Eval error: Expected bool");
        }

        return res;
    }

    @Override
    public void compile(CodeBlock c) {

    }
}
