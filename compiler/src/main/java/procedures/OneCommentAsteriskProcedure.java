package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.Tag;

public class OneCommentAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.NEW_LINE:
            this.consume(Tag.NEW_LINE, false);
            break;
        default:
            this.invoke(Procedure.ONE_COMMENT_ASTERISK_PROCEDURE, true); // This token can be anything so it just move
                                                                         // ahead until find NEW_LINE
            break;
        }
    }
}