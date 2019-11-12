package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;

public class SimpleExprAsteriskProcedure extends Procedure {

    public SimpleExprAsteriskProcedure() {
        this.tag = Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        switch (t.getTag()) {
        case Tag.PLUS:
            this.consume(Tag.PLUS);
            this.invoke(Procedure.TERM_PROCEDURE);
            this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE); // TermProcedure already moved one step forward
            break;
        case Tag.MINUS:
            this.consume(Tag.MINUS);
            this.invoke(Procedure.TERM_PROCEDURE);
            this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE); // TermProcedure already moved one step forward
            break;
        case Tag.OR:
            this.consume(Tag.OR);
            this.invoke(Procedure.TERM_PROCEDURE);
            this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE); // TermProcedure already moved one step forward
            break;
        }
    }
}