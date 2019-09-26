package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class CaractereToken extends Token{
    private final Lexeme value;

    public CaractereToken(String c){
        super(Tag.CARACTERE);
        this.value = new Lexeme(c);
    }

    public String toString(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}