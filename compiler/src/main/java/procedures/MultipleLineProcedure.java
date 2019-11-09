package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.Tag;

public class MultipleLineProcedure  extends Procedure {
      
    public MultipleLineProcedure() {
        this.tag = Procedure.MULTIPLE_LINE_PROCEDURE;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.rule(t);
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.PLUS:
            this.consume(Tag.PLUS, false);
            this.invoke(Procedure.MULTIPLE_LINE_ASTERISK_PROCEDURE, true);
        default:
            this.invoke(Procedure.MULTIPLE_LINE_PROCEDURE, true); // This token can be anything so it just
                                                                // move ahead until find "*"
            break;
        }
    }
}