package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class QuotationMarkToken(){
    private final Lexeme value;

    public QuotationMarkToken(){
        super(Tag.QUOTATION_MARK);
        this.value = new Lexeme('"');
    }

    public String getValue(){
        return this.value.getIdentifier();
    }

    public boolean match(String s){
        return this.value.match(s);
    }
}