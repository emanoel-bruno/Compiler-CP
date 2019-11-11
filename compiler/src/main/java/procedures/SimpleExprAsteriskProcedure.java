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
            this.consume(Tag.PLUS, false);
            this.invoke(Procedure.TERM_PROCEDURE, true);
            this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE, false); // TermProcedure already moved one step forward
            break;
        case Tag.MINUS:
            this.consume(Tag.MINUS, false);
            this.invoke(Procedure.TERM_PROCEDURE, true);
            this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE, false); // TermProcedure already moved one step forward
            break;
        case Tag.OR:
            this.consume(Tag.OR, false);
            this.invoke(Procedure.TERM_PROCEDURE, true);
            this.invoke(Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE, false); // TermProcedure already moved one step forward
            break;
        }
    }
}