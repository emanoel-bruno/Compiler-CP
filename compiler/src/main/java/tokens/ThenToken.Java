package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ThenToken(){
    private final Lexeme value;

    public ThenToken(){
        super(Tag.THEN);
        this.value = new Lexeme('then');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}