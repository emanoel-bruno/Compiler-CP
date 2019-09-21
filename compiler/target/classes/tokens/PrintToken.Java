package tokens;

import compiler.Token;
import compiler.Lexeme;

public class PrintToken(){
    private final Lexeme value;

    public PrintToken(){
        this.value = new Lexeme("print");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}