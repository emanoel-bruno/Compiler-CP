package procedures;

import java.io.IOException;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;
import compiler.SyntaxAnalyser;
import compiler.Tag;

public class ConditionProcedure extends Procedure {

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
        this.invoke(Procedure.EXPRESSION_PROCEDURE, false);
    }
}