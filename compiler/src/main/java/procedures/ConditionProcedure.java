package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class ConditionProcedure  extends Procedure {
      
    public ConditionProcedure() {
        this.tag = Procedure.CONDITION_PROCEDURE;
    }
    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.EXPRESSION_PROCEDURE, false);
    }
}