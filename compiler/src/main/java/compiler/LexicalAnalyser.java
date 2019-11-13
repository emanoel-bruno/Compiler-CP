package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.common.base.CharMatcher;

import exceptions.CharacterInvalidException;
import exceptions.LexicalException;
import exceptions.UnknownCharacterException;
import tokens.AndToken;
import tokens.AssignToken;
import tokens.BiggerEqualToken;
import tokens.BiggerToken;
import tokens.CaractereToken;
import tokens.CloseParenthesisToken;
import tokens.CommaToken;
import tokens.DividerToken;
import tokens.DoToken;
import tokens.DotToken;
import tokens.DoubleArrowToken;
import tokens.EOFToken;
import tokens.ElseToken;
import tokens.EndToken;
import tokens.EqualToken;
import tokens.ExitToken;
import tokens.FloatConstantToken;
import tokens.FloatToken;
import tokens.IdentifierToken;
import tokens.IfToken;
import tokens.IntToken;
import tokens.IntegerConstantToken;
import tokens.LiteralToken;
import tokens.MinusToken;
import tokens.NewLineToken;
import tokens.NotToken;
import tokens.OpenParenthesisToken;
import tokens.OrToken;
import tokens.PlusToken;
import tokens.PrintToken;
import tokens.ScanToken;
import tokens.SemiColonToken;
import tokens.SmallerEqualToken;
import tokens.SmallerToken;
import tokens.StartToken;
import tokens.StringToken;
import tokens.ThenToken;
import tokens.TimesToken;
import tokens.WhileToken;

public class LexicalAnalyser {
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private char currentChar;
    private int currentLine;
    private SymbolTable symbolTable;
    private Token currentToken;

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
        this.currentLine = 1;
    }

    /**
     * @return A boolean that inform if last character read is an irrelevant token
     */
    public boolean isEmptySpace() {
        return (this.currentChar == ' ' || this.currentChar == '\t' || this.currentChar == '\r'
                || this.currentChar == '\b' || (int) this.currentChar == 0);
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
            return (CharMatcher.ascii().matches(this.currentChar) && String.valueOf(this.currentChar) != "\""
                    && (int) this.currentChar != 8220 && (int) this.currentChar != 8221
                    && String.valueOf(this.currentChar) != "\n" && (int) this.currentChar != 10);
        } else if (condition.intern() == "empty") {
            return (isEmptySpace());
        } else {
            return (String.valueOf(this.currentChar).intern() == condition.intern());
        }
    }

    public Token findNextToken() throws IOException, LexicalException {
        Token t = this.nextToken();
        if (t instanceof IdentifierToken)
            this.insertToken((IdentifierToken) t);

        return t;
    }

    /**
     * Find the next token in the file
     * 
     * @return Return the read token
     * @throws IOException
     * @throws LexicalException
     */
    public Token nextToken() throws IOException, LexicalException {
        if (isEmptySpace())
            while (this.nextChar("empty"));
        
        if (this.currentChar == '\n'){
            this.currentLine++;
            this.nextChar();
            return (this.currentToken = new NewLineToken());
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
                return (this.currentToken = new FloatConstantToken(Float.valueOf(number.toString())));
            } else {
                return (this.currentToken = new IntegerConstantToken(Integer.valueOf(number.toString())));
            }
        }

        if (Character.isLetter(this.currentChar)) {
            StringBuilder lexeme = new StringBuilder();
            lexeme.append(this.currentChar);
            while (this.nextChar("letter"))
                lexeme.append(this.currentChar);
            if (Character.isDigit(this.currentChar)) {
                lexeme.append(this.currentChar);
                while (this.nextChar()
                        && (Character.isDigit(this.currentChar) || Character.isLetter(this.currentChar))) {
                    lexeme.append(this.currentChar);
                }
                return (this.currentToken = new IdentifierToken(lexeme.toString()));
            } else {
                switch (lexeme.toString().intern()) {
                case "start":
                    return (this.currentToken = new StartToken());
                case "exit":
                    return (this.currentToken = new ExitToken());
                case "int":
                    return (this.currentToken = new IntToken());
                case "float":
                    return (this.currentToken = new FloatToken());
                case "string":
                    return (this.currentToken = new StringToken());
                case "if":
                    return (this.currentToken = new IfToken());
                case "then":
                    return (this.currentToken = new ThenToken());
                case "end":
                    return (this.currentToken = new EndToken());
                case "else":
                    return (this.currentToken = new ElseToken());
                case "do":
                    return (this.currentToken = new DoToken());
                case "while":
                    return (this.currentToken = new WhileToken());
                case "scan":
                    return (this.currentToken = new ScanToken());
                case "print":
                    return (this.currentToken = new PrintToken());
                case "not":
                    return (this.currentToken = new NotToken());
                case "or":
                    return (this.currentToken = new OrToken());
                case "and":
                    return (this.currentToken = new AndToken());
                default:
                    return (this.currentToken = new IdentifierToken(lexeme.toString()));
                }
            }
        }

        if ((int) this.currentChar == 8221) {
            this.nextChar();
            throw new CharacterInvalidException('"',
                    "[Close Quotation Mark(Unicode)] without open quotation before", this.currentLine);
        }
        if ((int) this.currentChar == 8220 || String.valueOf(this.currentChar).intern() == "\"") {
            StringBuilder literal = new StringBuilder();
            while (this.nextChar("character"))
                literal.append(this.currentChar);
            if ((int) this.currentChar == 8221 || String.valueOf(this.currentChar) == "\"") {
                this.nextChar();
                return (this.currentToken = new LiteralToken(literal.toString()));
            } else if ((int) this.currentChar == 8220) {
                this.nextChar();
                throw new CharacterInvalidException('"',
                        "[Open Quotation Mark(Unicode)] already opened quotation", this.currentLine);
            } else if (String.valueOf(this.currentChar) == "\n") {
                char c = this.currentChar;
                this.nextChar();
                throw new CharacterInvalidException(c, "[New Line] can't be used within a literal",
                        this.currentLine);
            } else {
                char c = this.currentChar;
                this.nextChar();
                throw new CharacterInvalidException(c, " can't be used within a literal",
                        this.currentLine);
            }
        }

        if (CharMatcher.ascii().matches(this.currentChar)) {
            switch (String.valueOf(this.currentChar).intern()) {
            case "=":
                if (this.nextChar("=")){
                    this.nextChar();
                    return (this.currentToken = new EqualToken());
                }
                else
                    return (this.currentToken = new AssignToken());
            case ">":
                if (this.nextChar("=")){
                    this.nextChar();
                    return (this.currentToken = new BiggerEqualToken());
                }
                else
                    return (this.currentToken = new BiggerToken());
            case "<":
                if (this.nextChar("=")){
                    this.nextChar();
                    return (this.currentToken = new SmallerEqualToken());
                }
                else if (String.valueOf(this.currentChar).intern() == ">"){
                    this.nextChar();
                    return (this.currentToken = new DoubleArrowToken());
                }
                else
                    return (this.currentToken = new SmallerToken());
            case "+":
                this.nextChar();
                return (this.currentToken = new PlusToken());
            case "*":
                this.nextChar();
                return (this.currentToken = new TimesToken());
            case "/":
                this.comment();
                return this.currentToken;
            case "-":
                this.nextChar();
                return (this.currentToken = new MinusToken());
            case ";":
                this.nextChar();
                return (this.currentToken = new SemiColonToken());
            case ",":
                this.nextChar();
                return (this.currentToken = new CommaToken());
            case "(":
                this.nextChar();
                return (this.currentToken = new OpenParenthesisToken());
            case ")":
                this.nextChar();
                return (this.currentToken = new CloseParenthesisToken());
            case ".":
                this.nextChar();
                return (this.currentToken = new DotToken());
            default:
                this.currentToken = new CaractereToken(String.valueOf(this.currentChar));
                this.nextChar();
                return this.currentToken;
            }
        }

        if ((int) this.currentChar == 65535) {
            return (this.currentToken = new EOFToken());
        }

        throw new UnknownCharacterException(this.currentChar, this.currentLine);
    }

    private void comment() throws IOException, LexicalException {
        this.nextChar();
        switch (String.valueOf(this.currentChar).intern()) {
        case "/":
            this.nextChar();
            while (this.currentChar != '\n' && (int) this.currentChar != 65535)
                this.nextChar();

            if ((int) this.currentChar == 65535)
                throw new LexicalException("Comment Unfinished", this.currentLine);

            this.currentToken = this.nextToken();
            break;
        case "*":
            this.multipleline();
            this.nextChar();
            this.currentToken = this.nextToken();
            break;
        default:
            this.currentToken = new DividerToken();
            break;
        }
    }

    private void multipleline() throws IOException, LexicalException {
        this.nextChar();

        while (this.currentChar != '*' && (int) this.currentChar != 65535){
            if (this.currentChar == '\n')
                this.currentLine++;
            this.nextChar();
        }

        if ((int) this.currentChar == 65535)
            throw new LexicalException("Comment Unfinished", this.currentLine);

        this.nextChar();

        if ((int) this.currentChar == 65535)
            throw new LexicalException("Comment Unfinished", this.currentLine);

        if (this.currentChar != '/')
            this.multipleline();
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

    public int getLine() {
        return this.currentLine;
    }

    public Token getCurrentToken() {
        return this.currentToken;
    }
}