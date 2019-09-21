package tokens;

import compiler.Token;
import compiler.Lexeme;

public class ThenToken(){
    private final Lexeme value;

    public ThenToken(){
        super("then");
        this.value = new Lexeme("then");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}