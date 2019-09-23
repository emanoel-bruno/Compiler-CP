package compiler;

import java.util.Hashtable;
import compiler.Token;
import tokens.*;

public class SymbolTable{
    
    private Hashtable<String, Token> table;

    public SymbolTable(){
        this.table = new Hashtable<>();
    }

    private String printToken(Token t){
       String s = "Class not Found: " + t.getTag();
        if (t instanceof AndToken) {
            s = ((AndToken) t).getValue();
        } else if (t instanceof AssignToken) {
            s = ((AssignToken) t).getValue();
        } else if (t instanceof BiggerEqualToken) {
            s = ((BiggerEqualToken) t).getValue();
        } else if (t instanceof BiggerToken) {
            s = ((BiggerToken) t).getValue();
        } else if (t instanceof CaractereToken) {
            s = ((CaractereToken) t).getValue();
        } else if (t instanceof CloseParenthesisToken) {
            s = ((CloseParenthesisToken) t).getValue();
        } else if (t instanceof CommaToken) {
            s = ((CommaToken) t).getValue();
        } else if (t instanceof DividerToken) {
            s = ((DividerToken) t).getValue();
        } else if (t instanceof DoToken) {
            s = ((DoToken) t).getValue();
        } else if (t instanceof DotToken) {
            s = ((DotToken) t).getValue();
        } else if (t instanceof DoubleArrowToken) {
            s = ((DoubleArrowToken) t).getValue();
        } else if (t instanceof ElseToken) {
            s = ((ElseToken) t).getValue();
        } else if (t instanceof EndToken) {
            s = ((EndToken) t).getValue();
        } else if (t instanceof EqualToken) {
            s = ((EqualToken) t).getValue();
        } else if (t instanceof ExitToken) {
            s = ((ExitToken) t).getValue();
        } else if (t instanceof FloatConstantToken) {
            s = "" + ((FloatConstantToken) t).getValue();
        } else if (t instanceof FloatToken) {
            s = ((FloatToken) t).getValue();
        } else if (t instanceof IdentifierToken) {
            s = ((IdentifierToken) t).getValue();
        } else if (t instanceof IfToken) {
            s = ((IfToken) t).getValue();
        } else if (t instanceof IntegerConstantToken) {
            s = "" + ((IntegerConstantToken) t).getValue();
        } else if (t instanceof IntToken) {
            s = ((IntToken) t).getValue();
        } else if (t instanceof LiteralToken) {
            s = ((LiteralToken) t).toString();
        } else if (t instanceof MinusToken) {
            s = ((MinusToken) t).getValue();
        } else if (t instanceof NotToken) {
            s = ((NotToken) t).getValue();
        } else if (t instanceof OpenParenthesisToken) {
            s = ((OpenParenthesisToken) t).getValue();
        } else if (t instanceof OrToken) {
            s = ((OrToken) t).getValue();
        } else if (t instanceof PlusToken) {
            s = ((PlusToken) t).getValue();
        } else if (t instanceof PrintToken) {
            s = ((PrintToken) t).getValue();
        } else if (t instanceof QuotationMarkToken) {
            s = ((QuotationMarkToken) t).getValue();
        } else if (t instanceof ScanToken) {
            s = ((ScanToken) t).getValue();
        } else if (t instanceof SemiColonToken) {
            s = ((SemiColonToken) t).getValue();
        } else if (t instanceof SmallerEqualToken) {
            s = ((SmallerEqualToken) t).getValue();
        } else if (t instanceof SmallerToken) {
            s = ((SmallerToken) t).getValue();
        } else if (t instanceof StartToken) {
            s = ((StartToken) t).getValue();
        } else if (t instanceof StringToken) {
            s = ((StringToken) t).getValue();
        } else if (t instanceof ThenToken) {
            s = ((ThenToken) t).getValue();
        } else if (t instanceof TimesToken) {
            s = ((TimesToken) t).getValue();
        } else if (t instanceof WhileToken) {
            s = ((WhileToken) t).getValue();
        }
        return s;
    }

    public void insertToken(Token t){
        System.out.println(this.printToken(t));
        this.table.put(String.valueOf(t.getTag()), t);
    }

    public void clear(){
        this.table.clear();
    }
}