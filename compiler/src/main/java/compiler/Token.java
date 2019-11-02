package compiler;

public class Token {
    private final int tag;

    public Token(int tag) {
        this.tag = tag;
    }

    public int getTag() {
        return this.tag;
    }
}
