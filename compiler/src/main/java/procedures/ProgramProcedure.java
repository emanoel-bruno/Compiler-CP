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
import procedures.DeclListProcedure;
import procedures.StmtListProcedure;

public class ProgramProcedure extends Procedure {
    public ProgramProcedure(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = this.lexical.getLine();
        switch (t.getTag()) {
        case Tag.START:
            t = this.lexical.findNextToken();
            if (t.getTag() == Tag.INT || t.getTag() == Tag.FLOAT || t.getTag() == Tag.STRING) {
                new DeclListProcedure(lexical).check(t);
                t = this.lexical.getCurrentToken(); // DeclListProcedure already moved one step forward
            }
            new StmtListProcedure(lexical).check(t);
            this.consume(Tag.EXIT, false); // StmtListProcedure already moved one step forward
            this.consume(Tag.EOF, true);
            break;
        default:
            PanicMode.nextToken(this,t.getTag(), this.lexical);
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}