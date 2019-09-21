package tokens;

import compiler.Token;
import compiler.Lexeme;

public class EndToken(){
    private final Lexeme value;

    public EndToken(){
        this.value = new Lexeme("end");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}