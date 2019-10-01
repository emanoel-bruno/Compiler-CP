package compiler;

import tokens.*;
import compiler.SymbolTable;

import exception.CharacterInvalidException;
import exception.LexicalException;
import exception.UnknownCharacterException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.common.base.CharMatcher;

public class LexicalAnalyser {
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private char currentChar;
    private int currentLine;
    private SymbolTable symbolTable;

    /**
     * Create a new LexicalAnalyser and open a file
     * 
     * @param path Path for the file to be open
     * @throws FileNotFoundException
     */
    public LexicalAnalyser(String path) throws FileNotFoundException {
        this.file = new File(path);
        this.fileReader = new FileReader(this.file);
        this.bufferedReader = new BufferedReader(this.fileReader);
        this.symbolTable = new SymbolTable();
        this.currentLine = 0;
    }

    /**
     * @return A boolean that inform if last character read is an irrelevant token
     */
    public boolean isEmptySpace() {
        return (this.currentChar == ' ' || this.currentChar == '\t' || this.currentChar == '\r'
                || this.currentChar == '\b' || this.currentChar == '\n' || (int) this.currentChar == 0);
    };

    /**
     * Read a character of the opened file and store at currentChar
     * 
     * @return A boolean that inform if os end of file or not
     * @throws IOException
     */
    public boolean nextChar() throws IOException {
        if ((int) (this.currentChar = (char) this.bufferedReader.read()) == -1)
            return false;
        return true;
    }

    /**
     * Read a character of the opened file, store at currentChar, and verify if he
     * match the condition passed like parameter
     * 
     * @param condition Condition too be verified, can be digit, letter, empty,
     *                  character
     * @return A boolean that inform if os end of file or not
     * @throws IOException
     */
    public boolean nextChar(String condition) throws IOException {
        if ((int) (this.currentChar = (char) this.bufferedReader.read()) == -1)
            return false;

        if (condition.intern() == "digit") {
            return Character.isDigit(this.currentChar);
        } else if (condition.intern() == "letter") {
            return Character.isLetter(this.currentChar);
        } else if (condition.intern() == "character") {
            System.out.println((int) this.currentChar);
            return (CharMatcher.ascii().matches(this.currentChar) && String.valueOf(this.currentChar) != "\""
                    && (int) this.currentChar != 8220 && (int) this.currentChar != 8221
                    && String.valueOf(this.currentChar) != "\n" && (int) this.currentChar != 10);
        } else if (condition.intern() == "empty") {
            if (this.currentChar == '\n')
                this.currentLine++;
            return (isEmptySpace());
        } else {
            return (String.valueOf(this.currentChar).intern() == condition.intern());
        }
    }

    /**
     * Find the next token in the file
     * 
     * @return Return the read token
     * @throws IOException
     * @throws LexicalException
     */
    public Token findNextToken() throws IOException, LexicalException {
        if (isEmptySpace())
            while (this.nextChar("empty")) {
            }
        if (Character.isDigit(this.currentChar)) {
            StringBuilder number = new StringBuilder();
            number.append(this.currentChar);
            while (this.nextChar("digit"))
                number.append(this.currentChar);
            if (String.valueOf(this.currentChar).intern() == ".") {
                number.append(this.currentChar);
                while (this.nextChar("digit"))
                    number.append(this.currentChar);
                return new FloatConstantToken(Float.valueOf(number.toString()));
            } else {
                return new IntegerConstantToken(Integer.valueOf(number.toString()));
            }
        }

        if (Character.isLetter(this.currentChar)) {
            StringBuilder lexeme = new StringBuilder();
            lexeme.append(this.currentChar);
            while (this.nextChar("letter"))
                lexeme.append(this.currentChar);
            if (Character.isDigit(this.currentChar)) {
                while (this.nextChar()
                        && (Character.isDigit(this.currentChar) || Character.isLetter(this.currentChar))) {
                    lexeme.append(this.currentChar);
                }
                return new IdentifierToken(lexeme.toString());
            } else {
                switch (lexeme.toString().intern()) {
                case "start":
                    return new StartToken();
                case "exit":
                    return new ExitToken();
                case "int":
                    return new IntToken();
                case "float":
                    return new FloatToken();
                case "string":
                    return new StringToken();
                case "if":
                    return new IfToken();
                case "then":
                    return new ThenToken();
                case "end":
                    return new EndToken();
                case "else":
                    return new ElseToken();
                case "do":
                    return new DoToken();
                case "while":
                    return new WhileToken();
                case "scan":
                    return new ScanToken();
                case "print":
                    return new PrintToken();
                case "not":
                    return new NotToken();
                case "or":
                    return new OrToken();
                case "and":
                    return new AndToken();
                default:
                    return new IdentifierToken(lexeme.toString());
                }
            }
        }

        if ((int) this.currentChar == 8221) {
            this.nextChar();
            throw new CharacterInvalidException(this.currentChar,
                    "[Close Quotation Mark(Unicode)] without open quotation before", this.currentLine);
        }

        if ((int) this.currentChar == 8220 || String.valueOf(this.currentChar).intern() == "\"") {
            StringBuilder literal = new StringBuilder();
            while (this.nextChar("character"))
                literal.append(this.currentChar);
            if ((int) this.currentChar == 8221 || String.valueOf(this.currentChar) == "\"") {
                this.nextChar();
                return new LiteralToken(literal.toString());
            } else if ((int) this.currentChar == 8220) {
                this.nextChar();
                throw new CharacterInvalidException(this.currentChar,
                        "[Open Quotation Mark(Unicode)] already opened quotation", this.currentLine);
            } else if (String.valueOf(this.currentChar) == "\n") {
                throw new CharacterInvalidException(this.currentChar, "[New Line] can't be used within a literal",
                        this.currentLine);
            } else {
                throw new CharacterInvalidException(this.currentChar, " can't be used within a literal",
                        this.currentLine);
            }
        }

        if (CharMatcher.ascii().matches(this.currentChar)) {
            switch (String.valueOf(this.currentChar).intern()) {
            case "=":
                if (this.nextChar("="))
                    return new EqualToken();
                else
                    return new AssignToken();
            case ">":
                if (this.nextChar("="))
                    return new BiggerEqualToken();
                else
                    return new BiggerToken();
            case "<":
                if (this.nextChar("="))
                    return new SmallerEqualToken();
                else if (String.valueOf(this.currentChar).intern() == ">")
                    return new DoubleArrowToken();
                else
                    return new SmallerToken();
            case "+":
                this.nextChar();
                return new PlusToken();
            case "*":
                this.nextChar();
                return new TimesToken();
            case "/":
                this.nextChar();
                return new DividerToken();
            case "-":
                this.nextChar();
                return new MinusToken();
            case ";":
                this.nextChar();
                return new SemiColonToken();
            case ",":
                this.nextChar();
                return new CommaToken();
            case "(":
                this.nextChar();
                return new OpenParenthesisToken();
            case ")":
                this.nextChar();
                return new CloseParenthesisToken();
            case ".":
                this.nextChar();
                return new DotToken();
            default:
                throw new UnknownCharacterException(this.currentChar, this.currentLine);
            }
        }

        if ((int) this.currentChar == 65535) {
            return new EOFToken();
        }

        throw new UnknownCharacterException(this.currentChar, this.currentLine);
    }

    /**
     * Insert a identifier on the SymbolTable
     * 
     * @param t The token to be inserted
     * @return |False, when it was already on the table
     * @throws IOException
     */
    public boolean insertToken(IdentifierToken t) {
        return this.symbolTable.insertToken(t);
    }
}