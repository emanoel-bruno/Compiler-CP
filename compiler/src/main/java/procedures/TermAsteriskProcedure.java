package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class TermAsteriskProcedure extends Procedure {

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.TIMES:
            this.consume(Tag.TIMES, false);
            this.invoke(Procedure.FACTORA_PROCEDURE, true);
            this.invoke(Procedure.TERM_ASTERISK_PROCEDURE, true);
            break;
        case Tag.DIVIDER:
            this.consume(Tag.DIVIDER, false);
            this.invoke(Procedure.FACTORA_PROCEDURE, true);
            this.invoke(Procedure.TERM_ASTERISK_PROCEDURE, true);
            break;
        case Tag.AND:
            this.consume(Tag.AND, false);
            this.invoke(Procedure.FACTORA_PROCEDURE, true);
            this.invoke(Procedure.TERM_ASTERISK_PROCEDURE, true);
            break;
        }
    }
}