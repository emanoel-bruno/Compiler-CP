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

public class FactorProcedure extends Procedure {
    public FactorProcedure(LexicalAnalyser lexical) {
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
            t=t = this.lexical.findNextToken();
            break;
        case Tag.OPEN_PARENTHESIS:
            this.consume(Tag.OPEN_PARENTHESIS, false);
            t = this.lexical.findNextToken();
            new ExpressionProcedure(this.lexical).check(t);
            this.consume(Tag.CLOSE_PARENTHESIS, false); // ExpressionProcedure already moved one step forward          
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}