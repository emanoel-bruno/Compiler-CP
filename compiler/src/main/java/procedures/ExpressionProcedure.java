package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class ExpressionProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, false);
        this.invoke(Procedure.EXPRESSION_ASTERISK_PROCEDURE, false);
    }
}