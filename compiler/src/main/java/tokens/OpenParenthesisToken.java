package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class OpenParenthesisToken(){
    private final Lexeme value;

    public OpenParenthesisToken(){
        super(Tag.OPEN_PARENTHESIS);
        this.value = new Lexeme('(');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}