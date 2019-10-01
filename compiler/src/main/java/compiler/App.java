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
                    System.out.println("---------- Compiling the file " + arg.split("/")[arg.split("/").length - 1] + "...");
                    LexicalAnalyser lexical = new LexicalAnalyser(arg);
                    SyntaxAnalyser syntax = new SyntaxAnalyser(lexical);
                    syntax.scanRules();
                    System.out.println("---------- Compilation finished  :/) ");
                } catch (FileNotFoundException e) {
                    System.out.println("---------- Invalid file path : " + arg + "\n");
                    continue;
                } catch (IOException e) {
                    System.out.println("---------- IOException: " + e.getMessage() + "\n");
                    continue;                
                } catch (LexicalException e) {
                    System.out.println("---------- " + e.getMessage() + "\n");
                    continue;                
                }
            }
        } else {
            System.err.println("Please inform a file to compile");
        }
    }
}
