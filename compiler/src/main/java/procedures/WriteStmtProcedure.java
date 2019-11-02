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

public class WriteStmtProcedure extends Procedure {
    public WriteStmtProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = this.lexical.getLine();
        switch (t.getTag()) {
        case Tag.PRINT:
            this.consume(Tag.OPEN_PARENTHESIS, true);
            t = this.lexical.findNextToken();
            new WriteableProcedure(lexical).check(t);
            this.consume(Tag.CLOSE_PARENTHESIS, false); // WriteableProcedure already moved one step forward
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}