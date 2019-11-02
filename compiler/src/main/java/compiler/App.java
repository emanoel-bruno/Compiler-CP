package compiler;

import java.io.FileNotFoundException;
import java.io.IOException;

import exceptions.LexicalException;
import exceptions.SyntaxException;
import compiler.LexicalAnalyser;
import compiler.SyntaxAnalyser;

public class App {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String arg : args) {
                try {
                    System.out.println("-- Compiling " + arg.split("/")[arg.split("/").length - 1] + "...");
                    LexicalAnalyser lexical = new LexicalAnalyser(arg);
                    SyntaxAnalyser syntax = new SyntaxAnalyser(lexical);
                    syntax.scanRules();
                    System.out.println("-- " + arg.split("/")[arg.split("/").length - 1] + " compilation finished  :) \n");
                } catch (FileNotFoundException e) {
                    System.out.println("- Invalid file path : " + arg + "\n");
                    System.out.println("-- " + arg.split("/")[arg.split("/").length - 1] + " compilation finished  :(");
                    continue;
                } catch (IOException e) {
                    System.out.println("- IOException: " + e.getMessage() + "\n");
                    System.out.println("-- " + arg.split("/")[arg.split("/").length - 1] + " compilation finished  :(");
                    continue;                
                } catch (LexicalException e) {
                    System.out.println("- " + e.getMessage() + "\n");
                    System.out.println("-- " + arg.split("/")[arg.split("/").length - 1] + " compilation finished  :(\n");
                    continue;                
                } catch (SyntaxException e) {
                    System.out.println("- " + e.getMessage() + "\n");
                    System.out.println("-- " + arg.split("/")[arg.split("/").length - 1] + " compilation finished  :(\n");
                }
            }
        } else {
            System.err.println("Please inform a file to compile");
        }
    }
}
