package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class CaractereToken(){
    private final Lexeme value;

    public CaractereToken(String c){
        super(Tag.CARACTERE);
        this.value = new Lexeme(c);
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}