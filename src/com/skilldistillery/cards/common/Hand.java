package com.skilldistillery.cards.common;

import java.util.List;

public interface Hand {

//	abstract List<Card> createHand();
	
	abstract int getHandValue();

	public void addCard (Card card);
	
	abstract void clearHand();

	public List<Card> getHandOfCards();
	
}
