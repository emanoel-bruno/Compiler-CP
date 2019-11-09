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

public class FactorProcedure  extends Procedure {
      
    public FactorProcedure() {
        this.tag = Procedure.FACTOR_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.IDENTIFIER:
            this.consume(Tag.IDENTIFIER, false);
            break;
        case Tag.INTEGER_CONSTANT:
            this.consume(Tag.INTEGER_CONSTANT, false);
            break;
        case Tag.FLOAT_CONSTANT:
            this.consume(Tag.FLOAT_CONSTANT, false);
            break;
        case Tag.LITERAL:
            this.consume(Tag.LITERAL, false);
            break;
        case Tag.OPEN_PARENTHESIS:
            this.consume(Tag.OPEN_PARENTHESIS, false);
            this.invoke(Procedure.EXPRESSION_PROCEDURE, true);
            this.consume(Tag.CLOSE_PARENTHESIS, false); // ExpressionProcedure already moved one step forward
            break;
        default:
            PanicMode.nextToken(this, t, new int[]{Tag.IDENTIFIER,Tag.INTEGER_CONSTANT,Tag.FLOAT_CONSTANT, Tag.LITERAL, Tag.OPEN_PARENTHESIS});
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}