package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class ConditionProcedure extends Procedure {

    public ConditionProcedure() {
        this.tag = Procedure.CONDITION_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.invoke(Procedure.EXPRESSION_PROCEDURE);
    }
}