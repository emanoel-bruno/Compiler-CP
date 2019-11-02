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
import procedures.IfStmtAsteriskProcedure;

public class IfStmtProcedure extends Procedure {
    public IfStmtProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = this.lexical.getLine();
        switch (t.getTag()) {
        case Tag.IF:
            t = this.lexical.findNextToken();
            new ConditionProcedure(this.lexical).check(t);
            this.consume(Tag.THEN, false); // Expression Procedure already moved one step
            t = this.lexical.findNextToken();            
            new StmtListProcedure(this.lexical).check(t);
            t = this.lexical.getCurrentToken(); // StmtList already moved one step forward
            new IfStmtAsteriskProcedure(this.lexical).check(t);
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}