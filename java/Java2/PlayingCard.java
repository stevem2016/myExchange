package edu.acc.java;

import java.util.Random;

public class PlayingCard  {
	
    private SUITS suit;
    private RANKS rank;
    
    // constructor for a random PlayingCard
    public PlayingCard() {
	Random rand = new Random();
	SUITS[] suits = SUITS.values();
	this.suit = suits[rand.nextInt(suits.length)];
	RANKS[] ranks = RANKS.values();
	this.rank = ranks[rand.nextInt(ranks.length)];
    }
    
    // constructor for a specific PlayingCard
    public PlayingCard(SUITS suit, RANKS rank) {
    	this.suit = suit;
    	this.rank = rank;
    }
    
//    @Override
//	public boolean equals(Object obj) {
//    	// check if obj is null
//    	if (obj == null) 
//    		return false;
//    	// check if obj is an instance of PlayingCard
//    	if (!(obj instanceof PlayingCard))
//    		return false;
//    	PlayingCard temp = (PlayingCard) obj;
//    	// check if obj suit same as this suit
//    	if (!temp.suit.equals(this.suit))
//    		return false;
//    	// check if obj rank same as this rank
//    	if (!temp.rank.equals(this.rank))
//    		return false;
//		return true;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PlayingCard))
			return false;
		PlayingCard other = (PlayingCard) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

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

    public static void main(String[] args) {
    	PlayingCard card1 = new PlayingCard();  
    	System.out.println(card1);

    	PlayingCard card2 = new PlayingCard(SUITS.SPADES, RANKS.ACE);  
    	PlayingCard aceOfSpades = new PlayingCard(SUITS.SPADES, RANKS.ACE);  
    	System.out.println("Is card2 == Ace of Spades? " + card2.equals(aceOfSpades));
    	System.out.println("Is card1 == Ace of Spades? " + card1.equals(aceOfSpades));
    }
    
}
