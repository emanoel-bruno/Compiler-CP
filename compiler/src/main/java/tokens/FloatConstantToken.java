package tokens;

import compiler.Token;
import compiler.Tag;

public class FloatConstantToken extends Token{
    private final float value;

    public FloatConstantToken(float value){
        super(Tag.FLOAT_CONSTANT);
        this.value = value;
    }

    public float getValue() {
        return this.value;
    }

    public String toString(){
        return String.valueOf(this.value);
    }
}