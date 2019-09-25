package exception;

import exception.LexicalException;

public class UnknownCharacterException extends LexicalException {
    private static final long serialVersionUID = 1L;

    public UnknownCharacterException(char c, int line) {
        super("\n\t-UnknownCharacter: " + c, line);
    }
}