package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.PanicMode;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class FactorProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.IDENTIFIER:
        case Tag.INTEGER_CONSTANT:
        case Tag.FLOAT_CONSTANT:
        case Tag.LITERAL:
            t = SyntaxAnalyser.nextToken();
            break;
        case Tag.OPEN_PARENTHESIS:
            this.consume(Tag.OPEN_PARENTHESIS, false);
            t = SyntaxAnalyser.nextToken();
            new ExpressionProcedure().check(t);
            this.consume(Tag.CLOSE_PARENTHESIS, false); // ExpressionProcedure already moved one step forward
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}