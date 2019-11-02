package exceptions;

import exceptions.SyntaxException;

public class UnexpectedTokenException extends SyntaxException {
    private static final long serialVersionUID = 1L;

    public UnexpectedTokenException(String token, int line) {
        super("\n  Unexpected Token: " + token, line);
    }
}