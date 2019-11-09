package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class SimpleExprProcedure extends Procedure {

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.TERM_PROCEDURE, false);
        this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE, false); // TermProcedure already moved one step forward
    }
}