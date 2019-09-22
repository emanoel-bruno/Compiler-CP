package compiler;

import java.util.Hashtable;
import compiler.Token;

public class SymbolTable{
    
    private Hashtable<String, Token> table;

    public SymbolTable(){
        this.table = new Hashtable<>();
    }

    public void insertToken(Token t){
        this.table.put(t.getValue(), t);
    }

    public void clear(){
        this.table.clear();
    }
}