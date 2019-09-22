package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class SmallerEqualToken(){
    private final Lexeme value;

    public SmallerEqualToken(){
        super(Tag.SMALLER_EQUAL);
        this.value = new Lexeme('<=');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}