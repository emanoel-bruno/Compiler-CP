package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class WriteableProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new SimpleExprProcedure().check(t);
    }
}