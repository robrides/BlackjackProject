package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer {

	private Deck deck;
	private BlackjackHand dealerHand;

	public Dealer() {
		buildDealer();
	}

	private void buildDealer() {
		deck = new Deck();
		dealerHand = new BlackjackHand();
	}

	public void dealFirstHand(Player player) {
		dealerHand.clearHand();
		player.clearHand();
		System.out.println();
		player.addCard(deck.dealCard());
		System.out.println(player.toString());
		dealerHand.addCard(deck.dealCard());
		System.out.println(printDealerHand());
		player.addCard(deck.dealCard());
		System.out.println(player.toString());
		dealerHand.addCard(deck.dealCard());
		System.out.println(printDealerHand());
		System.out.println();
	}

	public String printDeck() {
		return deck.toString();
	}

	@Override
	public String toString() {
		return "\nDealer hand...\n" + "Dealer: " + dealerHand.toString() + "\nDealer hand value: "
				+ dealerHand.getHandValue();
	}

	public int getHandValue() {
		return dealerHand.getHandValue();
	}

	public void addCard(Card card) {
		dealerHand.addCard(card);
	}

	public void addCardToPlayer(Player player) {
		if (deck.checkDeckSize() < 15) {
			deck = new Deck();
		}
		player.addCard(deck.dealCard());
	}

	public void dealCardToDealer() {
		if (deck.checkDeckSize() < 15) {
			deck = new Deck();
		}
		dealerHand.addCard(deck.dealCard());
		System.out.println("\nCard dealt to dealer...");
		toString();
	}

	public String printDealerHand() {
		StringBuilder sb = new StringBuilder();
		List<Card> dealerCards = dealerHand.handList();
		for (int i = 0; i < dealerCards.size(); i++) {
			if (i == 0) {
				sb.append("**************");
			} else if (i < dealerCards.size() - 1) {
				sb.append(" | " + dealerCards.get(i));
			} else {
				sb.append(" | " + dealerCards.get(i));
			}
			if ((i + 1) % 3 == 0 && i < dealerCards.size() - 1) {
				sb.append("\n");
			}

		}
		return "Dealer: " + sb.toString();
	}

}
