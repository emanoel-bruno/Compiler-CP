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

public class IfStmtAsteriskProcedure  extends Procedure {
      
    public IfStmtAsteriskProcedure() {
        this.tag = Procedure.IFSTMT_ASTERISK_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.END:
            this.consume(Tag.END, false);
            break;
        case Tag.ELSE:
            this.consume(Tag.ELSE, false);
            this.invoke(StmtListProcedure.STMTLIST_PROCEDURE, true);
            this.consume(Tag.END, false); // StmtList already moved one step
        default:
            PanicMode.nextToken(this, t, new int[] {Tag.END, Tag.ELSE});
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}