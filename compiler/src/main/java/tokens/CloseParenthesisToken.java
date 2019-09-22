package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class CloseParenthesisToken(){
    private final Lexeme value;

    public CloseParenthesisToken(){
        super(Tag.CLOSE_PARENTHESIS);
        this.value = new Lexeme(')');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}