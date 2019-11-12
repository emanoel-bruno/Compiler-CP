package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class WriteableProcedure extends Procedure {

    public WriteableProcedure() {
        this.tag = Procedure.WRITEABLE_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.invoke(Procedure.SIMPLEEXPR_PROCEDURE);
    }
}