package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.Tag;

public class DeclListProcedure  extends Procedure {
      
    public DeclListProcedure() {
        this.tag = Procedure.DECLLIST_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        if (t.getTag() == Tag.INT || t.getTag() == Tag.FLOAT || t.getTag() == Tag.STRING) {
            this.invoke(Procedure.DECL_PROCEDURE, false);
            this.invoke(Procedure.DECLLIST_PROCEDURE, true);
        }
    }
}