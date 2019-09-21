package tokens;

import compiler.Token;
import compiler.Lexeme;

public class NotToken(){
    private final Lexeme value;

    public NotToken(){
        this.value = new Lexeme("not");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}