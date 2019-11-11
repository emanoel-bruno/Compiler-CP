package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class IdentListAsteriskProcedure extends Procedure {

    public IdentListAsteriskProcedure() {
        this.tag = Procedure.IDENTLIST_ASTERISK_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        if (t.getTag() == Tag.COMMA) {
            this.consume(Tag.COMMA, false);
            this.consume(Tag.IDENTIFIER, true);
            this.invoke(Procedure.IDENTLIST_ASTERISK_PROCEDURE, true);
        }
    }
}