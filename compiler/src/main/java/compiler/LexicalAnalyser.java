package compiler;

import compiler.SymbolTable;
import tokens.*;

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
    private SymbolTable symbolTable;
    
    public void openFile(String path) throws FileNotFoundException {
        this.file = new File(path);
        this.fileReader = new FileReader(this.file);
        this.bufferedReader = new BufferedReader(this.fileReader);
        this.symbolTable = new SymbolTable();
    }

    public boolean nextChar() throws IOException{
        if((int)(this.currentChar = (char) this.bufferedReader.read()) == -1)
            return false;
        return true;
    }

    public boolean nextChar(String condition) throws IOException{
        if((int)(this.currentChar = (char) this.bufferedReader.read()) == -1)
            return false;
        
        if (condition.intern() == "digit") {
            return Character.isDigit(this.currentChar);
        } 
        else if(condition.intern() == "letter"){
            return Character.isLetter(this.currentChar);            
        }
        else if(condition.intern() == "character"){
            return (CharMatcher.ascii().matches(this.currentChar) && String.valueOf(this.currentChar) != "\""  && (int)this.currentChar != 8220 && (int)this.currentChar != 8221  && String.valueOf(this.currentChar) != "\n") ? true : false;            
        }
        else if(condition.intern() == "empty"){
            return (this.currentChar == ' ' || this.currentChar == '\t' || this.currentChar == '\r' || this.currentChar == '\b' || this.currentChar == '\n') ? true : false;            
        }
        else{
            return (String.valueOf(this.currentChar).intern() == condition.intern()) ? true : false;            
        }
    }

    public void scanToken() throws IOException {
        while(this.nextChar("empty")){}

        while((int)this.currentChar != 65535){

            if(this.currentChar == ' ' || this.currentChar == '\t' || this.currentChar == '\r' || this.currentChar == '\b' || this.currentChar == '\n')
                while(this.nextChar("empty")){}

            if(Character.isDigit(this.currentChar)){
                StringBuilder number = new StringBuilder();
                number.append(this.currentChar);
                while(this.nextChar("digit"))
                    number.append(this.currentChar);                    
                if(String.valueOf(this.currentChar).intern() == "."){
                    number.append(this.currentChar);                                   
                    while(this.nextChar("digit"))
                        number.append(this.currentChar);
                    this.symbolTable.insertToken(new FloatConstantToken(Float.valueOf(number.toString())));
                    System.out.println(number.toString());
                } 
                else{
                    this.symbolTable.insertToken(new IntegerConstantToken(Integer.valueOf(number.toString())));
                    System.out.println(number.toString());
                }
            }

            if(Character.isLetter(this.currentChar)){
                StringBuilder lexeme = new StringBuilder();
                lexeme.append(this.currentChar);
                while(this.nextChar("letter"))
                    lexeme.append(this.currentChar);                    
                if(Character.isDigit(this.currentChar)){
                    while (this.nextChar() && (Character.isDigit(this.currentChar) || Character.isLetter(this.currentChar))) {
                        lexeme.append(this.currentChar);                    
                    }
                    this.symbolTable.insertToken(new IdentifierToken(lexeme.toString()));
                    System.out.println(lexeme.toString());
                }
                else{
                    switch (lexeme.toString().intern()) {
                        case "start":
                            this.symbolTable.insertToken(new StartToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "exit":
                            this.symbolTable.insertToken(new ExitToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "int":
                            this.symbolTable.insertToken(new IntToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "float":
                            this.symbolTable.insertToken(new FloatToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "string":
                            this.symbolTable.insertToken(new StringToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "if":
                            this.symbolTable.insertToken(new IfToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "then":
                            this.symbolTable.insertToken(new ThenToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "end":
                            this.symbolTable.insertToken(new EndToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "else":
                            this.symbolTable.insertToken(new ElseToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "do":
                            this.symbolTable.insertToken(new DoToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "while":
                            this.symbolTable.insertToken(new WhileToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "scan":
                            this.symbolTable.insertToken(new ScanToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "print":
                            this.symbolTable.insertToken(new PrintToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "not":
                            this.symbolTable.insertToken(new NotToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "or":
                            this.symbolTable.insertToken(new OrToken());
                            System.out.println(lexeme.toString());
                            break;
                        case "and":
                            this.symbolTable.insertToken(new AndToken());
                            System.out.println(lexeme.toString());
                            break;
                        default:
                            this.symbolTable.insertToken(new IdentifierToken(lexeme.toString()));
                            System.out.println(lexeme.toString());
                            break;
                    }    
                }
            }

            if((int)this.currentChar == 8221 ){
                System.out.println("Deu ruim não sei o que dizer");
                nextChar();
            }

            if((int)this.currentChar == 8220 || String.valueOf(this.currentChar).intern() == "\""){
                StringBuilder literal = new StringBuilder();
                literal.append(this.currentChar);
                while(this.nextChar("character"))
                    literal.append(this.currentChar);                    
                if((int)this.currentChar == 8221 || String.valueOf(this.currentChar) == "\""){
                    this.symbolTable.insertToken(new LiteralToken(literal.toString()));
                    nextChar();
                }
                else{
                    System.out.println("Deu ruim não sei o que dizer");
                }
                System.out.println("”" + literal.toString() +"”");
            }

            if(CharMatcher.ascii().matches(this.currentChar)){
                switch (String.valueOf(this.currentChar).intern()) {
                    case "=":
                        if(this.nextChar("="))
                            this.symbolTable.insertToken(new EqualToken());
                        else
                            this.symbolTable.insertToken(new AssignToken());

                        System.out.println(this.currentChar);
                        break;
                    case ">":
                        if(this.nextChar("="))
                            this.symbolTable.insertToken(new BiggerEqualToken());
                        else
                            this.symbolTable.insertToken(new BiggerToken());

                        System.out.println(this.currentChar);
                        break;
                    case "<":
                        if(this.nextChar("="))
                            this.symbolTable.insertToken(new SmallerEqualToken());
                        else if(String.valueOf(this.currentChar).intern() == ">")
                            this.symbolTable.insertToken(new DoubleArrowToken());
                        else
                            this.symbolTable.insertToken(new SmallerToken());
                            
                        System.out.println(this.currentChar);
                        break;
                    case "+":
                        this.symbolTable.insertToken(new PlusToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case "*":
                        this.symbolTable.insertToken(new TimesToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case "/":
                        this.symbolTable.insertToken(new DividerToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case "-":
                        this.symbolTable.insertToken(new MinusToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case ";":
                        this.symbolTable.insertToken(new SemiColonToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case ",":
                        this.symbolTable.insertToken(new CommaToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case "(":
                        this.symbolTable.insertToken(new OpenParenthesisToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case ")":
                        this.symbolTable.insertToken(new CloseParenthesisToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    case ".":
                        this.symbolTable.insertToken(new DotToken());
                        System.out.println(this.currentChar);
                        nextChar();
                        break;
                    default:
                        if(String.valueOf(this.currentChar) != "\n"){
                            this.symbolTable.insertToken(new CaractereToken(String.valueOf(this.currentChar)));
                            System.out.println(this.currentChar);
                        }
                        nextChar();
                        break;
                }
            }
            System.in.read();
        }
    }
}