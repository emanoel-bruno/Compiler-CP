package compiler;

import java.io.IOException;

import compiler.LexicalAnalyser;
import compiler.Token;
import exceptions.LexicalException;
import exceptions.SyntaxException;
import exceptions.UnexpectedTokenException;
import procedures.*;

public abstract class Procedure {
    protected LexicalAnalyser lexical;

    protected int tag;

    public static final int ASSIGNSTMT_PROCEDURE = 0, CONDITION_PROCEDURE = 1, DECLLIST_PROCEDURE = 3,
            DECL_PROCEDURE = 4, EXPRESSION_ASTERISK_PROCEDURE = 5, EXPRESSION_PROCEDURE = 6, FACTORA_PROCEDURE = 7,
            FACTOR_PROCEDURE = 8, IDENTLIST_ASTERISK_PROCEDURE = 9, IDENTLIST_PROCEDURE = 10,
            IFSTMT_ASTERISK_PROCEDURE = 11, IFSTMT_PROCEDURE = 12, PROGRAM_PROCEDURE = 13, READSTMT_PROCEDURE = 14,
            SIMPLEEXPR_ASTERISK_PROCEDURE = 15, SIMPLEEXPR_PROCEDURE = 16, STMT_ASTERISK_PROCEDURE = 17,
            STMTLIST_PROCEDURE = 18, STMT_PROCEDURE = 19, STMTSUFIX_PROCEDURE = 20, TERM_ASTERISK_PROCEDURE = 21,
            TERM_PROCEDURE = 22, WHILESTMT_PROCEDURE = 23, WRITEABLE_PROCEDURE = 24, WRITESTMT_PROCEDURE = 25;

    public void consume(int tag) throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        int line = SyntaxAnalyser.currentLine();
        if (t.getTag() != tag) {
            PanicMode.nextToken(this, t, new int[] { tag });
            SyntaxAnalyser.printError("\n  Unexpected Token: " + t.toString(), line);
        }
        else{
            SyntaxAnalyser.nextToken();
        }
    }

    public int getTag() {
        return this.tag;
    }

    public void invoke( int procedure ) throws IOException, LexicalException, SyntaxException {
        Token t = SyntaxAnalyser.currentToken();
        switch (procedure) {
        case Procedure.ASSIGNSTMT_PROCEDURE:
            new AssignStmtProcedure().check();
            break;
        case Procedure.CONDITION_PROCEDURE:
            new ConditionProcedure().check();
            break;
        case Procedure.DECLLIST_PROCEDURE:
            new DeclListProcedure().check();
            break;
        case Procedure.DECL_PROCEDURE:
            new DeclProcedure().check();
            break;
        case Procedure.EXPRESSION_ASTERISK_PROCEDURE:
            new ExpressionAsteriskProcedure().check();
            break;
        case Procedure.EXPRESSION_PROCEDURE:
            new ExpressionProcedure().check();
            break;
        case Procedure.FACTORA_PROCEDURE:
            new FactorAProcedure().check();
            break;
        case Procedure.FACTOR_PROCEDURE:
            new FactorProcedure().check();
            break;
        case Procedure.IDENTLIST_ASTERISK_PROCEDURE:
            new IdentListAsteriskProcedure().check();
            break;
        case Procedure.IDENTLIST_PROCEDURE:
            new IdentListProcedure().check();
            break;
        case Procedure.IFSTMT_ASTERISK_PROCEDURE:
            new IfStmtAsteriskProcedure().check();
            break;
        case Procedure.IFSTMT_PROCEDURE:
            new IfStmtProcedure().check();
            break;
        case Procedure.PROGRAM_PROCEDURE:
            new ProgramProcedure().check();
            break;
        case Procedure.READSTMT_PROCEDURE:
            new ReadStmtProcedure().check();
            break;
        case Procedure.SIMPLEEXPR_ASTERISK_PROCEDURE:
            new SimpleExprAsteriskProcedure().check();
            break;
        case Procedure.SIMPLEEXPR_PROCEDURE:
            new SimpleExprProcedure().check();
            break;
        case Procedure.STMT_ASTERISK_PROCEDURE:
            new StmtAsteriskProcedure().check();
            break;
        case Procedure.STMTLIST_PROCEDURE:
            new StmtListProcedure().check();
            break;
        case Procedure.STMT_PROCEDURE:
            new StmtProcedure().check();
            break;
        case Procedure.STMTSUFIX_PROCEDURE:
            new StmtProcedure().check();
            break;
        case Procedure.TERM_ASTERISK_PROCEDURE:
            new TermAsteriskProcedure().check();
            break;
        case Procedure.TERM_PROCEDURE:
            new TermProcedure().check();
            break;
        case Procedure.WHILESTMT_PROCEDURE:
            new WhileStmtProcedure().check();
            break;
        case Procedure.WRITEABLE_PROCEDURE:
            new WriteableProcedure().check();
            break;
        case Procedure.WRITESTMT_PROCEDURE:
            new WriteStmtProcedure().check();
            break;
        }
    }

    private void debug(Token t) {
        System.out.print(this.getClass() + "[" + SyntaxAnalyser.currentLine() + "] - ");
        Tag.printTag(t.getTag());

    }

    public void check() throws IOException, LexicalException, SyntaxException {
        debug(SyntaxAnalyser.currentToken());
        while (SyntaxAnalyser.currentToken().getTag() == Tag.NEW_LINE)
            SyntaxAnalyser.nextToken();
        this.rule();
    }

    public abstract void rule() throws IOException, LexicalException, SyntaxException;
}