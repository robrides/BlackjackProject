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
		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				StringBuilder sb = new StringBuilder();
				if (suits == Suit.HEARTS) {
					sb.append((char) '\u2665');
				}
				if (suits == Suit.CLUBS) {
					sb.append((char) '\u2667');
				}
				if (suits == Suit.DIAMONDS) {
					sb.append((char) '\u2666');
				}
				if (suits == Suit.SPADES) {
					sb.append((char) '\u2664');
				}
				deck.add(new Card(suits, ranks, sb.toString()));
			}
		}
		return deck;
	}

	public int getDeckSize() {
		return cards.size();
	}
	
	public Card getCardFromDeck(int c) {
		return cards.get(c);
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cards.size(); i++) {
			if (i < cards.size() - 1) {
				sb.append("" + (i + 1) + ": " + cards.get(i) + "\t");
			} else {
				sb.append("" + (i + 1) + ": " + cards.get(i) + "\n");
			}
			if ((i + 1) % 3 == 0) {
				sb.append("\n");
			}
		}
		return "\nFull Deck\n" + sb.toString();
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
