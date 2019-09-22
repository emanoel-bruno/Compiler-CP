package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class PrintToken extends Token{
    private final Lexeme value;

    public PrintToken(){
        super(Tag.PRINT);
        this.value = new Lexeme("print");
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}