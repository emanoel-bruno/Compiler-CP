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
import procedures.IdentListProcedure;

public class DeclProcedure extends Procedure {
    public DeclProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = this.lexical.getLine();
        switch (t.getTag()) {
        case Tag.INT:
        case Tag.FLOAT:
        case Tag.STRING:
            t = this.lexical.findNextToken();
            new IdentListProcedure(this.lexical).check(t);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}