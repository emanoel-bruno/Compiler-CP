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

public class StmtProcedure extends Procedure {

    public StmtProcedure() {
        this.tag = Procedure.STMT_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.PRINT:
            this.invoke(Procedure.WRITESTMT_PROCEDURE);
            consume(Tag.SEMICOLON);
            
            break;
        case Tag.SCAN:
            this.invoke(Procedure.READSTMT_PROCEDURE);
            consume(Tag.SEMICOLON);
            
            break;
        case Tag.DO:
            this.invoke(Procedure.WHILESTMT_PROCEDURE);
            break;
        case Tag.IF:
            this.invoke(Procedure.IFSTMT_PROCEDURE);
            break;
        case Tag.IDENTIFIER:
            this.invoke(Procedure.ASSIGNSTMT_PROCEDURE);
            consume(Tag.SEMICOLON); // SimpleExprProcedure already moved one step
            
            break;
        default:
            PanicMode.nextToken(this, t, new int[] { Tag.PRINT, Tag.SCAN, Tag.DO, Tag.IF, Tag.IDENTIFIER });
            SyntaxAnalyser.printError("\n  Unexpected Token: " + t.toString(), line);
        }
    }
}