package compiler;

import procedures.*;
import compiler.Tag;

public class PanicMode {
    private static void print(Procedure p, Token t){
        System.out.println("  Procedure: " + p.getClass());
        System.out.print("  Unexpected Token: ");
        Tag.printTag(t.getTag());
        System.out.print("  Lexeme: ");        
        System.out.println((t.getTag() != Tag.NEW_LINE) ? t.toString() : "NEW_LINE");
    }
    public static void nextToken(Procedure p, Token t) {
        PanicMode.print(p,t);
    }
}