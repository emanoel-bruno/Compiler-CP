package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class SemiColonToken extends Token{
    private final Lexeme value;

    public SemiColonToken(){
        super(Tag.SEMICOLON);
        this.value = new Lexeme(";");
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}