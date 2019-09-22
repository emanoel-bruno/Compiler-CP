package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class DoubleArrowToken extends Token{
    private final Lexeme value;

    public DoubleArrowToken(){
        super(Tag.DOUBLE_ARROW);
        this.value = new Lexeme("<>");
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}