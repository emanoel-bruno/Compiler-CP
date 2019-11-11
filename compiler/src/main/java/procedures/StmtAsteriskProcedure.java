package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class StmtAsteriskProcedure extends Procedure {

    public StmtAsteriskProcedure() {
        this.tag = Procedure.STMT_ASTERISK_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        if (t.getTag() == Tag.PRINT || t.getTag() == Tag.SCAN || t.getTag() == Tag.DO || t.getTag() == Tag.IF
                || t.getTag() == Tag.IDENTIFIER) {
            this.invoke(Procedure.STMT_PROCEDURE, false);
            this.invoke(Procedure.STMT_ASTERISK_PROCEDURE, false);
        }
    }
}