package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.PanicMode;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class IfStmtAsteriskProcedure extends Procedure {

    public IfStmtAsteriskProcedure() {
        this.tag = Procedure.IFSTMT_ASTERISK_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.END:
            this.consume(Tag.END);
            break;
        case Tag.ELSE:
            this.consume(Tag.ELSE);
            this.invoke(StmtListProcedure.STMTLIST_PROCEDURE);
            this.consume(Tag.END);
            break;
        default:
            PanicMode.nextToken(this, t, new int[] { Tag.END, Tag.ELSE });
            SyntaxAnalyser.printError("\n  Unexpected Token: " + t.toString(), line);
        }
    }
}