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

    private String stringToken(Token t) {
        String s = "Class not Found: " + t.getTag();
        if (t instanceof AndToken) {
            s = ((AndToken) t).toString();
        } else if (t instanceof AssignToken) {
            s = ((AssignToken) t).toString();
        } else if (t instanceof BiggerEqualToken) {
            s = ((BiggerEqualToken) t).toString();
        } else if (t instanceof BiggerToken) {
            s = ((BiggerToken) t).toString();
        } else if (t instanceof CaractereToken) {
            s = ((CaractereToken) t).toString();
        } else if (t instanceof CloseParenthesisToken) {
            s = ((CloseParenthesisToken) t).toString();
        } else if (t instanceof CommaToken) {
            s = ((CommaToken) t).toString();
        } else if (t instanceof DividerToken) {
            s = ((DividerToken) t).toString();
        } else if (t instanceof DoToken) {
            s = ((DoToken) t).toString();
        } else if (t instanceof DotToken) {
            s = ((DotToken) t).toString();
        } else if (t instanceof DoubleArrowToken) {
            s = ((DoubleArrowToken) t).toString();
        } else if (t instanceof ElseToken) {
            s = ((ElseToken) t).toString();
        } else if (t instanceof EndToken) {
            s = ((EndToken) t).toString();
        } else if (t instanceof EqualToken) {
            s = ((EqualToken) t).toString();
        } else if (t instanceof ExitToken) {
            s = ((ExitToken) t).toString();
        } else if (t instanceof FloatConstantToken) {
            s = "" + ((FloatConstantToken) t).toString();
        } else if (t instanceof FloatToken) {
            s = ((FloatToken) t).toString();
        } else if (t instanceof IdentifierToken) {
            s = ((IdentifierToken) t).toString();
        } else if (t instanceof IfToken) {
            s = ((IfToken) t).toString();
        } else if (t instanceof IntegerConstantToken) {
            s = "" + ((IntegerConstantToken) t).toString();
        } else if (t instanceof IntToken) {
            s = ((IntToken) t).toString();
        } else if (t instanceof LiteralToken) {
            s = ((LiteralToken) t).toString();
        } else if (t instanceof MinusToken) {
            s = ((MinusToken) t).toString();
        } else if (t instanceof NotToken) {
            s = ((NotToken) t).toString();
        } else if (t instanceof OpenParenthesisToken) {
            s = ((OpenParenthesisToken) t).toString();
        } else if (t instanceof OrToken) {
            s = ((OrToken) t).toString();
        } else if (t instanceof PlusToken) {
            s = ((PlusToken) t).toString();
        } else if (t instanceof PrintToken) {
            s = ((PrintToken) t).toString();
        } else if (t instanceof ScanToken) {
            s = ((ScanToken) t).toString();
        } else if (t instanceof SemiColonToken) {
            s = ((SemiColonToken) t).toString();
        } else if (t instanceof SmallerEqualToken) {
            s = ((SmallerEqualToken) t).toString();
        } else if (t instanceof SmallerToken) {
            s = ((SmallerToken) t).toString();
        } else if (t instanceof StartToken) {
            s = ((StartToken) t).toString();
        } else if (t instanceof StringToken) {
            s = ((StringToken) t).toString();
        } else if (t instanceof ThenToken) {
            s = ((ThenToken) t).toString();
        } else if (t instanceof TimesToken) {
            s = ((TimesToken) t).toString();
        } else if (t instanceof WhileToken) {
            s = ((WhileToken) t).toString();
        }

        return s;
    }

    // public boolean validadeNextToken(String className){
    // if (t instanceof AndToken) {
    // return ();
    // } else if (t instanceof AssignToken) {
    // return ();
    // } else if (t instanceof BiggerEqualToken) {
    // return ();
    // } else if (t instanceof BiggerToken) {
    // return ();
    // } else if (t instanceof CaractereToken) {
    // return ();
    // } else if (t instanceof CloseParenthesisToken) {
    // return ();
    // } else if (t instanceof CommaToken) {
    // return ();
    // } else if (t instanceof DividerToken) {
    // return ();
    // } else if (t instanceof DoToken) {
    // return ();
    // } else if (t instanceof DotToken) {
    // return ();
    // } else if (t instanceof DoubleArrowToken) {
    // return ();
    // } else if (t instanceof ElseToken) {
    // return ();
    // } else if (t instanceof EndToken) {
    // return ();
    // } else if (t instanceof EqualToken) {
    // return ();
    // } else if (t instanceof ExitToken) {
    // return ();
    // } else if (t instanceof FloatConstantToken) {
    // return ();
    // } else if (t instanceof FloatToken) {
    // return ();
    // } else if (t instanceof IdentifierToken) {
    // return ();
    // } else if (t instanceof IfToken) {
    // return ();
    // } else if (t instanceof IntegerConstantToken) {
    // return ();
    // } else if (t instanceof IntToken) {
    // return ();
    // } else if (t instanceof LiteralToken) {
    // return ();
    // } else if (t instanceof MinusToken) {
    // return ();
    // } else if (t instanceof NotToken) {
    // return ();
    // } else if (t instanceof OpenParenthesisToken) {
    // return ();
    // } else if (t instanceof OrToken) {
    // return ();
    // } else if (t instanceof PlusToken) {
    // return ();
    // } else if (t instanceof PrintToken) {
    // return ();
    // } else if (t instanceof ScanToken) {
    // return ();
    // } else if (t instanceof SemiColonToken) {
    // return ();
    // } else if (t instanceof SmallerEqualToken) {
    // return ();
    // } else if (t instanceof SmallerToken) {
    // return ();
    // } else if (t instanceof StartToken) {
    // return ();
    // } else if (t instanceof StringToken) {
    // return ();
    // } else if (t instanceof ThenToken) {
    // return ();
    // } else if (t instanceof TimesToken) {
    // return ();
    // } else if (t instanceof WhileToken) {
    // return ();
    // }
    // }

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