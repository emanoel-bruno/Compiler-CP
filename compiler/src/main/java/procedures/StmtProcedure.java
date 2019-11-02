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
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.PRINT:
            new WriteStmtProcedure().check(t);
            consume(Tag.SEMICOLON, true);
            break;
        case Tag.SCAN:
            new ReadStmtProcedure().check(t);
            consume(Tag.SEMICOLON, true);
            break;
        case Tag.DO:
            new WhileStmtProcedure().check(t);
            break;
        case Tag.IF:
            new IfStmtProcedure().check(t);
        case Tag.IDENTIFIER:
            new AssignStmtProcedure().check(t);
            consume(Tag.SEMICOLON, false); // simple-expr already moved one step
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}