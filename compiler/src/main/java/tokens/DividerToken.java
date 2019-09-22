package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class DividerToken(){
    private final Lexeme value;

    public DividerToken(){
        super(Tag.DIVIDER);
        this.value = new Lexeme('/');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}