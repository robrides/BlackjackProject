package com.skilldistillery.cards.blackjack;

import java.util.List;
import com.skilldistillery.cards.common.Card;

public class Dealer {

	private BlackjackHand dealerHand;
	private Shoe shoe;
	private int numDecks;

	public Dealer(int numDecks) {
		this.numDecks = numDecks;
		buildDealer(numDecks);
	}

	private void buildDealer(int numDecks) {
		shoe = new Shoe(numDecks);
		dealerHand = new BlackjackHand();
	}

	public void dealFirstHand(Player player) throws InterruptedException {
		if (shoe.getAllCardsSize() < 15) {
			shoe = new Shoe(numDecks);
		}
		dealerHand.clearHand();
		player.clearHand();
		System.out.println();
		player.addCard(shoe.dealCardFromShoe());
		System.out.println(player.toString());
		Thread.sleep(500);
		dealerHand.addCard(shoe.dealCardFromShoe());
		System.out.println(printDealerHand());
		Thread.sleep(500);
		player.addCard(shoe.dealCardFromShoe());
		System.out.println(player.toString());
		Thread.sleep(500);
		dealerHand.addCard(shoe.dealCardFromShoe());
		System.out.println(printDealerHand());
		Thread.sleep(500);
		System.out.println();
	}

	public String printShoeDeck() {
		return shoe.toString();
	}

	public String printShoeCards() {
		return shoe.printAllCards();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<Card> dealerCards = dealerHand.getHandOfCards();
		for (int i = 0; i < dealerCards.size(); i++) {
			if (i == 0) {
				sb.append(dealerCards.get(i));
			} else if (i < dealerCards.size() - 1) {
				sb.append(" | " + dealerCards.get(i));
			} else {
				sb.append(" | " + dealerCards.get(i));
			}
			if ((i + 1) % 3 == 0 && i < dealerCards.size() - 1) {
				sb.append("\n");
			}
		}
		return "Dealer: " + sb.toString() + "\nDealer hand value: " + dealerHand.getHandValue();

	}
	
	public String printDealerHand() {
		StringBuilder sb = new StringBuilder();
		List<Card> dealerCards = dealerHand.getHandOfCards();
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
		return "Dealer: " + sb.toString() + "\nDealer hand value: ??";
	}

	public int getHandValue() {
		return dealerHand.getHandValue();
	}

	public void addCard(Card card) {
		dealerHand.addCard(card);
	}

	public void addCardToPlayer(Player player) {
		if (shoe.getAllCardsSize() < 15) {
			shoe = new Shoe(numDecks);
			System.out.println("\nNew shoe initialized.\n");
		}
		player.addCard(shoe.dealCardFromShoe());
	}

	public void dealCardToDealer() throws InterruptedException {
		if (shoe.getAllCardsSize() < 15) {
			shoe = new Shoe(numDecks);
			System.out.println("\nNew shoe initialized.\n");
		}
		dealerHand.addCard(shoe.dealCardFromShoe());
		System.out.println("\nCard dealt to dealer...");
		Thread.sleep(500);
		System.out.println(toString());
	}

	public List<Card> getHandOfCards() {
		return dealerHand.getHandOfCards();
	}

	public boolean checkBlackjackHand() {
		return dealerHand.checkBlackjackHand();
	}

}
