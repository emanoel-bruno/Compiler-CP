package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class SmallerEqualToken extends Token {
    private final Lexeme value;

    public SmallerEqualToken() {
        super(Tag.SMALLER_EQUAL);
        this.value = new Lexeme("<=");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}