package compiler;

import procedures.*;
import compiler.Tag;
public class PanicMode {
    
    public static boolean nextToken(Procedure p, int tag, LexicalAnalyser lexical){
        Tag.printTag(tag);
        return false;
    }
}