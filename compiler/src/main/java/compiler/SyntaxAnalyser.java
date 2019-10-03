package compiler;

import tokens.*;
import compiler.Token;
import exception.LexicalException;

import java.io.IOException;

import compiler.LexicalAnalyser;

public class SyntaxAnalyser {
    private LexicalAnalyser lexical;

    public SyntaxAnalyser(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    public void scanRules() throws IOException, LexicalException {
        Token t;
        while (true) {
            t = this.lexical.findNextToken();
            if (t instanceof EOFToken)
                break;

            System.out.println(t.toString());
            if (t instanceof IdentifierToken)
                this.lexical.insertToken((IdentifierToken) t);
        }
    }
}