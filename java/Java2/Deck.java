package edu.acc.java;

import java.util.ArrayList;
import java.util.List;

public class Deck implements DeckIF {

	List<PlayingCard> deck = new ArrayList<>(); // notice no length since not an array

	public Deck() { 
		// add all the PlayingCard instances to List == 52
		for (SUITS suit : SUITS.values()) {
			for (RANKS rank : RANKS.values()) {
				deck.add(new PlayingCard(suit, rank));
			}
		}
	}

	/**
	 * Returns an array of given length containing a random hand of PlayingCard
	 * instances
	 * 
	 * @param numCards
	 *            is size of hand
	 * @return is PlayingCard[] containing the random hand
	 */

	public PlayingCard[] deal(int numCards) {
		PlayingCard[] hand = new PlayingCard[numCards];
		shuffle(deck);
		for (int i = 0; i < hand.length; i++) {
			// move a card from deck to hand
			hand[i] = deck.get(i);
		}
		return hand;
	}

	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d.deck);
		d.shuffle(d.deck);
		System.out.println(d.deck);
	}

}
