package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import compiler.PanicMode;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.Procedure;

public class ExpressionProcedure extends Procedure {
    public ExpressionProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new SimpleExprProcedure(this.lexical).check(t);
        t = this.lexical.getCurrentToken(); // SimpleExprProcedure already moved one step forward
        new ExpressionAsteriskProcedure(this.lexical).check(t);
    }
}