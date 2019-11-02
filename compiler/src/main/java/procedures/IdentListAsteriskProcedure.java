package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class IdentListAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.COMMA:
            consume(Tag.IDENTIFIER, true);
            t = SyntaxAnalyser.nextToken();
            this.check(t);
            break;
        }
    }
}