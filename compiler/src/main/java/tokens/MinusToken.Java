package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class MinusToken(){
    private final Lexeme value;

    public MinusToken(){
        super(Tag.MINUS);
        this.value = new Lexeme('-');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}