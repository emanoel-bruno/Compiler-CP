package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import procedures.SimpleExprAsteriskProcedure;

public class SimpleExprProcedure extends Procedure {
    public SimpleExprProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new TermProcedure(this.lexical).check(t);
        t = this.lexical.getCurrentToken(); // TermProcedure already moved one step forward
        new SimpleExprAsteriskProcedure(this.lexical).check(t);
    }
}