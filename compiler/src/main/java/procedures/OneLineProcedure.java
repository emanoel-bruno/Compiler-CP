package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class OneLineProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.rule(t);
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.PLUS:
            this.consume(Tag.PLUS, false);
            t = SyntaxAnalyser.nextToken();
            if (t.getTag() == Tag.DIVIDER)
                this.consume(Tag.DIVIDER, true);
            else
                this.invoke(Procedure.MULTIPLE_COMMENT_ASTERISK_PROCEDURE, false);
            break;
        default:
            this.invoke(Procedure.MULTIPLE_COMMENT_ASTERISK_PROCEDURE, true); // This token can be anything so it just
                                                                              // move ahead until find */
            break;
        }
    }
}