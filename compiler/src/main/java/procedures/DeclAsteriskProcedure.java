package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import procedures.DeclProcedure;

public class DeclAsteriskProcedure extends Procedure {
    public DeclAsteriskProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        switch (t.getTag()) {
        case Tag.INT:
        case Tag.FLOAT:
        case Tag.STRING:
            new DeclProcedure(this.lexical).check(t);
            t = this.lexical.findNextToken();
            this.check(t);
            break;
        }
    }
}