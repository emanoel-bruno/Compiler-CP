package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class ExpressionProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new SimpleExprProcedure().check(t);
        t = SyntaxAnalyser.currentToken(); // SimpleExprProcedure already moved one step forward
        new ExpressionAsteriskProcedure().check(t);
    }
}