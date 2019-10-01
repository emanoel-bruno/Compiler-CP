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
}