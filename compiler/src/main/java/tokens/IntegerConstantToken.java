package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class IntegerConstantToken(){
    private final int value;

    public IntegerConstantToken(int value){
        super(Tag.INTEGER_CONSTANT);
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}