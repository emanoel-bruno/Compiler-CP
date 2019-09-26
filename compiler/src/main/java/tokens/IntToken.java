package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class IntToken extends Token {
    private final Lexeme value;

    public IntToken() {
        super(Tag.INT);
        this.value = new Lexeme("int");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

    public boolean match(String s) {
        return this.value.match(s);
    }
}