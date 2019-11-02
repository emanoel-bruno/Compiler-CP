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

public class TermAsteriskProcedure extends Procedure {
    public TermAsteriskProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
            case Tag.TIMES:
            case Tag.DIVIDER:
            case Tag.AND:
                t = this.lexical.findNextToken();
                new FactorAProcedure(this.lexical).check(t);
                t = this.lexical.findNextToken();
                this.check(t);
                break;
        } 
    }
}