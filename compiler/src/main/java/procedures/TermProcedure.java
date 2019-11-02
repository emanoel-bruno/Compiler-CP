package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class TermProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new FactorAProcedure().check(t);
        t = SyntaxAnalyser.nextToken();
        new TermAsteriskProcedure().check(t);
    }
}