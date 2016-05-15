package edu.acc.java;

import java.util.Random;

public class PlayingCardGeneric<S, R>  {
	
    private S suit;
    private R rank;
    
    // constructor to make a random PlayingCard
    public PlayingCardGeneric(S[] suits, R[] ranks) {
	Random rand = new Random();
	this.suit = suits[rand.nextInt(suits.length)];
	this.rank = ranks[rand.nextInt(ranks.length)];
    }
    
    // constructor to make a specific PlayingCard
    public PlayingCardGeneric(S suit, R rank) {
    	this.suit = suit;
    	this.rank = rank;
    }
    
    @Override
	public boolean equals(Object obj) {
    	// check if obj is null
    	if (obj == null) 
    		return false;
    	// check if obj is an instance of PlayingCard
    	if (!(obj instanceof PlayingCardGeneric))
    		return false;
    	PlayingCardGeneric temp = (PlayingCardGeneric) obj;
    	// check if obj suit same as this suit
    	if (!temp.suit.equals(this.suit))
    		return false;
    	// check if obj rank same as this rank
    	if (!temp.rank.equals(this.rank))
    		return false;
		return true;
	}

	@Override
    public String toString() {
    	return this.rank + " of " + this.suit;
    }

	public S getSuit() {
		return suit;
	}

	public void setSuit(S suit) {
		this.suit = suit;
	}

	public R getRank() {
		return rank;
	}

	public void setRank(R rank) {
		this.rank = rank;
	}

    public static void main(String[] args) {
    	// Note: cannot run values() on generic enum so run outside of PlayingCard
    	// create a random PlayingCard
    	PlayingCardGeneric<SUITS,RANKS> card1 = 
    			new PlayingCardGeneric<>(SUITS.values(), RANKS.values());
    	System.out.println(card1);

    	// create a specific PlayingCard
    	PlayingCardGeneric<SUITS,RANKS> card2 = new PlayingCardGeneric<>(SUITS.SPADES, RANKS.ACE);  // request a specific PlayingCard
    	PlayingCardGeneric<SUITS,RANKS> aceOfSpades = new PlayingCardGeneric<>(SUITS.SPADES, RANKS.ACE);  // request a specific PlayingCard
    	System.out.println("Is card2 == Ace of Spades? " + card2.equals(aceOfSpades));
    	System.out.println("Is card1 == Ace of Spades? " + card1.equals(aceOfSpades));
    }
    
}
