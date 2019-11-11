package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class StmtSufixProcedure extends Procedure {

    public StmtSufixProcedure() {
        this.tag = Procedure.STMTSUFIX_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.WHILE, false);
        this.invoke(Procedure.CONDITION_PROCEDURE, true);
        this.consume(Tag.END, false); // ConditionProcedure already moved one step forward
        SyntaxAnalyser.nextToken();
    }
}