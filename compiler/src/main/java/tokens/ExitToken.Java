package tokens;

import compiler.Token;
import compiler.Lexeme;

public class ExitToken(){
    private final Lexeme value;

    public ExitToken(){
        this.value = new Lexeme("exit");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}