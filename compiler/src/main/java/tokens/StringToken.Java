package tokens;

import compiler.Token;
import compiler.Lexeme;

public class StringToken(){
    private final Lexeme value;

    public StringToken(){
        this.value = new Lexeme("string");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}