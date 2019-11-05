package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class LiteralToken extends Token {
    private final Lexeme value;

    public LiteralToken(String s) {
        super(Tag.LITERAL);
        this.value = new Lexeme(s);
    }

    public String getLexeme() {
        return "\"" + this.value.getIdentifier() + "\"";
    }

    public String toString() {
        return "\"" + this.value.getIdentifier() + "\"";

    }

}