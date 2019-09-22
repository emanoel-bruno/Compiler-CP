package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class EqualToken(){
    private final Lexeme value;

    public EqualToken(){
        super(Tag.EQUAL);
        this.value = new Lexeme('==');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}