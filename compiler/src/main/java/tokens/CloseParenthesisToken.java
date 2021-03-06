package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class CloseParenthesisToken extends Token {
    private final Lexeme value;

    public CloseParenthesisToken() {
        super(Tag.CLOSE_PARENTHESIS);
        this.value = new Lexeme(")");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}