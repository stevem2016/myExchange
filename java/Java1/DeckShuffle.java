package edu.acc.java;

import java.util.Random;

/**
 * 1) Implement a Deck class with an array of 52 unique PlayingCard instances 2)
 * Write a PlayingCard[] deal(int numCardsInHand) method taking random cards
 * from deck Note: make sure you don't return same card twice 3) Write a main()
 * to test
 * 
 * @author pi
 *
 */

public class DeckShuffle {

	/*
	 * Holds the deck of PlayingCard instances TODO allocate the actual deck
	 * array object here or in constructor
	 */
	PlayingCard[] deck = new PlayingCard[52];

	/*
	 * Default ("no arg") constructor to build the deck
	 */
	public DeckShuffle() {
		/*
		 * TODO allocate the deck array object if not done above TODO initialize
		 * array index variable to zero TODO use nested for statement to loop
		 * over all the suits and ranks inserting new PlayingCard instances into
		 * deck. Increment index after each insert
		 */
		int index = 0;
		for (String suit : PlayingCard.suits) {
			for (String rank : PlayingCard.ranks) {
				deck[index] = new PlayingCard(suit, rank);
				index++;
			}
		}
	}

	public void shuffle() {
		/*
		 * TODO get 2 random numbers TODO get a deck[rand1] and swap with
		 * deck[rand2] TODO repeat 7*deck size times (simulate 7 physical shuffles?
		 */

		Random rand = new Random();

		for (int i = 0; i < 7 * deck.length; i++) {
			int r1 = rand.nextInt(deck.length);
			int r2 = rand.nextInt(deck.length);
			PlayingCard temp = deck[r1];
			deck[r1] = deck[r2];
			deck[r2] = temp;
		}
	}

	public PlayingCard[] deal(int numCardsInHand) {
		/*
		 * TODO create a new PlayingCard[] hand of the requested size TODO use
		 * shuffle() to randomize deck TODO loop over hand array until full:
		 * pull top numCardsInHand cards from deck
		 */

		PlayingCard[] hand = new PlayingCard[numCardsInHand];
		shuffle();
		for (int i = 0; i < hand.length; i++) {
			hand[i] = deck[i];
		}
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
			if (card == candidate)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		/*
		 * TODO create an instance of DeckTemplate TODO print the entire deck
		 * TODO test the deal() method a few times and print the hands
		 */
		DeckShuffle gooddeck = new DeckShuffle();
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
