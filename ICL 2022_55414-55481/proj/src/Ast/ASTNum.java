package Ast;

import values.*;
import values.VInt;

public class ASTNum implements ASTNode {

    int val;

    public IValue eval(Environment<IValue> env) {
        return new VInt(val);
    }

    public ASTNum(int n) {
        val = n;
    }

    public void compile(CodeBlock cb) {
        cb.emit("sipush " + val);
    }

}

