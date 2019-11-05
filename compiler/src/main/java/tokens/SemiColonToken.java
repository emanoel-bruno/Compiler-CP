package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class SemiColonToken extends Token {
    private final Lexeme value;

    public SemiColonToken() {
        super(Tag.SEMICOLON);
        this.value = new Lexeme(";");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}