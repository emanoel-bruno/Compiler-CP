package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class StartToken(){
    private final Lexeme value;

    public StartToken(){
        super(Tag.START);
        this.value = new Lexeme('start');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}