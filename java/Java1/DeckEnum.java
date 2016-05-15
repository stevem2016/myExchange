package edu.acc.java;

import java.util.Random;

/**
 * 1) Implement a Deck class with an array of 52 unique PlayingCard instances 
 * 2) Write a PlayingCard[] deal(int numCardsInHand) method taking random cards from deck
 *    Note: make sure you don't return same card twice
 * 3) Write a main() to test
 * 
 * @author pi
 *
 */

public class DeckEnum {

	/* 
	 * Holds the deck of PlayingCard instances 
	 * TODO allocate the actual deck array object here or in constructor 
	 */
	PlayingCardEnum[] deck = new PlayingCardEnum[52];  
	
	/* 
	 * Default ("no arg") constructor to build the deck
	 */
	public DeckEnum() {
		/* 
		 * TODO allocate the deck array object if not done above
		 * TODO initialize array index variable to zero
		 * TODO use nested for statement to loop over all the suits and ranks
		 *      inserting new PlayingCard instances into deck. Increment index after
		 *      each insert
		 */
		int index = 0;
		for (SUITS suit : SUITS.values()) {
			for (RANKS rank : RANKS.values()) {
				deck[index] = new PlayingCardEnum(suit, rank);
				index++;
			}
		}
	}
		
	public PlayingCardEnum[] deal(int numCardsInHand) {
		/* TODO create a new PlayingCard[] hand of the requested size 
		 * TODO create a source of random numbers using Random class (read API)
		 * TODO loop over hand array until full: 
		 *      generate a new random number to select a card from deck array
		 *      put the deck[index] card into a variable called candidate
		 *      compare candidate to each card in hand -- if no match, add to hand
		 *      if match, get another candidate and retry
		 */
		PlayingCardEnum[] hand = new PlayingCardEnum[numCardsInHand];
		Random rand = new Random();
		
			PlayingCardEnum candidate = null;
		    int i = 0;
		    
			do {
			    int my_rand = rand.nextInt(deck.length);
			    candidate = deck[my_rand];
			    if (!isInHand(hand, candidate)) {
			        hand[i++] = candidate;
			    }
			}
			while (i < numCardsInHand) ;
			
		
		return hand; // TODO return the hand array
	}
	
	/**
	 * Checks for card in hand
	 * 
	 * @param hand
	 * @param candidate
	 * @return true if found, else false
	 */
	private boolean isInHand(PlayingCardEnum[] hand, PlayingCardEnum candidate) {
		for (PlayingCardEnum card : hand) {
			if (card == candidate) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		/*
		 * TODO create an instance of DeckTemplate
		 * TODO print the entire deck
		 * TODO test the deal() method a few times and print the hands
		 */
		DeckEnum gooddeck = new DeckEnum();
		gooddeck.printDeck(gooddeck.deck);
		gooddeck.printDeck(gooddeck.deal(5));
		gooddeck.printDeck(gooddeck.deal(7));

	}

	private void printDeck(PlayingCardEnum[] array) {
		System.out.println();
		for (PlayingCardEnum card : array) {
			System.out.println(card);
		}
	}

}
