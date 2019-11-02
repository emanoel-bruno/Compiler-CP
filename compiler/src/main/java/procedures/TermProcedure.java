package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class TermProcedure extends Procedure {
    public TermProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new FactorAProcedure(this.lexical).check(t);
        t = this.lexical.findNextToken();
        new TermAsteriskProcedure(this.lexical).check(t);
    }
}