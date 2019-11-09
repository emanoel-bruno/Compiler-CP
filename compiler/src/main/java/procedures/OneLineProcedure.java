package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class OneLineProcedure extends Procedure {
    
    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.rule(t);
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.NEW_LINE:
            this.consume(Tag.NEW_LINE, false);
        default:
            this.invoke(Procedure.ONE_LINE_PROCEDURE, true); // This token can be anything so it just
                                                             // move ahead until find "\n"
            break;
        }
    }
}