package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class SimpleExprProcedure extends Procedure {

    public SimpleExprProcedure() {
        this.tag = Procedure.SIMPLEEXPR_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.invoke(Procedure.TERM_PROCEDURE);
        this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE); // TermProcedure already moved one step forward
    }
}