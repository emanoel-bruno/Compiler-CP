package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class ReadStmtProcedure extends Procedure {

    public ReadStmtProcedure() {
        this.tag = Procedure.READSTMT_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.SCAN);
        this.consume(Tag.OPEN_PARENTHESIS);
        this.consume(Tag.IDENTIFIER);
        this.consume(Tag.CLOSE_PARENTHESIS);
        
    }
}