package compiler;

import compiler.LexicalAnalyser;

public class App
{
    public static void main( String[] args )
    {
        if(args.leght > 0){
            for (String arg : args){
                try {
                    System.out.println(arg);
                    LexicalAnalyser lexical = new LexicalAnalyser();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.err.println("Please inform a file to compile");
        }
    }
}
