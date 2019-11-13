package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import compiler.Tag;

public class DeclListProcedure extends Procedure {

    public DeclListProcedure() {
        this.tag = Procedure.DECLLIST_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        if (t.getTag() == Tag.INT || t.getTag() == Tag.FLOAT || t.getTag() == Tag.STRING) {
            this.invoke(Procedure.DECL_PROCEDURE);
            this.invoke(Procedure.DECLLIST_PROCEDURE);
        }
    }
}