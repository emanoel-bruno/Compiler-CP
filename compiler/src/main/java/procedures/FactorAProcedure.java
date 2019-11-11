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

public class FactorAProcedure extends Procedure {

    public FactorAProcedure() {
        this.tag = Procedure.FACTORA_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.IDENTIFIER:
        case Tag.INTEGER_CONSTANT:
        case Tag.FLOAT_CONSTANT:
        case Tag.LITERAL:
        case Tag.OPEN_PARENTHESIS:
            this.invoke(Procedure.FACTOR_PROCEDURE, false);
            break;
        case Tag.MINUS:
            this.consume(Tag.MINUS, false);
            this.invoke(Procedure.FACTOR_PROCEDURE, true);
            break;
        case Tag.NOT:
            this.consume(Tag.NOT, false);
            this.invoke(Procedure.FACTOR_PROCEDURE, true);
            break;
        default:
            PanicMode.nextToken(this, t, new int[] { Tag.IDENTIFIER, Tag.INTEGER_CONSTANT, Tag.FLOAT_CONSTANT,
                    Tag.LITERAL, Tag.OPEN_PARENTHESIS, Tag.MINUS, Tag.NOT });
            SyntaxAnalyser.printError("\n  Unexpected Token: " + t.toString(), line);
        }
    }
}