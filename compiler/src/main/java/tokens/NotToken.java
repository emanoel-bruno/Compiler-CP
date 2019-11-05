package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class NotToken extends Token {
    private final Lexeme value;

    public NotToken() {
        super(Tag.NOT);
        this.value = new Lexeme("not");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}