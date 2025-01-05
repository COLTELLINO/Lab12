package it.unibo.es2;

public interface Logics {
	
	/**
	 * @return the new symbol a button should show after being pressed
	 */
	String hit(Pair<Integer,Integer> elem);
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}
