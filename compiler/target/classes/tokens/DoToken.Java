package tokens;

import compiler.Token;
import compiler.Lexeme;

public class DoToken(){
    private final Lexeme value;

    public DoToken(){
        super("do");
        this.value = new Lexeme("do");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}