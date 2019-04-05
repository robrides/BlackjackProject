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
		dealFirstHand();		
	}
	
	private void dealFirstHand() {
		dealerHand.clearHand();
		//playerHand.clearHand();
		System.out.println();
		//playerHand.addCard(deck.dealCard());
		//System.out.println(playerHand.toString());
		dealerHand.addCard(deck.dealCard());
		System.out.println(dealerHand.toString());
		//playerHand.addCard(deck.dealCard());
		//System.out.println(playerHand.toString());
		dealerHand.addCard(deck.dealCard());
		System.out.println(dealerHand.toString());
		System.out.println();
		
	}
	
}
