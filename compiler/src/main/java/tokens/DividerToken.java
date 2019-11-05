package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class DividerToken extends Token {
    private final Lexeme value;

    public DividerToken() {
        super(Tag.DIVIDER);
        this.value = new Lexeme("/");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}