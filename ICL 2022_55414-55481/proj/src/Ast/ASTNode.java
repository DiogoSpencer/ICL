package Ast;

import Exceptions.*;
import values.IValue;

import java.io.PrintStream;

public interface ASTNode{
    IValue eval(Environment<IValue> env) throws InterpreterException;;
    void compile(CodeBlock c);
  }


class CodeBlock	{

    String code[];
    int	pc;
    void emit(String opcode){
        code[pc++] = opcode;
    }

    void dump(PrintStream f){



            //ler ficheiro de txt com expressao
            //fazer ficheiro tipo jasmin com a expressao
            //correr com o jasmin
            //devolver o resultado da expressao



    }

}

