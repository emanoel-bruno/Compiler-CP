package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class AssignStmtProcedure extends Procedure {

    public AssignStmtProcedure() {
        this.tag = Procedure.ASSIGNSTMT_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.IDENTIFIER);
        this.consume(Tag.ASSIGN);
        this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
    }
}