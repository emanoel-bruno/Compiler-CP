package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ElseToken extends Token {
    private final Lexeme value;

    public ElseToken() {
        super(Tag.ELSE);
        this.value = new Lexeme("else");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}