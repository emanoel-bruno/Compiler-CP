package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class PlusToken extends Token {
    private final Lexeme value;

    public PlusToken() {
        super(Tag.PLUS);
        this.value = new Lexeme("+");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}