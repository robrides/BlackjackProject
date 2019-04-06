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
		List<Card> playerCards = playerHand.handList();
		for (int i = 0; i < playerCards.size(); i++) {
			if (i == 0) {
				sb.append(playerCards.get(i));
			} else if (i < playerCards.size() - 1) {
				sb.append(" | " + playerCards.get(i));
			} else {
				sb.append(" | " + playerCards.get(i));
			}
			if ((i + 1) % 3 == 0 && i < playerCards.size() - 1) {
				sb.append("\n");
			}
		}
		return "Player: " + sb.toString();
	}

	public int getHandValue() {
		return playerHand.getHandValue();
	}

}
