package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Shoe {

	private List<Deck> shoe;
	private List<Card> allCards;
	private int numOfDecks;

	public Shoe(int numOfDecks) {
		this.numOfDecks = numOfDecks;
		buildDecks();
	}

	private void buildDecks() {
		shoe = new ArrayList<>();
		allCards = new ArrayList<>();
		for (int i = 0; i < numOfDecks; i++) {
			shoe.add(new Deck());
			for (int j = 0; j < shoe.get(i).getDeckSize(); j++) {
				allCards.add(shoe.get(i).getCardFromDeck(j));
			}
		}
		Collections.shuffle(allCards);
	}

	public List<Card> getAllCards() {
		List<Card> allCardsCopy = new ArrayList<>();
		allCardsCopy.addAll(allCards);
		return allCardsCopy;
	}

	public Card dealCardFromShoe() {
		return allCards.remove(0);
	}

	public Card getCardFromShoe(int d) {
		return allCards.get(d);
	}

	public List<Deck> getDecks() {
		return shoe;
	}

	public int getNumOfDecks() {
		return numOfDecks;
	}

	public int getShoeSize() {
		return shoe.size();
	}

	public int getAllCardsSize() {
		return allCards.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < shoe.size(); i++) {
			for (int j = 0; j < shoe.get(i).getDeckSize(); j++) {
				if (j < shoe.get(i).getDeckSize() - 1) {
					sb.append("" + (j + 1) + ": " + shoe.get(i).getCardFromDeck(j) + "\t");
				} else {
					sb.append("" + (j + 1) + ": " + shoe.get(i).getCardFromDeck(j) + "\n");
				}
				if ((j + 1) % 3 == 0) {
					sb.append("\n");
				}
			}
		}
		return "\nDecks in the Shoe:\n" + sb.toString();
	}

	public String printAllCards() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allCards.size(); i++) {
			if (i < allCards.size() - 1) {
				sb.append("" + (i + 1) + ": " + allCards.get(i) + "\t");
			} else {
				sb.append("" + (i + 1) + ": " + allCards.get(i) + "\n");
			}
			if ((i + 1) % 3 == 0) {
				sb.append("\n");
			}
		}
		return "\nAll Cards in the Shoe, no cheating!\n" + sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allCards == null) ? 0 : allCards.hashCode());
		result = prime * result + numOfDecks;
		result = prime * result + ((shoe == null) ? 0 : shoe.hashCode());
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
		Shoe other = (Shoe) obj;
		if (allCards == null) {
			if (other.allCards != null)
				return false;
		} else if (!allCards.equals(other.allCards))
			return false;
		if (numOfDecks != other.numOfDecks)
			return false;
		if (shoe == null) {
			if (other.shoe != null)
				return false;
		} else if (!shoe.equals(other.shoe))
			return false;
		return true;
	}

}
