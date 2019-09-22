package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class IfToken extends Token{
    private final Lexeme value;

    public IfToken(){
        super(Tag.IF);
        this.value = new Lexeme("if");
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}