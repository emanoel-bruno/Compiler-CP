package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class WhileStmtProcedure extends Procedure {

    public WhileStmtProcedure() {
        this.tag = Procedure.WHILESTMT_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.DO, false);
        this.invoke(Procedure.STMTLIST_PROCEDURE, true);
        this.invoke(Procedure.STMTSUFIX_PROCEDURE, false); // StmtListProcedure move one step forward
    }
}