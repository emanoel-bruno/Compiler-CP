package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class BiggerEqualToken extends Token{
    private final Lexeme value;

    public BiggerEqualToken(){
        super(Tag.BIGGER_EQUAL);
        this.value = new Lexeme(">=");
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}