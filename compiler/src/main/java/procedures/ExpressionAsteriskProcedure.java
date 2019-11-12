package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class ExpressionAsteriskProcedure extends Procedure {

    public ExpressionAsteriskProcedure() {
        this.tag = Procedure.EXPRESSION_ASTERISK_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        switch (t.getTag()) {
        case Tag.EQUAL:
            this.consume(Tag.EQUAL);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
            break;
        case Tag.BIGGER:
            this.consume(Tag.BIGGER);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
            break;
        case Tag.BIGGER_EQUAL:
            this.consume(Tag.BIGGER_EQUAL);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
            break;
        case Tag.SMALLER:
            this.consume(Tag.SMALLER);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
            break;
        case Tag.SMALLER_EQUAL:
            this.consume(Tag.SMALLER_EQUAL);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
            break;
        case Tag.DOUBLE_ARROW:
            this.consume(Tag.DOUBLE_ARROW);
            this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
            break;
        }
    }
}