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
import procedures.DeclListProcedure;
import procedures.StmtListProcedure;

public class ProgramProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.START:
            this.consume(Tag.START, false);
            t = SyntaxAnalyser.nextToken();
            if (t.getTag() == Tag.INT || t.getTag() == Tag.FLOAT || t.getTag() == Tag.STRING) {
                new DeclListProcedure().check(t);
                t = SyntaxAnalyser.currentToken(); // DeclListProcedure already moved one step forward
            }
            new StmtListProcedure().check(t);
            this.consume(Tag.EXIT, false); // StmtListProcedure already moved one step forward
            this.consume(Tag.EOF, true);
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}