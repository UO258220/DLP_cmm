package symboltable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;

	public SymbolTable()  {
		this.table = new ArrayList<Map<String, Definition>>( );
		this.table.add(new HashMap<String, Definition>());
	}

	public void set() {
		this.table.add(new HashMap<String, Definition>());
		scope++;
	}
	
	public void reset() {
		this.table.remove(scope);
		scope--;
	}
	
	public boolean insert(Definition definition) {
		if (findInCurrentScope(definition.getName()) != null) {
			return false;
		}
		definition.setScope(scope);
		this.table.get(scope).put(definition.getName(), definition);
		return true;
	}
	
	public Definition find(String id) {
		Definition result;
		for (int i = this.table.size() - 1 ; i >= 0 ; i--) {
			result = this.table.get(i).get(id);
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		return this.table.get(scope).get(id);
	}

}
