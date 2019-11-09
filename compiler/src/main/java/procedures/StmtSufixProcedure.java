package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class StmtSufixProcedure extends Procedure {

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.WHILE, false);
        this.invoke(Procedure.CONDITION_PROCEDURE, true);
        this.consume(Tag.END, false); // ConditionProcedure already moved one step forward
    }
}