package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import procedures.DeclProcedure;

public class DeclAsteriskProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.INT:
        case Tag.FLOAT:
        case Tag.STRING:
            new DeclProcedure().check(t);
            t = SyntaxAnalyser.nextToken();
            this.check(t);
            break;
        }
    }
}