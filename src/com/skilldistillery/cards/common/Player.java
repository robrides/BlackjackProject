package com.skilldistillery.cards.common;

import java.util.List;
import com.skilldistillery.cards.common.Card;

public abstract class Player {

	private Hand hand;
//	private int money;

//	abstract void buildPlayer();

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public void clearHand() {
		hand.clearHand();
	}
	
//	public int decreaseMoney(int amt) {
//		return money -= amt;
//	}
//	
//	public int increaseMoney(int amt) {
//		return money += amt;
//	}
//	
//	public int moneyStatus() {
//		return money;
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<Card> playerCards = hand.getHand();
		for (int i = 0; i < playerCards.size(); i++) {
			if (i == 0) {
				sb.append(playerCards.get(i));
			} else if (i < playerCards.size() - 1) {
				sb.append(" | " + playerCards.get(i));
			} else {
				sb.append(" | " + playerCards.get(i));
			}
			if ((i + 1) % 3 == 0 && i < playerCards.size() - 1) {
				sb.append("\n");
			}
		}
		return "Player: " + sb.toString() + "\nPlayer hand value: " + hand.getHandValue();
	}

	public int getHandValue() {
		return hand.getHandValue();
	}
	
//	public boolean saveMoney() {
//		SaveMoneyAsFile mSaver = new SaveMoneyAsFile();
//		mSaver.saveAs();
//		return false;		
//	}

}
