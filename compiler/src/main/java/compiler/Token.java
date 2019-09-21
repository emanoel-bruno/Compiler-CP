package compiler;

public class Token{
    private final String tag;

    public Token(String tag){
        this.tag = tag;
    }

    public String getTag(){
        return this.tag;
    }

    public String toString(){
        return this.tag;
    }
}
