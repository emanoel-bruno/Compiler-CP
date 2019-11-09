package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class WriteableProcedure  extends Procedure {
      
    public WriteableProcedure() {
        this.tag = Procedure.WRITEABLE_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, false);
    }
}