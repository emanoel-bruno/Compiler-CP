package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class EqualToken extends Token {
    private final Lexeme value;

    public EqualToken() {
        super(Tag.EQUAL);
        this.value = new Lexeme("==");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}