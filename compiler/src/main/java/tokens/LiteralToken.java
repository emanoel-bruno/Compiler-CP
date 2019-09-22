package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class LiteralToken(){
    private final Lexeme value;

    public LiteralToken(String s){
        super(Tag.LITERAL);
        this.value = new Lexeme(s);
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}