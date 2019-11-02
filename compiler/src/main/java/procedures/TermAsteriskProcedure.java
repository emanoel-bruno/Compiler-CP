package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class TermAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.TIMES:
        case Tag.DIVIDER:
        case Tag.AND:
            t = SyntaxAnalyser.nextToken();
            new FactorAProcedure().check(t);
            t = SyntaxAnalyser.nextToken();
            this.check(t);
            break;
        }
    }
}