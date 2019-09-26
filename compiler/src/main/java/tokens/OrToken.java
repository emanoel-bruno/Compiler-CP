package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class OrToken extends Token{
    private final Lexeme value;

    public OrToken(){
        super(Tag.OR);
        this.value = new Lexeme("or");
    }

    public String toString(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}