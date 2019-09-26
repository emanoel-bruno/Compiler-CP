package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class EOFToken extends Token {
    private final Lexeme value;

    public EOFToken() {
        super(Tag.EOF);
        this.value = new Lexeme("EOF");
    }

    public String toString(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}