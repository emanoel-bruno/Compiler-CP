package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class ReadStmtProcedure extends Procedure {

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.SCAN, false);
        this.consume(Tag.OPEN_PARENTHESIS, true);
        this.consume(Tag.IDENTIFIER, true);
        this.consume(Tag.CLOSE_PARENTHESIS, true);
    }
}