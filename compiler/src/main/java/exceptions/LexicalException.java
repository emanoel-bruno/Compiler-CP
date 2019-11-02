package exceptions;

public class LexicalException extends Exception {
    private static final long serialVersionUID = 1L;

    public LexicalException(String message, int line) {
        super("Lexical Exception: " + message + "| line: " + line);
    }
}