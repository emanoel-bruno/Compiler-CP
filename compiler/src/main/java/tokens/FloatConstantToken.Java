package tokens;

import compiler.Token;
import compiler.Lexeme;
import compiler.Tag;

public class FloatConstant(){
    private final float value;

    public FloatConstant(float value){
        super(Tag.FLOAT_CONSTANT);
        this.value = value;
    }

    public float getValue(){
        return this.value;
    }
}