package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class IfStmtProcedure extends Procedure {

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
        this.consume(Tag.IF, false);
        this.invoke(Procedure.CONDITION_PROCEDURE, true);
        this.consume(Tag.THEN, false); // Expression Procedure already moved one step
        this.invoke(Procedure.STMTLIST_PROCEDURE, true);
        this.invoke(Procedure.IFSTMT_ASTERISK_PROCEDURE, false); // StmtList already moved one step forward
    }
}