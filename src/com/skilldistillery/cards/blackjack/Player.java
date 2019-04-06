package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public class Player {

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
		StringBuilder sb = new StringBuilder();
		List<Card> dealerCards = playerHand.handList();
		for (int i = 0; i < dealerCards.size(); i++) {
				sb.append(dealerCards.get(i) + " ");
		}
		return "Player: " + sb.toString();
	}

	public int getHandValue() {
		return playerHand.getHandValue();
	}

}
