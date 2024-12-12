package it.unibo.es2;

public interface Logics {	
	/**
	 * @return the new value a button should show after being pressed
	 */
	String hit(int row, int column);
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}
