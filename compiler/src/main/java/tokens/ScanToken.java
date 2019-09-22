package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class ScanToken(){
    private final Lexeme value;

    public ScanToken(){
        super(Tag.SCAN);
        this.value = new Lexeme('scan');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}