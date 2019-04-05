package com.skilldistillery.cards.blackjack;


public class Player {

//	private List<Card> playerCards;
	private BlackjackHand playerHand;

	public Player() {
		buildPlayer();
	}
	
	private void buildPlayer() {
		playerHand = new BlackjackHand();
		
	}
}
