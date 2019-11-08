package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class SimpleExprAsteriskProcedure extends Procedure {

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