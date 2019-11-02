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
import procedures.IdentListProcedure;

public class DeclProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.INT:
        case Tag.FLOAT:
        case Tag.STRING:
            t = SyntaxAnalyser.nextToken();
            new IdentListProcedure().check(t);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}