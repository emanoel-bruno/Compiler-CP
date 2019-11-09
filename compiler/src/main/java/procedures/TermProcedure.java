package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class TermProcedure  extends Procedure {
      
    public TermProcedure() {
        this.tag = Procedure.TERM_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.FACTORA_PROCEDURE, false);
        this.invoke(Procedure.TERM_ASTERISK_PROCEDURE, true);
    }
}