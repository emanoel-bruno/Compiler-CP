package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class ExpressionAsteriskProcedure extends Procedure {

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.EQUAL:
            this.consume(Tag.EQUAL, false);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, true);
            break;
        case Tag.BIGGER:
            this.consume(Tag.BIGGER, false);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, true);
            break;
        case Tag.BIGGER_EQUAL:
            this.consume(Tag.BIGGER_EQUAL, false);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, true);
            break;
        case Tag.SMALLER:
            this.consume(Tag.SMALLER, false);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, true);
            break;
        case Tag.SMALLER_EQUAL:
            this.consume(Tag.SMALLER_EQUAL, false);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, true);
            break;
        case Tag.DOUBLE_ARROW:
            this.consume(Tag.DOUBLE_ARROW, false);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, true);
            break;
        }
    }
}