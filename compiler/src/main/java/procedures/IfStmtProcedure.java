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
import procedures.IfStmtAsteriskProcedure;

public class IfStmtProcedure extends Procedure {

    @Override
    public void check(Token t) throws IOException, LexicalException, SyntaxException {
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.IF:
            t = SyntaxAnalyser.nextToken();
            new ConditionProcedure().check(t);
            this.consume(Tag.THEN, false); // Expression Procedure already moved one step
            t = SyntaxAnalyser.nextToken();
            new StmtListProcedure().check(t);
            t = SyntaxAnalyser.currentToken(); // StmtList already moved one step forward
            new IfStmtAsteriskProcedure().check(t);
            break;
        default:
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
    }
}