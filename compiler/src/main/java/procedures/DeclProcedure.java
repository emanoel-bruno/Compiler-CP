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

public class DeclProcedure extends Procedure {

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
        case Tag.INT:
            this.consume(Tag.INT, false);
            this.invoke(Procedure.IDENTLIST_PROCEDURE, true);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            break;
        case Tag.FLOAT:
            this.consume(Tag.FLOAT, false);
            this.invoke(Procedure.IDENTLIST_PROCEDURE, true);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            break;
        case Tag.STRING:
            this.consume(Tag.STRING, false);
            this.invoke(Procedure.IDENTLIST_PROCEDURE, true);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}