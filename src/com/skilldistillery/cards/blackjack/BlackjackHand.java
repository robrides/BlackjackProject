package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
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
		List<Card> playerHand = new ArrayList<>();
		playerHand = handPlayer;
		return playerHand;
	}

	@Override
	public String toString() {
		return "Hand: " + handPlayer;
	}

	@Override
	public void addCard(Card card) {
		handPlayer.add(card);
	}

}
