package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ExitToken extends Token {
    private final Lexeme value;

    public ExitToken() {
        super(Tag.EXIT);
        this.value = new Lexeme("exit");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

}