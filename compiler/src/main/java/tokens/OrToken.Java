package tokens;

import compiler.Token;
import compiler.Lexeme;

public class OrToken(){
    private final Lexeme value;

    public OrToken(){
        super("or");
        this.value = new Lexeme("or");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}