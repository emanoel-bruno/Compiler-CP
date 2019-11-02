package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import procedures.StmtProcedure;
import procedures.StmtAsteriskProcedure;

public class StmtListProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new StmtProcedure().check(t);
        t = SyntaxAnalyser.nextToken();
        new StmtAsteriskProcedure().check(t);
    }
}