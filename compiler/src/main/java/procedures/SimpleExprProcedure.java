package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import procedures.SimpleExprAsteriskProcedure;

public class SimpleExprProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new TermProcedure().check(t);
        t = SyntaxAnalyser.currentToken(); // TermProcedure already moved one step forward
        new SimpleExprAsteriskProcedure().check(t);
    }
}