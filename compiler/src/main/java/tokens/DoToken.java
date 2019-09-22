package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class DoToken extends Token{
    private final Lexeme value;

    public DoToken(){
        super(Tag.DO);
        this.value = new Lexeme("do");
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}