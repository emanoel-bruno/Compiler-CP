package procedures;

import java.io.IOException;

import compiler.Token;
import compiler.Tag;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.Procedure;

public class AssignStmtProcedure  extends Procedure {
      
    public AssignStmtProcedure(){
        this.tag = Procedure.ASSIGNSTMT_PROCEDURE;
    }
    
    @Override
    public void rule(Token t) throws IOException, LexicalException, SyntaxException {
        this.consume(Tag.IDENTIFIER, false);
        this.consume(Tag.ASSIGN, true);
        this.invoke(Procedure.SIMPLEEXPR_PROCEDURE, true);
    }
}