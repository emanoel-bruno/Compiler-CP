package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.PanicMode;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class WriteStmtProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.PRINT:
            this.consume(Tag.OPEN_PARENTHESIS, true);
            t = SyntaxAnalyser.nextToken();
            new WriteableProcedure().check(t);
            this.consume(Tag.CLOSE_PARENTHESIS, false); // WriteableProcedure already moved one step forward
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}