package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ThenToken extends Token {
    private final Lexeme value;

    public ThenToken() {
        super(Tag.THEN);
        this.value = new Lexeme("then");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}