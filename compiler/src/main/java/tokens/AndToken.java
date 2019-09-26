package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class AndToken extends Token {
    private final Lexeme value;

    public AndToken() {
        super(Tag.AND);
        this.value = new Lexeme("and");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

    public boolean match(String s) {
        return this.value.match(s);
    }
}