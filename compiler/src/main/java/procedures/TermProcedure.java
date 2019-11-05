package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class TermProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.FACTORA_PROCEDURE, false);
        this.invoke(Procedure.TERM_ASTERISK_PROCEDURE, true);
    }
}