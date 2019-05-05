package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Player;
import com.skilldistillery.cards.connector.SaveMoneyAsFile;

public class BlackjackPlayer extends Player {

	private BlackjackHand playerHand;
	private int money;

	public BlackjackPlayer() {
		buildPlayer();
	}

	private void buildPlayer() {
		playerHand = new BlackjackHand();
	}

	@Override
	public void addCard(Card card) {
		playerHand.addCard(card);
	}

	@Override
	public void clearHand() {
		playerHand.clearHand();
	}
	
	public int decreaseMoney(int amt) {
		return money -= amt;
	}
	
	public int increaseMoney(int amt) {
		return money += amt;
	}
	
	public int moneyStatus() {
		return money;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		List<Card> playerCards = playerHand.getHand();
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
		return "Player: " + sb.toString() + "\nPlayer hand value: " + playerHand.getHandValue();
	}

	public int getHandValue() {
		return playerHand.getHandValue();
	}

	public boolean checkBlackjackHand() {
		return playerHand.checkBlackjackHand();
	}
	
	public boolean saveMoney() {
		SaveMoneyAsFile mSaver = new SaveMoneyAsFile();
		mSaver.saveAs();
		return false;		
	}

}
