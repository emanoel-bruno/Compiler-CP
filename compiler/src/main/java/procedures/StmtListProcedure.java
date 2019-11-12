package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class StmtListProcedure extends Procedure {

    public StmtListProcedure() {
        this.tag = Procedure.STMTLIST_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.invoke(Procedure.STMT_PROCEDURE);
        this.invoke(Procedure.STMT_ASTERISK_PROCEDURE);
    }
}