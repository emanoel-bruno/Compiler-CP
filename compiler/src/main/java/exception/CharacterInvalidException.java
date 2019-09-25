package exception;

import exception.LexicalException;

public class CharacterInvalidException extends LexicalException {
    private static final long serialVersionUID = 1L;

    public CharacterInvalidException(char c, String message, int line) {
        super("\n\t-Character Invalid: " + c + message, line);
    }
}