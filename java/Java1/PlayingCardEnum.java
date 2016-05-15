package edu.acc.java;

import java.util.Random;

public class PlayingCardEnum  {
	
    private SUITS suit;
    private RANKS rank;
    
    public PlayingCardEnum() {
    // no rank or suit given so randomize a card
	Random rand = new Random();
	SUITS[] suits = SUITS.values();
	this.suit = suits[rand.nextInt(suits.length)];
	RANKS[] ranks = RANKS.values();
	this.rank = ranks[rand.nextInt(ranks.length)];
    }
    
    public PlayingCardEnum(SUITS suit, RANKS rank) {
    	this.suit = suit;
    	this.rank = rank;
    }
    
    public static void main(String[] args) {
    	PlayingCardEnum card1 = new PlayingCardEnum();  // request a random PlayingCard
    	System.out.println(card1);
    	PlayingCardEnum card2 = new PlayingCardEnum(SUITS.SPADES, RANKS.ACE);  // request a specific PlayingCard
    	System.out.println(card2);
    }

    /* (non-Javadoc)
	 * @see edu.acc.java.PlayingCardIF#toString()
	 */
	@Override
    public String toString() {
    	return this.rank + " of " + this.suit;
    }

	public SUITS getSuit() {
		return suit;
	}

	public void setSuit(SUITS suit) {
		this.suit = suit;
	}

	public RANKS getRank() {
		return rank;
	}

	public void setRank(RANKS rank) {
		this.rank = rank;
	}

    
}
