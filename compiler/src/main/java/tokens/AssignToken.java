package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class AssignToken extends Token{
    private final Lexeme value;

    public AssignToken(){
        super(Tag.ASSIGN);
        this.value = new Lexeme("=");
    }

    public String toString(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}