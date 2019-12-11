package compiler;

import java.util.Hashtable;
import tokens.IdentifierToken;

public class SymbolTable {

    private Hashtable<String, IdentifierToken> table;

    public SymbolTable() {
        this.table = new Hashtable<>();
    }

    public boolean insertToken(IdentifierToken id) {
        if (this.table.containsKey(String.valueOf(id.toString())))
            return false;
        this.table.put(String.valueOf(id.toString()), id);
        return true;
    }

    public boolean hasToken(IdentifierToken id) {
        return !this.table.containsKey(String.valueOf(id.toString()));
    }

    public void updateToken(IdentifierToken id){
        this.table.replace(String.valueOf(id.toString()), this.table.get(String.valueOf(id.toString())), id);
    }

    public IdentifierToken getToken(IdentifierToken id){
        return this.table.get(String.valueOf(id.toString()));
    }
}