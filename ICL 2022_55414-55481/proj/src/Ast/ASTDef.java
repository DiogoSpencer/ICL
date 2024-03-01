package Ast;

import Exceptions.InterpreterException;
import values.IValue;

import java.util.List;
import java.util.Map;

public class ASTDef implements ASTNode {


    ASTNode exp;
    Map<String,ASTNode> definitions;


    public ASTDef(Map<String,ASTNode> map, ASTNode t)
    {
        this.definitions = map;
        this.exp = t;
    }


    public IValue eval(Environment env) throws InterpreterException {

        env = env.beginScope();


        for(java.util.Map.Entry<String, ASTNode> def : definitions.entrySet()){

            String id = def.getKey();
            ASTNode expression = def.getValue();

            IValue evalExp = expression.eval(env);

            env.assoc(id,evalExp);


        }

        IValue val = exp.eval(env);
        env = env.endScope();
        return val;
    }


        public void compile (CodeBlock c){

        }
    }

