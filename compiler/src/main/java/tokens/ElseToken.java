package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ElseToken(){
    private final Lexeme value;

    public ElseToken(){
        super(Tag.ELSE);
        this.value = new Lexeme('else');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}