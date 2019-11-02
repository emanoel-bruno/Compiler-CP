package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import compiler.PanicMode;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.Procedure;

public class WhileStmtProcedure extends Procedure {
    public WhileStmtProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = this.lexical.getLine();
        switch (t.getTag()) {
        case Tag.DO:
            t = this.lexical.findNextToken();
            new StmtListProcedure(this.lexical).check(t);
            t = this.lexical.getCurrentToken(); // StmtListProcedure move one step forward
            new StmtSufixProcedure(lexical).check(t);
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}