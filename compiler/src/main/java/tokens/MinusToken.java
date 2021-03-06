package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class MinusToken extends Token {
    private final Lexeme value;

    public MinusToken() {
        super(Tag.MINUS);
        this.value = new Lexeme("-");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}