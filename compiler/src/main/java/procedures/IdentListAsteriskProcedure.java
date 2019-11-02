package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class IdentListAsteriskProcedure extends Procedure {
    public IdentListAsteriskProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.COMMA:
            consume(Tag.IDENTIFIER, true);
            t=t = this.lexical.findNextToken();
            this.check(t);    
            break;
        }
    }
}