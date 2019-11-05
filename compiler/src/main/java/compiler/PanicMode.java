package compiler;

import procedures.*;
import compiler.Tag;

public class PanicMode {

    public static boolean nextToken(Procedure p, int tag) {
        System.out.print(p.getClass());
        Tag.printTag(tag);
        return false;
    }
}