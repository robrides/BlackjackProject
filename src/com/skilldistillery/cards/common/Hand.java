package com.skilldistillery.cards.common;

import java.util.List;

public interface Hand {

	abstract int getHandValue();

	abstract void addCard (Card card);
	
	abstract void clearHand();

	abstract List<Card> getHandOfCards();
	
	
}
