package compiler;

import java.io.IOException;

import compiler.LexicalAnalyser;
import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;

public abstract class Procedure {
    protected LexicalAnalyser lexical;

    public boolean consume(int tag, boolean move) throws UnexpectedTokenException, IOException, LexicalException {
        Token t = (move) ? SyntaxAnalyser.nextToken() : SyntaxAnalyser.currentToken();
        int line = SyntaxAnalyser.currentLine();
        if (t.getTag() != tag) {
            PanicMode.nextToken(this, t.getTag());
            throw new UnexpectedTokenException(t.toString(), line);
        }
        return true;
    }

    public abstract void check(Token t) throws IOException, LexicalException, SyntaxException;
}