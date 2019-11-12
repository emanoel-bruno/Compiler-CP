package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class NewLineToken extends Token {
    private final Lexeme value;

    public NewLineToken() {
        super(Tag.NEW_LINE);
        this.value = new Lexeme("NEW_LINE");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}