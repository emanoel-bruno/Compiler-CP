package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class BiggerEqualToken extends Token {
    private final Lexeme value;

    public BiggerEqualToken() {
        super(Tag.BIGGER_EQUAL);
        this.value = new Lexeme(">=");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}