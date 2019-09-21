package tokens;

import compiler.Token;
import compiler.Lexeme;

public class ScanToken(){
    private final Lexeme value;

    public ScanToken(){
        super("scan");
        this.value = new Lexeme("scan");
    }

    public String function getValue(){
        return this.value.toString();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}