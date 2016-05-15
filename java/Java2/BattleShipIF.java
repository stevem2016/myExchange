package edu.acc.java;

/**
 * One possible interface for a BattleShip lab solution
 * 
 * @author pi
 *
 */
public interface BattleShipIF {

	/**
	 * Places the given number of random length ships at random positions on
	 * board
	 * 
	 * @param shipCount
	 *            is number of ships to place
	 */
	void positionShips(int shipCount);

	/**
	 * Builds a ship on a given array at a given position
	 * 
	 * @param whichArray is the array to place ship on
	 * @param start is index of starting position for ship
	 * @param length is ship length (might need to be shortened)
	 */
	void makeShip(int whichArray, int start, int length);

	/**
	 * Checks if any ships not sunk
	 * 
	 * @return true if some ship elements still not sunk else false
	 */
	boolean isMoreFiringRequired();

	/**
	 * Checks if any ships in given array
	 * 
	 * @return true is any elements in y are true, else false
	 */
	boolean anyShips(int whichArray);

	/**
	 * Prints one array in the game board
	 * 
	 * @param array
	 */
	void printGameArray(boolean[] array);

	/**
	 * Prints entire game board
	 * 
	 */
	void printGameBoard();

	/**
	 * Checks given array for any true values
	 * 
	 * @param array
	 *            is array to check
	 * @return true is any true elements found, else false
	 */
	boolean scanForTrue(boolean[] array);

	/**
	 * "Fires" at given x,y coordinate on board 
	 * 
	 * @param x is index in the y array to fire on 
	 * @param y is the array number
	 * @return true if a hit, else false
	 */
	boolean fireAtCoordinate(int x, int y);

}