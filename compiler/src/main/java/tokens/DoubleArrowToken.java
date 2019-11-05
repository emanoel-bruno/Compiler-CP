package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class DoubleArrowToken extends Token {
    private final Lexeme value;

    public DoubleArrowToken() {
        super(Tag.DOUBLE_ARROW);
        this.value = new Lexeme("<>");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}