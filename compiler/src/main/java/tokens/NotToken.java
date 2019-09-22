package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class NotToken(){
    private final Lexeme value;

    public NotToken(){
        super(Tag.NOT);
        this.value = new Lexeme('not');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}