package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class WhileStmtProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.DO, false);
        this.invoke(Procedure.STMTLIST_PROCEDURE, true);
        this.invoke(Procedure.STMTSUFIX_PROCEDURE, false); // StmtListProcedure move one step forward
    }
}