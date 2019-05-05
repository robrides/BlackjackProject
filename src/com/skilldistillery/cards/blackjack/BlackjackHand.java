package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	private List<Card> hand;

	public BlackjackHand() {
		hand = new ArrayList<>();
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}

	public void clearHand() {
		hand.clear();
	}

//	public List<Card> getHandOfCards() {
//		List<Card> playerHand = new ArrayList<>();
//		playerHand = hand;
//		return playerHand;
//	}

	@Override
	public List<Card> getHand() {
		List<Card> playerHand = new ArrayList<>();
		playerHand = super.getHand();
		return playerHand;
	}

	@Override
	public void setHand(List<Card> hand) {
		// TODO Auto-generated method stub
		super.setHand(hand);
	}

	@Override
	public String toString() {
		return "Hand: " + hand;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public boolean checkBlackjackHand() {
		boolean ace = false;
		boolean value10 = false;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).toString().contains("Ace")) {
				ace = true;				
			}
			if (hand.get(i).getValue() == 10) {
				value10 = true;				
			}
		}
		if (ace && value10) {
		return true;
		}
		return false;
	}
}
