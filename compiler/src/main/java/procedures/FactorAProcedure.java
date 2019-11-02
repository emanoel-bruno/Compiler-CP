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

public class FactorAProcedure extends Procedure {
    public FactorAProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = this.lexical.getLine();
        switch (t.getTag()) {
        case Tag.IDENTIFIER:
        case Tag.INTEGER_CONSTANT:
        case Tag.FLOAT_CONSTANT:
        case Tag.LITERAL:
        case Tag.OPEN_PARENTHESIS:
            new FactorProcedure(this.lexical).check(t);
            break;
        case Tag.MINUS:
        case Tag.NOT:
            t=t = this.lexical.findNextToken();
            new FactorProcedure(this.lexical).check(t);
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}