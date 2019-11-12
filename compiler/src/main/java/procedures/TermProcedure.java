package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class TermProcedure extends Procedure {

    public TermProcedure() {
        this.tag = Procedure.TERM_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.invoke(Procedure.FACTORA_PROCEDURE);
        this.invoke(Procedure.TERM_ASTERISK_PROCEDURE);
    }
}