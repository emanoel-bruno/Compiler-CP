package tokens;

import compiler.Token;
import compiler.Lexeme;

public class ElseToken(){
    private final Lexeme value;

    public ElseToken(){
        this.value = new Lexeme("else");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}