package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class BiggerToken extends Token {
    private final Lexeme value;

    public BiggerToken() {
        super(Tag.BIGGER);
        this.value = new Lexeme(">");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}