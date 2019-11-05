package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class StmtListProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.STMT_PROCEDURE, false);
        this.invoke(Procedure.STMT_ASTERISK_PROCEDURE, true);
    }
}