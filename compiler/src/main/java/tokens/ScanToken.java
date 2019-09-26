package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ScanToken extends Token {
    private final Lexeme value;

    public ScanToken() {
        super(Tag.SCAN);
        this.value = new Lexeme("scan");
    }

    public String toString() {
        return this.value.getIdentifier();
    }

    public boolean match(String s) {
        return this.value.match(s);
    }
}