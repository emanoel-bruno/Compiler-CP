package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.PanicMode;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import compiler.Tag;

public class CommentProcedure extends Procedure {

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
            case Tag.DIVIDER:
                this.consume(Tag.DIVIDER, false);
                this.invoke(Procedure.ONE_LINE_PROCEDURE, true);
                break;
            case Tag.PLUS:
                this.consume(Tag.PLUS, false);
                this.invoke(Procedure.MULTIPLE_LINE_PROCEDURE, true);
                break;
            default:
                PanicMode.nextToken(this, t.getTag());
                throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}