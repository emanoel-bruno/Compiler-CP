package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class IdentifierToken extends Token {
    private final Lexeme value;

    public IdentifierToken(String id) {
        super(Tag.IDENTIFIER);
        this.value = new Lexeme(id);
    }

    public String toString() {
        return this.value.getIdentifier();
    }

    public boolean match(String s) {
        return this.value.match(s);
    }
}