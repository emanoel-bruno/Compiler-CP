package tokens;

import compiler.Token;
import compiler.Lexeme;

public class AndToken(){
    private final Lexeme value;

    public AndToken(){
        super("and");
        this.value = new Lexeme("and");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}