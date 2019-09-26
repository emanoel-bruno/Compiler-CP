package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class FloatToken extends Token{
    private final Lexeme value;

    public FloatToken(){
        super(Tag.FLOAT);        
        this.value = new Lexeme("float");
    }

    public String toString(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}