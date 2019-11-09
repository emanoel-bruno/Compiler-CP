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

public class StmtProcedure  extends Procedure {
      
    public StmtProcedure() {
        this.tag = Procedure.STMT_PROCEDURE;
    }

    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.DIVIDER:
            this.consume(Tag.DIVIDER, false);
            this.invoke(Procedure.COMMENT_PROCEDURE, true);
            break;
        case Tag.PRINT:
            this.invoke(Procedure.WRITESTMT_PROCEDURE, false);
            consume(Tag.SEMICOLON, true);
            break;
        case Tag.SCAN:
            this.invoke(Procedure.READSTMT_PROCEDURE, false);
            consume(Tag.SEMICOLON, true);
            break;
        case Tag.DO:
            this.invoke(Procedure.WHILESTMT_PROCEDURE, false);
            break;
        case Tag.IF:
            this.invoke(Procedure.IFSTMT_PROCEDURE, false);
            break;
        case Tag.IDENTIFIER:
            this.invoke(Procedure.ASSIGNSTMT_PROCEDURE, false);
            consume(Tag.SEMICOLON, false); // SimpleExprProcedure already moved one step
            break;
        default:
            PanicMode.nextToken(this, t, new int[]{Tag.DIVIDER, Tag.PRINT, Tag.SCAN, Tag.DO, Tag.IF, Tag.IDENTIFIER});
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}