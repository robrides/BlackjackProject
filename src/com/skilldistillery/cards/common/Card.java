package com.skilldistillery.cards.common;

public class Card {

	private Suit suit;
	private Rank rank;
	private String suitImg;
	
	Card(Suit suit, Rank rank, String suitImg) {
		this.suit = suit;
		this.rank = rank;
		this.suitImg = suitImg;
		
	}

	@Override
	public String toString() {
		return rank + " of " + suit + " " + suitImg;
	}

	public int getValue() {
		return rank.getValue();
	}

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
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
}
