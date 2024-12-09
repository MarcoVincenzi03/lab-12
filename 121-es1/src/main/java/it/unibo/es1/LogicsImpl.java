package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {

	final List<Button> buttons;

	public LogicsImpl(int size) {
		buttons = new ArrayList<>(size);
		buttons.stream()
			.forEach(b -> b = new Button());
	}

	@Override
	public int size() {
		return buttons.size();
	}

	@Override
	public List<Integer> values() {
		return buttons.stream()
			.map(Button::getValue)
			.toList();
	}

	@Override
	public List<Boolean> enablings() {
		return buttons.stream()
			.map(Button::getState)
			.toList();
	}

	@Override
	public int hit(int elem) {
		if(buttons.get(elem).getState()){
			buttons.get(elem).Increase();
		}
		return buttons.get(elem).getValue();
	}

	@Override
	public String result() {
		String results = "";

		for (Integer value : values()) {
			results = results + value + "|";
		}

		return results.substring(0, results.length() -2);
	}

	@Override
	public boolean toQuit() {	
		return values().stream()
			.allMatch(v -> v == values().getFirst());
	}

	private final class Button{
		private int value;
		private boolean state;

		Button(){
			this.value = 0;
			this.state = true;
		}

		public int getValue(){
			return value;
		}

		public boolean getState(){
			return state;
		}

		public void Increase(){
			this.value++;
		}
	}
}
