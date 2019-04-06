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
		System.out.println(toString());
		player.addCard(deck.dealCard());
		System.out.println(player.toString());
		dealerHand.addCard(deck.dealCard());
		System.out.println(toString());
		System.out.println();
	}

	public void printDeck() {
		System.out.println(deck.toString());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<Card> dealerCards = dealerHand.handList();
		for (int i = 0; i < dealerCards.size(); i++) {
			if (i == 0) {
				sb.append("****** ");
			} else {
				sb.append(dealerCards.get(i) + " ");
			}
			
		}
		return "Dealer: " + sb.toString();
	}

	public int getHandValue() {
		return dealerHand.getHandValue();
	}

	public void addCard(Card card) {
		dealerHand.addCard(card);
	}

	public void addCardToPlayer(Player player) {
		player.addCard(deck.dealCard());
	}

	public void dealCardToDealer() {
		dealerHand.addCard(deck.dealCard());
		System.out.println("\nCard dealt to dealer...");
		toString();
	}

	public void printDealerHand() {
		System.out.println("\nDeler hand...");
		System.out.println("Dealer: " + dealerHand.toString() + "\nDealer hand value: " + dealerHand.getHandValue());
	}

}
