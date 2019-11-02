package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.Tag;
import procedures.DeclProcedure;

public class DeclListProcedure extends Procedure {
    public DeclListProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        new DeclProcedure(this.lexical).check(t);
        t = this.lexical.findNextToken();
        new DeclAsteriskProcedure(this.lexical).check(t);
    }
}