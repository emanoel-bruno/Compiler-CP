package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class SimpleExprAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.PLUS:
        case Tag.MINUS:
        case Tag.OR:
            t = SyntaxAnalyser.nextToken();
            new TermProcedure().check(t);
            t = SyntaxAnalyser.currentToken(); // TermProcedure already moved one step forward
            this.check(t);
            break;
        }
    }
}