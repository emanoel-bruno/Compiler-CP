package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class StringToken extends Token {
    private final Lexeme value;

    public StringToken() {
        super(Tag.STRING);
        this.value = new Lexeme("string");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

    public boolean match(String s) {
        return this.value.match(s);
    }
}