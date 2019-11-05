package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.Tag;

public class MultipleCommentProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.PLUS, false);
        this.invoke(Procedure.MULTIPLE_COMMENT_ASTERISK_PROCEDURE, true);
    }
}