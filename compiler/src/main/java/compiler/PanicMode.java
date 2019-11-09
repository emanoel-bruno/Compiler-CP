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

    public static void nextToken( Procedure p, Token t, int[] expected_tags) {
        // PanicMode.print(p, t);

        switch (p.getTag()) {
        case Procedure.ASSIGNSTMT_PROCEDURE:
            PanicMode.assignStmtProcedure( t, expected_tags );
            break;
        case Procedure.DECL_PROCEDURE: 
            PanicMode.declProcedure( t, expected_tags );
            break;
        case Procedure.EXPRESSION_ASTERISK_PROCEDURE: 
            PanicMode.expressionAsteriskProcedure( t, expected_tags );
            break;
        case Procedure.FACTORA_PROCEDURE: 
            PanicMode.factorAProcedure( t, expected_tags );
            break;
        case Procedure.FACTOR_PROCEDURE: 
            PanicMode.factorProcedure( t, expected_tags );
            break;
        case Procedure.IDENTLIST_ASTERISK_PROCEDURE: 
            PanicMode.identListAsteriskProcedure( t, expected_tags );
            break;
        case Procedure.IDENTLIST_PROCEDURE: 
            PanicMode.identListProcedure( t, expected_tags );
            break;
        case Procedure.IFSTMT_ASTERISK_PROCEDURE: 
            PanicMode.ifStmtAsteriskProcedure( t, expected_tags );
            break;
        case Procedure.IFSTMT_PROCEDURE: 
            PanicMode.ifStmtProcedure( t, expected_tags );
            break;
        case Procedure.PROGRAM_PROCEDURE: 
            PanicMode.programProcedure( t, expected_tags );
            break;
        case Procedure.READSTMT_PROCEDURE: 
            PanicMode.readStmtProcedure( t, expected_tags );
            break;
        case Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE: 
            PanicMode.simpleExprAsteriskProcedure( t, expected_tags );
            break;
        case Procedure.STMT_PROCEDURE: 
            PanicMode.stmtProcedure( t, expected_tags );
            break;
        case Procedure.STMTSUFIX_PROCEDURE: 
            PanicMode.stmtSufixProcedure( t, expected_tags );
            break;
        case Procedure.TERM_ASTERISK_PROCEDURE: 
            PanicMode.termAsteriskProcedure( t, expected_tags );
            break;
        case Procedure.WHILESTMT_PROCEDURE: 
            PanicMode.whileStmtProcedure( t, expected_tags );
            break;
        case Procedure.WRITESTMT_PROCEDURE:
            PanicMode.writeStmtProcedure( t, expected_tags );
            break;
        case Procedure.COMMENT_PROCEDURE:
            PanicMode.commentProcedure( t, expected_tags );
            break;
        case Procedure.ONE_LINE_PROCEDURE:
            PanicMode.oneLineProcedure( t, expected_tags );
            break;
        case Procedure.MULTIPLE_LINE_PROCEDURE:
            PanicMode.multipleLineProcedure( t, expected_tags );
            break;
        case Procedure.MULTIPLE_LINE_ASTERISK_PROCEDURE:
            PanicMode.multipleLineAsteriskProcedure( t, expected_tags );
            break;
        }    
    }
    
    private static void assignStmtProcedure(Token t, int[] expected_tags) {
        
    }
    
    private static void declProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void expressionAsteriskProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void factorAProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void factorProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void identListAsteriskProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void identListProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void ifStmtAsteriskProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void ifStmtProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void programProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void readStmtProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void simpleExprAsteriskProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void stmtProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void stmtSufixProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void termAsteriskProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void whileStmtProcedure( Token t, int[] expected_tags){
    
    } 
    
    private static void writeStmtProcedure( Token t, int[] expected_tags){
    
    }
    
    private static void commentProcedure( Token t, int[] expected_tags){
    
    }
    
    private static void oneLineProcedure( Token t, int[] expected_tags){
    
    }
    
    private static void multipleLineProcedure( Token t, int[] expected_tags){
    
    }
    
    private static void multipleLineAsteriskProcedure( Token t, int[] expected_tags){
    
    }
}