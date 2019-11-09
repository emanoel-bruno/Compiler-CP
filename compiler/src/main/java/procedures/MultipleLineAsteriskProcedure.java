package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.Tag;

public class MultipleLineAsteriskProcedure  extends Procedure {
      
    public MultipleLineAsteriskProcedure() {
        this.tag = Procedure.MULTIPLE_LINE_ASTERISK_PROCEDURE;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.rule(t);
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.DIVIDER:
            this.consume(Tag.DIVIDER, false);
        default:
            this.invoke(Procedure.MULTIPLE_LINE_PROCEDURE, true); // This token can be anything so it just
                                                                // move ahead until find "\n"
            break;
        }
    }
}