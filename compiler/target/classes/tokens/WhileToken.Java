package tokens;

import compiler.Token;
import compiler.Lexeme;

public class WhileToken(){
    private final Lexeme value;

    public WhileToken(){
        this.value = new Lexeme("while");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}