package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class DoToken extends Token {
    private final Lexeme value;

    public DoToken() {
        super(Tag.DO);
        this.value = new Lexeme("do");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}