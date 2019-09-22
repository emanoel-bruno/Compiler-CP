package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class FloatToken(){
    private final Lexeme value;

    public FloatToken(){
        super(Tag.FLOAT);        
        this.value = new Lexeme('float');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}