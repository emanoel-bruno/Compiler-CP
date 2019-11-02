package compiler;

import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import procedures.ProgramProcedure;

import java.io.IOException;

import compiler.LexicalAnalyser;

public class SyntaxAnalyser {
    private static LexicalAnalyser lexical;

    public SyntaxAnalyser(LexicalAnalyser lexical) {
        SyntaxAnalyser.lexical = lexical;
    }

    public static Token nextToken() throws IOException, LexicalException {
        return SyntaxAnalyser.lexical.findNextToken();
    }

    public static Token currentToken() {
        return SyntaxAnalyser.lexical.getCurrentToken();
    }

    public static int currentLine() {
        return SyntaxAnalyser.lexical.getLine();
    }

    public void scanRules() throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.lexical.findNextToken();
        new ProgramProcedure().check(t);
    }
}