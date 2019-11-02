package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class ExpressionAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.EQUAL:
        case Tag.BIGGER:
        case Tag.BIGGER_EQUAL:
        case Tag.SMALLER:
        case Tag.SMALLER_EQUAL:
        case Tag.DOUBLE_ARROW:
            t = SyntaxAnalyser.nextToken();
            new SimpleExprProcedure().check(t);
            break;
        }
    }
}