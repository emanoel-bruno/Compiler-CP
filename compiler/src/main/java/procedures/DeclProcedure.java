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

public class DeclProcedure extends Procedure {

    public DeclProcedure() {
        this.tag = Procedure.DECL_PROCEDURE;
    }

    @Override
    public void rule() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        int line = SyntaxAnalyser.currentLine();
        switch (t.getTag()) {
        case Tag.INT:
            this.consume(Tag.INT, false);
            this.invoke(Procedure.IDENTLIST_PROCEDURE, true);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            SyntaxAnalyser.nextToken();
            break;
        case Tag.FLOAT:
            this.consume(Tag.FLOAT, false);
            this.invoke(Procedure.IDENTLIST_PROCEDURE, true);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            SyntaxAnalyser.nextToken();
            break;
        case Tag.STRING:
            this.consume(Tag.STRING, false);
            this.invoke(Procedure.IDENTLIST_PROCEDURE, true);
            this.consume(Tag.SEMICOLON, false); // IdentListProcedure move one step forward
            SyntaxAnalyser.nextToken();
            break;
        default:
            PanicMode.nextToken(this, t, new int[] { Tag.INT, Tag.FLOAT, Tag.STRING });
            SyntaxAnalyser.printError("\n  Unexpected Token: " + t.toString(), line);
        }
    }
}