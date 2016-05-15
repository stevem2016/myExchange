package edu.acc.java;

import java.util.List;
import java.util.Random;

public interface DeckIF {

	/**
	 * Shuffles the given deck of cards
	 * 
	 * @param deck is the PlayingCard[] to shuffle
	 */
	default public void shuffle(List<PlayingCard> deck) {

		Random rand = new Random();
		for (int i=0; i < 1000; i++) {
			int r1 = rand.nextInt(deck.size());
			int r2 = rand.nextInt(deck.size());
			PlayingCard temp = deck.get(r1);
			deck.set(r1, deck.get(r2));
			deck.set(r2, temp);
		}
	}

	/**
	 * Returns an array of given length containing a random hand of PlayingCard
	 * instances
	 * 
	 * @param numCards is size of hand
	 * @return is PlayingCard[] containing the random hand
	 */

	public PlayingCard[] deal(int numCards);

}
