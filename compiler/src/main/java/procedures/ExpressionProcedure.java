package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class ExpressionProcedure  extends Procedure {
      
    public ExpressionProcedure() {
        this.tag = Procedure.EXPRESSION_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, false);
        this.invoke(Procedure.EXPRESSION_ASTERISK_PROCEDURE, false);
    }
}