package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand implements Hand {

	private List<Card> handPlayer;

	public BlackjackHand() {
		handPlayer = new ArrayList<>();
	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : handPlayer) {
			value += card.getValue();
		}
		return value;
	}

	@Override
	public void clearHand() {
		handPlayer.clear();
	}

	@Override
	public List<Card> getHandOfCards() {
		return handPlayer;
	}

	@Override
	public String toString() {
		return "Player card: " + handPlayer;
	}


	@Override
	public void addCard(Card card) {
		handPlayer.add(card);
	}

}
