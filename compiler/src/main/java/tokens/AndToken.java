package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class AndToken(){
    private final Lexeme value;

    public AndToken(){
        super(Tag.AND);
        this.value = new Lexeme('and');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}