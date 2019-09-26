package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class OpenParenthesisToken extends Token{
    private final Lexeme value;

    public OpenParenthesisToken(){
        super(Tag.OPEN_PARENTHESIS);
        this.value = new Lexeme("(");
    }

    public String toString(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}