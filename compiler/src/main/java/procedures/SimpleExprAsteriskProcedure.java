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

public class SimpleExprAsteriskProcedure extends Procedure {
    public SimpleExprAsteriskProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
            case Tag.PLUS:
            case Tag.MINUS:
            case Tag.OR:
                t = this.lexical.findNextToken();
                new TermProcedure(this.lexical).check(t);
                t = this.lexical.getCurrentToken(); // TermProcedure already moved one step forward
                this.check(t);
                break;
        } 
    }
}