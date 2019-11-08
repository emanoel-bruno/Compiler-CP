package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class ProgramProcedure extends Procedure {

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
        this.consume(Tag.START, false);
        while ((t = SyntaxAnalyser.nextToken()).getTag() == Tag.NEW_LINE)
            ;
        if (t.getTag() == Tag.INT || t.getTag() == Tag.FLOAT || t.getTag() == Tag.STRING)
            this.invoke(Procedure.DECLLIST_PROCEDURE, false);
        this.invoke(Procedure.STMTLIST_PROCEDURE, false); // DeclListProcedure already moved one step forward
        Tag.printTag(SyntaxAnalyser.currentToken().getTag());

        this.consume(Tag.EXIT, false); // StmtListProcedure already moved one step forward
        this.consume(Tag.EOF, true);
    }
}