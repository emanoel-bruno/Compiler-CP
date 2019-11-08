package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class StmtAsteriskProcedure extends Procedure {

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
        if (t.getTag() == Tag.DIVIDER || t.getTag() == Tag.PRINT || t.getTag() == Tag.SCAN
                || t.getTag() == Tag.DO || t.getTag() == Tag.IF || t.getTag() == Tag.IDENTIFIER) {
            this.invoke(Procedure.STMT_PROCEDURE, false);
            this.invoke(Procedure.STMT_ASTERISK_PROCEDURE, true);
        }
    }
}