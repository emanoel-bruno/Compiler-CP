package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import procedures.StmtProcedure;

public class StmtAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.PRINT:
        case Tag.SCAN:
        case Tag.DO:
        case Tag.IF:
        case Tag.IDENTIFIER:
            new StmtProcedure().check(t);
            t = SyntaxAnalyser.nextToken();
            this.check(t);
            break;
        }
    }
}