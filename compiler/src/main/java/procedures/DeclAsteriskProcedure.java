package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class DeclAsteriskProcedure extends Procedure {

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        if (t.getTag() == Tag.INT || t.getTag() == Tag.FLOAT || t.getTag() == Tag.STRING) {
            this.invoke(Procedure.DECL_PROCEDURE, false);
            this.invoke(Procedure.DECL_ASTERISK_PROCEDURE, true);
        }
    }
}