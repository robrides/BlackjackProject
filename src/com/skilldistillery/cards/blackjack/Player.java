package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {

//	private List<Card> playerCards;
	private BlackjackHand playerHand;

	public Player() {
		buildPlayer();
	}
	
	private void buildPlayer() {
		playerHand = new BlackjackHand();
		
	}
	
	public void addCard(Card card) {
		playerHand.addCard(card);
	}
	
	public void clearHand() {
		playerHand.clearHand();
	}

	@Override
	public String toString() {
		return "Player hand: " + playerHand;
	}
	
	public int getHandValue() {
		return playerHand.getHandValue();
	}	
	
}
