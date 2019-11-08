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

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        if(t.getTag() != Tag.NEW_LINE){
            this.rule(t);
        } else{
            t = SyntaxAnalyser.nextToken();
            this.check(t);
        }
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
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
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}