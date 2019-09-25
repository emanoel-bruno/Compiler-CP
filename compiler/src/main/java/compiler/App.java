package compiler;

import java.io.FileNotFoundException;
import java.io.IOException;

import exception.LexicalException;

import compiler.LexicalAnalyser;
import compiler.SyntaxAnalyser;


public class App {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String arg : args) {
                try {
                    LexicalAnalyser lexical = new LexicalAnalyser();
                    lexical.openFile(arg);
                    SyntaxAnalyser syntax = new SyntaxAnalyser(lexical);
                    syntax.scanRules();
                } catch (FileNotFoundException e) {
                    System.out.println("Invalid file path : " + arg);
                } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                } catch (LexicalException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.err.println("Please inform a file to compile");
        }
    }
}
