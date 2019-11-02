package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class ConditionProcedure extends Procedure {
    public ConditionProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new ExpressionProcedure(this.lexical).check(t);
    }
}