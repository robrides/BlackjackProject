package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHandDealer implements Hand {

	private List<Card> handDealer;
//	Deck deck = new Deck();

	public BlackjackHandDealer() {
		handDealer = new ArrayList<>();
		//		createHand();
	}

//	@Override
//	public List<Card> createHand() {
//		handDealer = new ArrayList<>();
//		for (int i = 0; i < 2; i++) {
//			handDealer.add(deck.dealCard());
//		}
//		return handDealer;
//	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : handDealer) {
			value += card.getValue();
		}
		return value;
	}

	@Override
	public void clearHand() {
		handDealer.clear();
	}

	@Override
	public List<Card> getHandOfCards() {
		return handDealer;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < handDealer.size(); i++) {
			if (i == 0) {
			sb.append("***Face Down***, ");
			} else {
			sb.append(handDealer.get(i));
			}
		}
		
		return "Dealer card: " + sb.toString();
	}


	@Override
	public void addCard(Card card) {
		handDealer.add(card);
	}

}
