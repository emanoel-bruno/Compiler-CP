package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class IfToken extends Token {
    private final Lexeme value;

    public IfToken() {
        super(Tag.IF);
        this.value = new Lexeme("if");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}