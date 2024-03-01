import Ast.ASTNode;
import Ast.Environment;
import Exceptions.*;
import values.*;

public class ICLInterpreter {

    public static void main(String args[]) {

        ParserICL parser = new ParserICL(System.in);

        ASTNode exp;

        while (true) {
            try {
                System.out.print("> ");
                ASTNode ast = parser.Start();

                if (ast == null)
                    System.exit(0);


                ast.eval(new Environment<IValue>()).print();
            }
            catch(ParseException e) {
                System.out.println("Syntax error: " + e.getMessage());
                parser.ReInit(System.in);
            }
            catch(InvalidTypeException e) {

                System.out.println("Type error: " + e.getMessage());
                parser.ReInit(System.in);
            }
            catch (InterpreterException e) {
                System.out.println("Syntax error: " + e.getMessage());
                parser.ReInit(System.in);
            }
        }
    }

}