package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class ProgramProcedure extends Procedure {

    public ProgramProcedure() {
        this.tag = Procedure.PROGRAM_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        this.consume(Tag.START, false);
        this.invoke(Procedure.DECLLIST_PROCEDURE, true);
        this.invoke(Procedure.STMTLIST_PROCEDURE, false); // DeclListAsteriskProcedure already moved one step forward
        this.consume(Tag.EXIT, false); // StmtListProcedure already moved one step forward
        this.consume(Tag.EOF, true);
    }
}