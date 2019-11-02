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

public class ExpressionAsteriskProcedure extends Procedure {
    public ExpressionAsteriskProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
            case Tag.EQUAL:
            case Tag.BIGGER:
            case Tag.BIGGER_EQUAL:
            case Tag.SMALLER:
            case Tag.SMALLER_EQUAL:
            case Tag.DOUBLE_ARROW:
                t = this.lexical.findNextToken();
                new SimpleExprProcedure(this.lexical).check(t);
                break;
        } 
    }
}