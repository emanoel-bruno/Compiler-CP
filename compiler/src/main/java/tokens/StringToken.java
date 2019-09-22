package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class StringToken(){
    private final Lexeme value;

    public StringToken(){
        super(Tag.String);
        this.value = new Lexeme('string');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}