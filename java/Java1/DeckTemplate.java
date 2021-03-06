package edu.acc.java;

/**
 * 1) Implement a Deck class with an array of 52 unique PlayingCard instances 
 * 2) Write a PlayingCard[] deal(int numCardsInHand) method taking random cards from deck
 *    Note: make sure you don't return same card twice
 * 3) Write a main() to test
 * 
 * @author pi
 *
 */

public class DeckTemplate {

	/* 
	 * Holds the deck of PlayingCard instances 
	 * TODO allocate the actual deck array object here or in constructor 
	 */
	PlayingCard[] deck;  
	
	/* 
	 * Default ("no arg") constructor to build the deck
	 */
	public DeckTemplate() {
		/* 
		 * TODO allocate the deck array object if not done above
		 * TODO initialize array index variable to zero
		 * TODO use nested for statement to loop over all the suits and ranks
		 *      inserting new PlayingCard instances into deck. Increment index after
		 *      each insert
		 */
	}
		
	public PlayingCard[] deal(int numCardsInHand) {
		/* TODO create a new PlayingCard[] hand of the requested size 
		 * TODO create a source of random numbers using Random class (read API)
		 * TODO loop over hand array until full: 
		 *      generate a new random number to select a card from deck array
		 *      put the deck[index] card into a variable called candidate
		 *      compare candidate to each card in hand -- if no match, add to hand
		 *      if match, get another candidate and retry
		 */
		return null; // TODO return the hand array
	}
	
	public static void main(String[] args) {
		/*
		 * TODO create an instance of DeckTemplate
		 * TODO print the entire deck
		 * TODO test the deal() method a few times and print the hands
		 */

	}

}
