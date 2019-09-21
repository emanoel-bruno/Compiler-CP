package tokens;

import compiler.Token;
import compiler.Lexeme;

public class IntToken(){
    private final Lexeme value;

    public IntToken(){
        super("int");
        this.value = new Lexeme("int");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}