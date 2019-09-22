package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class WhileToken(){
    private final Lexeme value;

    public WhileToken(){
        super(Tag.WHILE);
        this.value = new Lexeme('while');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}