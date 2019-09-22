package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LexicalAnalyser {
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private char currentChar;
    
    public void openFile(String path) throws FileNotFoundException {
        this.file = new File(path);
        this.fileReader = new FileReader(this.file);
        this.bufferedReader = new BufferedReader(this.fileReader);
    }

    public boolean nextChar() throws IOException{
        int c; 
        if((c = this.bufferedReader.read()) == -1)
            return false;
        this.currentChar = (char) c;
        return true;
    }


    public boolean nextChar(String condition) throws IOException{
        int c = this.bufferedReader.read();
        if (condition.intern() == "digit") {
            return Character.isDigit(c);
        } 
        else if(condition.intern() == "letter"){
            return Character.isLetter(c);            
        }
        else if(condition.intern() == "character"){
            return (Character.isBmpCodePoint(c) && c != 34 && c != 10) ? true : false;            
        }
        else if(c == -1)
            return false;
        this.currentChar = (char) c;
        return true;
    }
}