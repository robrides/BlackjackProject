package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
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
		for(int i = 0; i < numOfDecks; i++) {
			shoe.add(new Deck());
			for(int j = 0; j < shoe.get(i).getDeckSize(); j++) {
				allCards.add(shoe.get(i).getCardFromDeck(j));
			}
		}
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
		return "\nFull Shoe\n" + sb.toString();
	}
	

		
	
}
