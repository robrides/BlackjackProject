package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;

	public Deck() {
		cards = createDeck();
		Collections.shuffle(cards);
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for(Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				StringBuilder sb = new StringBuilder();
				if (suits.getName().compareTo("HEART") == 0) {
					sb.append((char)'\u2664');
				}
				if (suits.getName().compareTo("CLUB") == 0) {
					sb.append((char)'\u2663');
				}
				if (suits.getName().compareTo("DIAMOND") == 0) {
					sb.append((char)'\u2666');
				}
				if (suits.getName().compareTo("SPADE") == 0) {
					sb.append((char)'\u2660');
				}
				deck.add(new Card(suits, ranks, sb.toString()));
			}
		}
		return deck;
	}
	
	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}
	
	
}
