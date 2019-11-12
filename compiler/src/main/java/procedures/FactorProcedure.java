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

    public FactorProcedure() {
        this.tag = Procedure.FACTOR_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.IDENTIFIER:
            this.consume(Tag.IDENTIFIER);
            
            break;
        case Tag.INTEGER_CONSTANT:
            this.consume(Tag.INTEGER_CONSTANT);
            
            break;
        case Tag.FLOAT_CONSTANT:
            this.consume(Tag.FLOAT_CONSTANT);
            
            break;
        case Tag.LITERAL:
            this.consume(Tag.LITERAL);
            
            break;
        case Tag.OPEN_PARENTHESIS:
            this.consume(Tag.OPEN_PARENTHESIS);
            this.invoke(Procedure.EXPRESSION_PROCEDURE);
            this.consume(Tag.CLOSE_PARENTHESIS); // ExpressionProcedure already moved one step forward
            
            break;
        default:
            PanicMode.nextToken(this, t, new int[] { Tag.IDENTIFIER, Tag.INTEGER_CONSTANT, Tag.FLOAT_CONSTANT,
                    Tag.LITERAL, Tag.OPEN_PARENTHESIS });
            SyntaxAnalyser.printError("\n  Unexpected Token: " + t.toString(), line);
        }
    }
}