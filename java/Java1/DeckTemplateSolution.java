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

public class DeckTemplateSolution {

	/* 
	 * Holds the deck of PlayingCard instances 
	 * TODO allocate the actual deck array object here or in constructor 
	 */
	PlayingCard[] deck = new PlayingCard[52];  
	
	/* 
	 * Default ("no arg") constructor to build the deck
	 */
	public DeckTemplateSolution() {
		/* 
		 * TODO allocate the deck array object if not done above
		 * TODO initialize array index variable to zero
		 * TODO use nested for statement to loop over all the suits and ranks
		 *      inserting new PlayingCard instances into deck. Increment index after
		 *      each insert
		 */
		int index = 0;
		for (String suit : PlayingCard.suits) {
			for (String rank : PlayingCard.ranks) {
				deck[index] = new PlayingCard(suit, rank);
				index++;
			}
		}
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
		PlayingCard[] hand = new PlayingCard[numCardsInHand];
		Random rand = new Random();
		
			PlayingCard candidate = null;
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
	private boolean isInHand(PlayingCard[] hand, PlayingCard candidate) {
		for (PlayingCard card : hand) {
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
		DeckTemplateSolution gooddeck = new DeckTemplateSolution();
		gooddeck.printDeck(gooddeck.deck);
		gooddeck.printDeck(gooddeck.deal(5));
		gooddeck.printDeck(gooddeck.deal(7));

	}

	private void printDeck(PlayingCard[] array) {
		System.out.println();
		for (PlayingCard card : array) {
			System.out.println(card);
		}
	}

}
