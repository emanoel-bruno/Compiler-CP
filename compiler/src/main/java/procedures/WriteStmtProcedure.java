package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class WriteStmtProcedure extends Procedure {

    public WriteStmtProcedure() {
        this.tag = Procedure.WRITESTMT_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.PRINT);
        this.consume(Tag.OPEN_PARENTHESIS);
        this.invoke(Procedure.WRITEABLE_PROCEDURE);
        this.consume(Tag.CLOSE_PARENTHESIS); // WriteableProcedure already moved one step forward
        
    }
}