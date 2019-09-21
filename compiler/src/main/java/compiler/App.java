package compiler;

import java.io.FileNotFoundException;

import compiler.LexicalAnalyser;

public class App
{
    public static void main( String[] args )
    {
        if(args.length > 0) {
            for (String arg : args){
                try {
                    LexicalAnalyser lexical = new LexicalAnalyser();
                    lexical.openFile(arg);
                } catch (FileNotFoundException e) {
                    System.out.println("Invalid file path : " + arg);
                }
            }
        } else {
            System.err.println("Please inform a file to compile");
        }
    }
}
