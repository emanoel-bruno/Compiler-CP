package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class CommaToken extends Token {
    private final Lexeme value;

    public CommaToken() {
        super(Tag.COMMA);
        this.value = new Lexeme(",");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}