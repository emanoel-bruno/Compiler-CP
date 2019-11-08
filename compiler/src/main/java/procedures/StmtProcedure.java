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
        case Tag.IDENTIFIER:
            this.invoke(Procedure.ASSIGNSTMT_PROCEDURE, false);
            consume(Tag.SEMICOLON, false); // SimpleExprProcedure already moved one step
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}