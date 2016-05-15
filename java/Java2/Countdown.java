package edu.acc.java;
/**
 * Implemented by CountdownImpl 
 * 
 * @author pi
 *
 */

public interface Countdown {
	static final int count = 10;
	
	/**
	 * Prints a countdown on console starting with the given count,
	 *   then returns "liftoff!" 
	 * @param count is where the countdown starts
	 * @return is "liftoff!" when countdown completes
	 */
	String liftoff(int count);

}
