package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ExitToken extends Token{
    private final Lexeme value;

    public ExitToken(){
        super(Tag.EXIT);
        this.value = new Lexeme("exit");
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}