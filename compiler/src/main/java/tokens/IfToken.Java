package tokens;

import compiler.Token;
import compiler.Lexeme;

public class IfToken(){
    private final Lexeme value;

    public IfToken(){
        this.value = new Lexeme("if");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}