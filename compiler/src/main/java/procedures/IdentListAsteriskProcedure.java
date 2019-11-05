package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class IdentListAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        if (t.getTag() == Tag.COMMA) {
            this.consume(Tag.COMMA, false);
            consume(Tag.IDENTIFIER, true);
            this.invoke(Procedure.IDENTLIST_ASTERISK_PROCEDURE, true);
        }
    }
}