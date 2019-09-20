package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LexicalAnalyser
{
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private char cc;

    public void openFile(String filepath){
        this.file = new File(filepath);
        this.fileReader = new FileReader(this.file);
        this.bufferedReader = new BufferedReader(this.fileReader);
    }

    public boolean nextChar(){
        int c; 
        if((c = this.bufferedReader.read()) == -1)
            return false;
        this.cc = (char) c;
        return true;
    }


}