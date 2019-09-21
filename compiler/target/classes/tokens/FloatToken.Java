package tokens;

import compiler.Token;
import compiler.Lexeme;

public class FloatToken(){
    private final Lexeme value;

    public FloatToken(){
        super("float");        
        this.value = new Lexeme("float");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}