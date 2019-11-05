package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class WhileToken extends Token {
    private final Lexeme value;

    public WhileToken() {
        super(Tag.WHILE);
        this.value = new Lexeme("while");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}