package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import procedures.StmtProcedure;

public class StmtAsteriskProcedure extends Procedure {
    public StmtAsteriskProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.PRINT:
        case Tag.SCAN:
        case Tag.DO:
        case Tag.IF:
        case Tag.IDENTIFIER:
            new StmtProcedure(lexical).check(t);
            t = this.lexical.findNextToken();
            this.check(t);
            break;
        }
    }
}