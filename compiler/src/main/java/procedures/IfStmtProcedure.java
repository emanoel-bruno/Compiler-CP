package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class IfStmtProcedure extends Procedure {

    public IfStmtProcedure() {
        this.tag = Procedure.IFSTMT_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.IF);
        this.invoke(Procedure.CONDITION_PROCEDURE);
        this.consume(Tag.THEN); // Expression Procedure already moved one step
        this.invoke(Procedure.STMTLIST_PROCEDURE);
        this.invoke(Procedure.IFSTMT_ASTERISK_PROCEDURE); // StmtList already moved one step forward
    }
}