package compiler;
import compiler.SyntaxAnalyser;
import procedures.*;
import compiler.Tag;
import compiler.Token;

public class PanicMode {
    private static void print(Procedure p, Token t){
        System.out.println("  Procedure: " + p.getClass());
        System.out.print("  Unexpected Token: ");
        Tag.printTag(t.getTag());
        System.out.println("  Lexeme: " + t.toString() );        
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
        }    
    }
    
    private static void assignStmtProcedure(Token t, int[] expected_tags) {
        //| assign-stmt | *[ identifier ]* | *[ ; ]* |
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.SEMICOLON){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.SEMICOLON:
                new AssignStmtProcedure().consume(Tag.SEMICOLON,false);
                break;
        }
    }
    
    private static void declProcedure( Token t, int[] expected_tags){
        //*decl-list:*    [ int ] [ float ] [ string ] *stmt-list:* [ print ] [ scan ] [ do ] [ if ] [ identifier ] [ / ] 
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.INT && t.getTag() != Tag.FLOAT &&  t.getTag() != Tag.STRING 
            && t.getTag() != Tag.PRINT && t.getTag() != Tag.SCAN &&  t.getTag() != Tag.DO
            && t.getTag() != Tag.IF && t.getTag() != Tag.IDENTIFIER &&  t.getTag() != Tag.DIVIDER){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.INT:
            case Tag.FLOAT:
            case Tag.STRING:
                new DeclListProcedure().check(t);
                break;
            case Tag.PRINT:
            case Tag.SCAN:
            case Tag.DO:
            case Tag.IF:
            case Tag.IDENTIFIER:
            case Tag.DIVIDER:
                new StmtListProcedure().check(t);
                break;
        }
    }
    
    private static void expressionAsteriskProcedure( Token t, int[] expected_tags){
                // follow do expression: )   
                       // do condition:  then   ou end
            t = SyntaxAnalyser.nextToken();
            while(t.getTag() != Tag.CLOSE_PARENTHESIS && t.getTag() != Tag.THEN 
                    && t.getTag() != Tag.END){
                t = SyntaxAnalyser.nextToken();
            }
            switch (t.getTag()) {
                case Tag.CLOSE_PARENTHESIS:
                    new ExpressionAsteriskProcedure().consume(Tag.CLOSE_PARENTHESIS,false);
                    break;
                case Tag.END:
                    new ExpressionAsteriskProcedure().consume(Tag.END,false);  
                    break;
                case Tag.THEN:
                    new ExpressionAsteriskProcedure().consume(Tag.THEN,false);
                    break;
            }
    } 
    
    private static void factorAProcedure( Token t, int[] expected_tags){
        termAsteriskProcedure(t, expected_tags);
    } 
    
    private static void factorProcedure( Token t, int[] expected_tags){
        factorAProcedure(t, expected_tags);
    } 
    
    private static void identListAsteriskProcedure( Token t, int[] expected_tags){
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.SEMICOLON){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.SEMICOLON:
                new IdentListAsteriskProcedure().consume(Tag.SEMICOLON,false);
                break;
        }
    } 
    
    private static void identListProcedure( Token t, int[] expected_tags){
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.SEMICOLON){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.SEMICOLON:
                new IdentListProcedure().consume(Tag.SEMICOLON,false);
                break;
        }
    } 
    
    private static void ifStmtAsteriskProcedure( Token t, int[] expected_tags){
        ifStmtProcedure(t,expected_tags);
    } 
    
    private static void ifStmtProcedure( Token t, int[] expected_tags){
        stmtProcedure(t,expected_tags);
    } 
        
    private static void readStmtProcedure( Token t, int[] expected_tags){
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.SEMICOLON){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.SEMICOLON:
                new ReadStmtProcedure().consume(Tag.SEMICOLON,false);
                break;
        }
    } 
    
    private static void simpleExprAsteriskProcedure( Token t, int[] expected_tags){
        factorAProcedure(t,expected_tags);
    } 
    
    private static void stmtProcedure( Token t, int[] expected_tags){
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.EXIT && t.getTag() != Tag.END && t.getTag() != Tag.WHILE &&
              t.getTag() != Tag.IDENTIFIER && t.getTag() != Tag.IF && t.getTag() != Tag.DO &&
              t.getTag() != Tag.SCAN && t.getTag() != Tag.PRINT){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.EXIT:
                new IfStmtProcedure().consume(Tag.EXIT,false);
                break;
            case Tag.END:
                new IfStmtProcedure().consume(Tag.END,false);
                break;
            case Tag.WHILE:
                new IfStmtProcedure().consume(Tag.WHILE,false);
                break;
            case Tag.IDENTIFIER:
                new IfStmtProcedure().consume(Tag.IDENTIFIER,false);
                break;
            case Tag.IF:
                new IfStmtProcedure().consume(Tag.IF,false);
                break;
            case Tag.DO:
                new IfStmtProcedure().consume(Tag.DO,false);
                break;
            case Tag.SCAN:
                new IfStmtProcedure().consume(Tag.SCAN,false);
                break;
            case Tag.PRINT:
                new IfStmtProcedure().consume(Tag.PRINT,false);
                break;
        }
    } 
    
    private static void stmtSufixProcedure( Token t, int[] expected_tags){
        whileStmtProcedure(t,expected_tags);
    } 
    
    private static void termAsteriskProcedure( Token t, int[] expected_tags){
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.TIMES && t.getTag() != Tag.DIVIDER && t.getTag() != Tag.AND && 
              t.getTag() != Tag.EQUAL && t.getTag() != Tag.BIGGER && t.getTag() != Tag.BIGGER_EQUAL && 
              t.getTag() != Tag.SMALLER && t.getTag() != Tag.SMALLER_EQUAL && t.getTag() != Tag.DOUBLE_ARROW && 
              t.getTag() != Tag.PLUS && t.getTag() != Tag.MINUS && t.getTag() != Tag.OR && 
              t.getTag() != Tag.END && t.getTag() != Tag.THEN && t.getTag() != Tag.SEMICOLON &&
              t.getTag() != Tag.CLOSE_PARENTHESIS){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.TIMES:
            case Tag.DIVIDER:
            case Tag.AND:
                new TermAsteriskProcedure().check(t);
                break;
            case Tag.EQUAL:
            case Tag.BIGGER:
            case Tag.BIGGER_EQUAL:
            case Tag.SMALLER:
            case Tag.SMALLER_EQUAL:
            case Tag.DOUBLE_ARROW:
                new ExpressionAsteriskProcedure().check(t);
                break;
            case Tag.PLUS:
            case Tag.MINUS:
            case Tag.OR:
                new SimpleExprAsteriskProcedure().check(t);
                break;
            case Tag.SEMICOLON:
                new FactorAProcedure().consume(Tag.SEMICOLON,false);
                break;
            case Tag.END:
                new FactorAProcedure().consume(Tag.END,false);
                break;
            case Tag.THEN:
                new FactorAProcedure().consume(Tag.THEN,false);
                break;
            case Tag.CLOSE_PARENTHESIS:
                new FactorAProcedure().consume(Tag.CLOSE_PARENTHESIS,false);
                break;
        }
    } 
    
    private static void whileStmtProcedure( Token t, int[] expected_tags){
        stmtProcedure(t,expected_tags);
    } 
    
    private static void writeStmtProcedure( Token t, int[] expected_tags){
        t = SyntaxAnalyser.nextToken();
        while(t.getTag() != Tag.SEMICOLON){
            t = SyntaxAnalyser.nextToken();
        }
        switch (t.getTag()) {
            case Tag.SEMICOLON:
                new ReadStmtProcedure().consume(Tag.SEMICOLON,false);
                break;
        }
    }
}