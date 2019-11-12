package compiler;

import java.io.IOException;
import java.util.Arrays;

import compiler.SyntaxAnalyser;
import procedures.*;
import tokens.CommaToken;
import compiler.Tag;
import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;

public class PanicMode {
    private static void print(Procedure p, Token t, int[] expected) {
        System.out.println("\n* Procedure: " + p.getClass());
        System.out.println("  Unexpected token: " + t.toString());
        System.out.println("  Expected Token: ");
        for (int tag : expected) {
            Tag.printTag(tag);
        }
        System.out.println("  Lexeme: " + t.toString());
    }

    public static void nextToken(Procedure p, Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        PanicMode.print(p, t, expected_tags);

        switch (p.getTag()) {
        case Procedure.ASSIGNSTMT_PROCEDURE:
            PanicMode.assignStmtProcedure(t, expected_tags);
            break;
        case Procedure.DECL_PROCEDURE:
            PanicMode.declProcedure(t, expected_tags);
            break;
        case Procedure.FACTORA_PROCEDURE:
            PanicMode.factorAProcedure(t, expected_tags);
            break;
        case Procedure.FACTOR_PROCEDURE:
            PanicMode.factorProcedure(t, expected_tags);
            break;
        case Procedure.IDENTLIST_ASTERISK_PROCEDURE:
            PanicMode.identListAsteriskProcedure(t, expected_tags);
            break;
        case Procedure.IDENTLIST_PROCEDURE:
            PanicMode.identListProcedure(t, expected_tags);
            break;
        case Procedure.IFSTMT_ASTERISK_PROCEDURE:
            PanicMode.ifStmtAsteriskProcedure(t, expected_tags);
            break;
        case Procedure.IFSTMT_PROCEDURE:
            PanicMode.ifStmtProcedure(t, expected_tags);
            break;
        case Procedure.PROGRAM_PROCEDURE:
            PanicMode.programProcedure(t, expected_tags);
            break;
        case Procedure.READSTMT_PROCEDURE:
            PanicMode.readStmtProcedure(t, expected_tags);
            break;
        case Procedure.STMT_PROCEDURE:
            PanicMode.stmtProcedure(t, expected_tags);
            break;
        case Procedure.STMTSUFIX_PROCEDURE:
            PanicMode.stmtSufixProcedure(t, expected_tags);
            break;
        case Procedure.WHILESTMT_PROCEDURE:
            PanicMode.whileStmtProcedure(t, expected_tags);
            break;
        case Procedure.WRITESTMT_PROCEDURE:
            PanicMode.writeStmtProcedure(t, expected_tags);
            break;
        }
    }

    private static void programProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        if (expected_tags[0] == Tag.START) {
            while (    t.getTag() != Tag.INT && t.getTag() != Tag.FLOAT && t.getTag() != Tag.STRING
                    && t.getTag() != Tag.PRINT && t.getTag() != Tag.SCAN && t.getTag() != Tag.DO && t.getTag() != Tag.IF
                    && t.getTag() != Tag.IDENTIFIER)
                t = SyntaxAnalyser.nextToken();
            System.out.print("saiu - "); Tag.printTag(t.getTag());
        } else if (expected_tags[0] == Tag.EXIT) {
            while (t.getTag() != Tag.EOF)
                t = SyntaxAnalyser.nextToken();
        }
    }

    private static void assignStmtProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        // | assign-stmt | *[ identifier ]* | *[ ; ]* |
        // identifier -> **assign-stmt, assign:** *[ = ]*
        if (expected_tags[0] == Tag.IDENTIFIER) {
            while (t.getTag() != Tag.ASSIGN)
                t = SyntaxAnalyser.nextToken();
        } else if (expected_tags[0] == Tag.ASSIGN) {
            // assign-stmt, simple-expr: [ identifier ] [ float_const ] [ integer_const ] [
            // literal ] [ ( ] [ not ] [ - ]
            while (t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.FLOAT_CONSTANT
                    && t.getTag() != Tag.INTEGER_CONSTANT && t.getTag() != Tag.LITERAL
                    && t.getTag() != Tag.OPEN_PARENTHESIS && t.getTag() != Tag.NOT && t.getTag() != Tag.MINUS)
                t = SyntaxAnalyser.nextToken();
        } else {
            while (t.getTag() != Tag.SEMICOLON) {
                t = SyntaxAnalyser.nextToken();
            }
        }
    }

    private static void declProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        // decl [ int ] [ float ] [ string ] decl-list: [ int ] [ float ] [ string ]
        // stmt-list: [ print ] [ scan ] [ do ] [ if ] [ identifier ]
        if (expected_tags.length > 1) {
            while (t.getTag() != Tag.INT && t.getTag() != Tag.FLOAT && t.getTag() != Tag.STRING
                    && t.getTag() != Tag.PRINT && t.getTag() != Tag.SCAN && t.getTag() != Tag.DO && t.getTag() != Tag.IF
                    && t.getTag() != Tag.IDENTIFIER)
                t = SyntaxAnalyser.nextToken();
        } else if (expected_tags[0] == Tag.ASSIGN) {
            // | assign | **assign-stmt, simple-expr:** *[ identifier ]* *[ float_const ]*
            // *[ integer_const ]* *[ literal ]* *[ ( ]* *[ not ]* *[ - ]* |
            while (t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.FLOAT_CONSTANT
                    && t.getTag() != Tag.INTEGER_CONSTANT && t.getTag() != Tag.LITERAL
                    && t.getTag() != Tag.OPEN_PARENTHESIS && t.getTag() != Tag.NOT && t.getTag() != Tag.MINUS) {
                t = SyntaxAnalyser.nextToken();
            }
        }
    }

    private static void factorAProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        // **term-asterisk:** *[ * ]* *[ / ]* *[ and ]* **simple-expr-asterisk:** *[ +
        // ]* *[ - ]* *[ or ]* **stmt-sufix:** *[ end ]* **if-stmt:** *[ then ]*
        // **factor:** *[ ) ]* **write-stmt:** *[ ) ]* **expression-asterisk:** *[ == ]*
        // *[ > ]* *[ >= ]* *[ < ]* *[ <= ]* *[ <> ]* **assign-stmt:** *[ ; ]*
        while (  t.getTag() != Tag.TIMES && t.getTag() != Tag.DIVIDER && t.getTag() != Tag.AND 
              && t.getTag() != Tag.EQUAL && t.getTag() != Tag.BIGGER && t.getTag() != Tag.BIGGER_EQUAL 
              && t.getTag() != Tag.SMALLER && t.getTag() != Tag.SMALLER_EQUAL && t.getTag() != Tag.DOUBLE_ARROW 
              && t.getTag() != Tag.PLUS && t.getTag() != Tag.MINUS && t.getTag() != Tag.OR && t.getTag() != Tag.END 
              && t.getTag() != Tag.THEN && t.getTag() != Tag.SEMICOLON && t.getTag() != Tag.CLOSE_PARENTHESIS)
            t = SyntaxAnalyser.nextToken();
        
    }

    private static void factorProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        factorAProcedure(t, expected_tags);
    }

    private static void identListAsteriskProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        // first: [ , ]	ident-list: [ ; ]
        if(expected_tags[0] == Tag.IDENTIFIER){
            while (t.getTag() != Tag.SEMICOLON && t.getTag() != Tag.COMMA )
                t = SyntaxAnalyser.nextToken();
        }
    }

    private static void identListProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        // first: [ , ]	ident-list: [ ; ]
        if(expected_tags[0] == Tag.IDENTIFIER){
            while (t.getTag() != Tag.SEMICOLON && t.getTag() != Tag.COMMA )
                t = SyntaxAnalyser.nextToken();
        }
    }

    private static void ifStmtAsteriskProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        // program: [ exit ] if-stmt-asterisk: [ end ] [ else ] stmt-sufix: [ while ]
        // stmt-asterisk: [ print ] [ scan ] [ do ] [ if ] [ identifier ] 
        while (    t.getTag() != Tag.EXIT  && t.getTag() != Tag.END && t.getTag() != Tag.ELSE 
                && t.getTag() != Tag.WHILE && t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.IF 
                && t.getTag() != Tag.DO && t.getTag() != Tag.SCAN  && t.getTag() != Tag.PRINT)
            t = SyntaxAnalyser.nextToken();        
    }

    private static void ifStmtProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        if(expected_tags[0] == Tag.IF){
            // [ identifier ] [ float_const ] [ integer_const ] [ literal ] [ ( ] [ not ] [ - ]
            while (t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.FLOAT_CONSTANT && t.getTag() != Tag.INTEGER_CONSTANT
                && t.getTag() != Tag.LITERAL && t.getTag() != Tag.OPEN_PARENTHESIS && t.getTag() != Tag.NOT  && t.getTag() != Tag.MINUS )
                t = SyntaxAnalyser.nextToken();
        } else if( expected_tags[0] == Tag.THEN){
            // [ print ] [ scan ] [ do ] [ if ] [ identifier ]	
            while (t.getTag() != Tag.PRINT && t.getTag() != Tag.SCAN && t.getTag() != Tag.DO
                && t.getTag() != Tag.IF && t.getTag() != Tag.IDENTIFIER)
                t = SyntaxAnalyser.nextToken();
        }
    }

    private static void readStmtProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        switch (expected_tags[0]) {
            case Tag.SCAN:
                while(t.getTag() != Tag.OPEN_PARENTHESIS)
                    t = SyntaxAnalyser.nextToken();
                break;
            case Tag.OPEN_PARENTHESIS:
                while(t.getTag() != Tag.IDENTIFIER)
                    t = SyntaxAnalyser.nextToken();
                break;
            case Tag.IDENTIFIER:
                while(t.getTag() != Tag.CLOSE_PARENTHESIS)
                    t = SyntaxAnalyser.nextToken();
                break;
            case Tag.CLOSE_PARENTHESIS:
                while (t.getTag() != Tag.SEMICOLON)
                    t = SyntaxAnalyser.nextToken();
                break;
        }
        
    }

    private static void stmtProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        // stmt-asterisk: [ print ] [ scan ] [ do ] [ if ] [ identifier ] program: [
        // exit ] if-stmt-asterisk: [ end ] [ else ] stmt-sufix: [ while ]
        while (    t.getTag() != Tag.EXIT  && t.getTag() != Tag.END && t.getTag() != Tag.ELSE 
                && t.getTag() != Tag.WHILE && t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.IF 
                && t.getTag() != Tag.DO && t.getTag() != Tag.SCAN  && t.getTag() != Tag.PRINT)
            t = SyntaxAnalyser.nextToken();       
    }

    private static void stmtSufixProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        switch (expected_tags[0]) {
            case Tag.WHILE:
                // [ identifier ] [ float_const ] [ integer_const ] [ literal ] [ ( ] [ not ] [ - ]
                while (t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.FLOAT_CONSTANT && t.getTag() != Tag.INTEGER_CONSTANT
                    && t.getTag() != Tag.LITERAL && t.getTag() != Tag.OPEN_PARENTHESIS && t.getTag() != Tag.NOT  && t.getTag() != Tag.MINUS )
                    t = SyntaxAnalyser.nextToken();
                break;
            case Tag.END:
                // stmt-asterisk: [ print ] [ scan ] [ do ] [ if ] [ identifier ] program: [
                // exit ] if-stmt-asterisk: [ end ] [ else ] stmt-sufix: [ while ]
                while (t.getTag() != Tag.EXIT  && t.getTag() != Tag.END && t.getTag() != Tag.ELSE 
                    && t.getTag() != Tag.WHILE && t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.IF 
                    && t.getTag() != Tag.DO && t.getTag() != Tag.SCAN  && t.getTag() != Tag.PRINT)
                    t = SyntaxAnalyser.nextToken();
                break;
        }
    }

    private static void whileStmtProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        if(expected_tags[0] == Tag.DO){
            while (t.getTag() != Tag.PRINT && t.getTag() != Tag.SCAN && t.getTag() != Tag.DO
                && t.getTag() != Tag.IF && t.getTag() != Tag.IDENTIFIER)
                    t = SyntaxAnalyser.nextToken();
        }
    }

    private static void writeStmtProcedure(Token t, int[] expected_tags)
            throws IOException, LexicalException, SyntaxException {
        switch (expected_tags[0]) {
            case Tag.PRINT:
                while(t.getTag() != Tag.OPEN_PARENTHESIS)
                    t = SyntaxAnalyser.nextToken();
                break;
            case Tag.OPEN_PARENTHESIS:
                // [ identifier ] [ float_const ] [ integer_const ] [ literal ] [ ( ] [ not ] [ - ]
                while (t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.FLOAT_CONSTANT && t.getTag() != Tag.INTEGER_CONSTANT
                    && t.getTag() != Tag.LITERAL && t.getTag() != Tag.OPEN_PARENTHESIS && t.getTag() != Tag.NOT  && t.getTag() != Tag.MINUS )
                    t = SyntaxAnalyser.nextToken();
                break;
            case Tag.CLOSE_PARENTHESIS:
                while (t.getTag() != Tag.SEMICOLON)
                    t = SyntaxAnalyser.nextToken();
                break;
        }
        
    }
    
}