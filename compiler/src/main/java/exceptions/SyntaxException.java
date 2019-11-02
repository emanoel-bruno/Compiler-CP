package exceptions;

public class SyntaxException extends Exception {
    private static final long serialVersionUID = 1L;

    public SyntaxException(String message, int line) {
        super("Syntax Exception: " + message + "| line: " + line);
    }
}