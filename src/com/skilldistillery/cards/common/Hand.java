package com.skilldistillery.cards.common;

import java.util.List;

public abstract class Hand {
	
	public List<Card> hand;

	public abstract int getHandValue();

	public abstract void addCard (Card card);
	
	public abstract void clearHand();

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	
}
