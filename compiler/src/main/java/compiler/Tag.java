package compiler;

public class Tag {

    public static final int AND = 256, ASSIGN = 257, BIGGER_EQUAL = 258, BIGGER = 259, CARACTERE = 260,
            CLOSE_PARENTHESIS = 261, COMMA = 262, DIVIDER = 263, DO = 264, DOT = 265, DOUBLE_ARROW = 266, ELSE = 267,
            END = 268, EQUAL = 269, EXIT = 270, FLOAT_CONSTANT = 271, FLOAT = 272, IDENTIFIER = 273, IF = 274,
            INTEGER_CONSTANT = 275, INT = 276, LITERAL = 277, MINUS = 278, NOT = 279, OPEN_PARENTHESIS = 280, OR = 281,
            PLUS = 282, PRINT = 283, QUOTATION_MARK = 284, SCAN = 285, SEMICOLON = 286, SMALLER_EQUAL = 287,
            SMALLER = 288, START = 289, STRING = 290, THEN = 291, TIMES = 292, WHILE = 293, EOF = 294;

    public static void printTag(int tag) {
        switch (tag) {
        case 256:
            System.out.println(" AND");
            break;
        case 257:
            System.out.println(" ASSIGN");
            break;
        case 258:
            System.out.println(" BIGGER_EQUAL");
            break;
        case 259:
            System.out.println(" BIGGER");
            break;
        case 260:
            System.out.println(" CARACTERE");
            break;
        case 261:
            System.out.println(" CLOSE_PARENTHESIS");
            break;
        case 262:
            System.out.println(" COMMA");
            break;
        case 263:
            System.out.println(" DIVIDER");
            break;
        case 264:
            System.out.println(" DO");
            break;
        case 265:
            System.out.println(" DOT");
            break;
        case 266:
            System.out.println(" DOUBLE_ARROW");
            break;
        case 267:
            System.out.println(" ELSE");
            break;
        case 268:
            System.out.println(" END");
            break;
        case 269:
            System.out.println(" EQUAL");
            break;
        case 270:
            System.out.println(" EXIT");
            break;
        case 271:
            System.out.println(" FLOAT_CONSTANT");
            break;
        case 272:
            System.out.println(" FLOAT");
            break;
        case 273:
            System.out.println(" IDENTIFIER");
            break;
        case 274:
            System.out.println(" IF");
            break;
        case 275:
            System.out.println(" INTEGER_CONSTANT");
            break;
        case 276:
            System.out.println(" INT");
            break;
        case 277:
            System.out.println(" LITERAL");
            break;
        case 278:
            System.out.println(" MINUS");
            break;
        case 279:
            System.out.println(" NOT");
            break;
        case 280:
            System.out.println(" OPEN_PARENTHESIS");
            break;
        case 281:
            System.out.println(" OR");
            break;
        case 282:
            System.out.println(" PLUS");
            break;
        case 283:
            System.out.println(" PRINT");
            break;
        case 284:
            System.out.println(" QUOTATION_MARK");
            break;
        case 285:
            System.out.println(" SCAN");
            break;
        case 286:
            System.out.println(" SEMICOLON");
            break;
        case 287:
            System.out.println(" SMALLER_EQUAL");
            break;
        case 288:
            System.out.println(" SMALLER");
            break;
        case 289:
            System.out.println(" START");
            break;
        case 290:
            System.out.println(" STRING");
            break;
        case 291:
            System.out.println(" THEN");
            break;
        case 292:
            System.out.println(" TIMES");
            break;
        case 293:
            System.out.println(" WHILE");
            break;
        case 294:
            System.out.println(" EOF");
            break;
        }
    }
}