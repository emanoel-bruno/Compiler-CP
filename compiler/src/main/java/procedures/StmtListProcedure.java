package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import procedures.StmtProcedure;
import procedures.StmtAsteriskProcedure;

public class StmtListProcedure extends Procedure {
    public StmtListProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new StmtProcedure(lexical).check(t);
        t = this.lexical.findNextToken();
        new StmtAsteriskProcedure(lexical).check(t);
    }
}