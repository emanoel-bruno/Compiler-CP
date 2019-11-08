package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class WriteStmtProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        if(t.getTag() != Tag.NEW_LINE){
            this.rule(t);
        } else{
            t = SyntaxAnalyser.nextToken();
            this.check(t);
        }
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.PRINT, false);
        this.consume(Tag.OPEN_PARENTHESIS, true);
        this.invoke(Procedure.WRITEABLE_PROCEDURE, true);
        this.consume(Tag.CLOSE_PARENTHESIS, false); // WriteableProcedure already moved one step forward
    }
}