package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {

	final List<Button> buttons;

	public LogicsImpl(int size) {
		buttons = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			buttons.add(new Button());
		}
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
		return String.join("|", values().stream()
        	.map(String::valueOf)
        	.toList());
	}

	@Override
	public boolean toQuit() {	
		return values().stream()
			.allMatch(v -> v == values().get(0));
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
			if(this.value == LogicsImpl.this.size()){
				this.state = false;
			}
		}
	}
}
