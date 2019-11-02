package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.LexicalAnalyser;
import compiler.PanicMode;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import compiler.Procedure;
import procedures.IdentListProcedure;

public class StmtProcedure extends Procedure {
    public StmtProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = this.lexical.getLine();
        switch (t.getTag()) {
        case Tag.PRINT:
            new WriteStmtProcedure(this.lexical).check(t);          
            consume(Tag.SEMICOLON, true);
            break; 
        case Tag.SCAN:
            new ReadStmtProcedure(this.lexical).check(t);          
            consume(Tag.SEMICOLON, true);
            break; 
        case Tag.DO:
            new WhileStmtProcedure(this.lexical).check(t);
            break; 
        case Tag.IF:
            new IfStmtProcedure(this.lexical).check(t);
        case Tag.IDENTIFIER:
            new AssignStmtProcedure(this.lexical).check(t);
            consume(Tag.SEMICOLON, false); // simple-expr already moved one step
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}