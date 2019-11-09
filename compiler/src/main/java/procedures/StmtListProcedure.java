package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class StmtListProcedure  extends Procedure {
      
    public StmtListProcedure() {
        this.tag = Procedure.STMTLIST_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.STMT_PROCEDURE, false);
        this.invoke(Procedure.STMT_ASTERISK_PROCEDURE, true);
    }
}