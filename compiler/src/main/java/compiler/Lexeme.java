package compiler;

public class Lexeme {
    private final String identifier;

    public Lexeme(String identifier) {
        this.identifier = identifier;
    }

    public boolean match(String identifier) {
        return (this.identifier.intern() == identifier.intern()) ? true : false;
    };

    public String getIdentifier() {
        return this.identifier;
    }
}