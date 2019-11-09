package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class IdentListProcedure  extends Procedure {
      
    public IdentListProcedure() {
        this.tag = Procedure.IDENTLIST_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.IDENTIFIER, false);
        this.invoke(Procedure.IDENTLIST_ASTERISK_PROCEDURE, true);
    }
}