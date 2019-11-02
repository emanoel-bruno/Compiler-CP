package compiler;

import tokens.*;
import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import procedures.ProgramProcedure;

import java.io.IOException;

import compiler.LexicalAnalyser;

public class SyntaxAnalyser {
    private LexicalAnalyser lexical;

    public SyntaxAnalyser(LexicalAnalyser lexical) {
        this.lexical = lexical;
    }

    public void scanRules() throws IOException, LexicalException, SyntaxException {
        Token t = this.lexical.findNextToken();
        new ProgramProcedure(this.lexical).check(t);
    }
}