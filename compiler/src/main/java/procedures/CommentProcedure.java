package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.PanicMode;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import compiler.Tag;

public class CommentProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.DIVIDER, false);
        t = SyntaxAnalyser.nextToken();
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.DIVIDER:
            this.invoke(Procedure.ONE_COMMENT_PROCEDURE, false);
            break;
        case Tag.PLUS:
            this.invoke(Procedure.MULTIPLE_COMMENT_PROCEDURE, false);
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}