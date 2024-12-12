package it.unibo.es2;

import java.util.*;

public class LogicsImpl implements Logics {
	private List<List<Character>> values = new ArrayList<>();

	public LogicsImpl(int size){
		for(int i = 0; i < size; i++){
			final List<Character> row = new ArrayList<>(); 
			this.values.add(row);
			for(int j = 0; j < size; j++){
				row.add(' ');
			}
		}
	}

	public String hit(int row, int column){
		if(values.get(row).get(column) == ' '){
			values.get(row).set(column, '*');
		}
		else values.get(row).set(column, ' ');

		return String.valueOf(values.get(row).get(column));
	}

	private boolean checkRows(){
		for (List<Character> list : values) {
			if(list.stream().allMatch(c -> c == '*')){
				return true;
			}
		}

		return false;
	}

	private boolean checkColumns(){
		for (int i = 0; i < this.values.get(0).size(); i++) { 
			final int columnIndex = i;
			if (values.stream()
					  .map(row -> row.get(columnIndex))
					  .allMatch(c -> c == '*')) { 
				return true;
			}
		}
		return false;
	}

	public boolean toQuit(){
		return checkRows() || checkColumns();
	}

}
