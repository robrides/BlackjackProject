package com.skilldistillery.cards.common;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	Suit(String name) {
		this.name = name;
	}
	
	final private String name;

	public String getName() {
		return name;
	}
	
	
}
