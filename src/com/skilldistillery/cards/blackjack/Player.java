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
		List<Card> playerCards = playerHand.getHandOfCards();
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
		return "Player: " + sb.toString() + "\nPlayer hand value: " + playerHand.getHandValue();
	}

	public int getHandValue() {
		return playerHand.getHandValue();
	}

	public boolean checkBlackjackHand() {
		return playerHand.checkBlackjackHand();
//		boolean ace = false;
//		boolean value10 = false;
//		for (int i = 0; i < playerHand.getHandOfCards().size(); i++) {
//			if (playerHand.getHandOfCards().get(i).toString().contains("Ace")) {
//				ace = true;				
//			}
//			if (playerHand.getHandOfCards().get(i).getValue() == 10) {
//				value10 = true;				
//			}
//		}
//		if (ace && value10) {
//		return true;
//		}
//		return false;
	}

}
