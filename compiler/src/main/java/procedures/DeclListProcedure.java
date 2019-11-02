package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import procedures.DeclProcedure;

public class DeclListProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new DeclProcedure().check(t);
        t = SyntaxAnalyser.nextToken();
        new DeclAsteriskProcedure().check(t);
    }
}