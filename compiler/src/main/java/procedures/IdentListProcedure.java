package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class IdentListProcedure extends Procedure {

    public IdentListProcedure() {
        this.tag = Procedure.IDENTLIST_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.IDENTIFIER);
        this.invoke(Procedure.IDENTLIST_ASTERISK_PROCEDURE);
    }
}