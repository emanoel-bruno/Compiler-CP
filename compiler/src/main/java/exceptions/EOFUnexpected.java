package exceptions;

import exceptions.SyntaxException;

public class EOFUnexpected extends SyntaxException {
    private static final long serialVersionUID = 1L;

    public EOFUnexpected(String token, int line) {
        super("\n  Unexpected End of File: " + token, line);
    }
}