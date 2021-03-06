package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class TermAsteriskProcedure extends Procedure {

    public TermAsteriskProcedure() {
        this.tag = Procedure.TERM_ASTERISK_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        switch (t.getTag()) {
        case Tag.TIMES:
            this.consume(Tag.TIMES);
            this.invoke(Procedure.FACTORA_PROCEDURE);
            this.invoke(Procedure.TERM_ASTERISK_PROCEDURE);
            break;
        case Tag.DIVIDER:
            this.consume(Tag.DIVIDER);
            this.invoke(Procedure.FACTORA_PROCEDURE);
            this.invoke(Procedure.TERM_ASTERISK_PROCEDURE);
            break;
        case Tag.AND:
            this.consume(Tag.AND);
            this.invoke(Procedure.FACTORA_PROCEDURE);
            this.invoke(Procedure.TERM_ASTERISK_PROCEDURE);
            break;
        }
    }
}