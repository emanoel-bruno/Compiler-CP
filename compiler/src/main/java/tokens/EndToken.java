package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class EndToken(){
    private final Lexeme value;

    public EndToken(){
        super(Tag.END);
        this.value = new Lexeme('end');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}