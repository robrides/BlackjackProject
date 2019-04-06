package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

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
		this.dealerHand.clearHand();
		player.clearHand();
		System.out.println();
		player.addCard(deck.dealCard());
		System.out.println(player.toString());
		this.dealerHand.addCard(deck.dealCard());
		System.out.println(dealerHand.toString());
		player.addCard(deck.dealCard());
		System.out.println(player.toString());
		this.dealerHand.addCard(deck.dealCard());
		System.out.println(dealerHand.toString());
		System.out.println();
	}

	public void printDeck() {
		System.out.println(deck.toString());	
	}
	
	@Override
	public String toString() {
		return "Dealer hand: " + dealerHand;
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
		while (getHandValue() < 17) {
			dealerHand.addCard(deck.dealCard());
			System.out.println("\nCard dealt to dealer\n" + toString());
		}
		System.out.println("Dealer stands at 17\n");
	}
	
}
