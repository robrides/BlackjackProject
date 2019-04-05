package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {
	private Scanner kb;
	private BlackjackHand playerHand;
	private BlackjackHand dealerHand;
	private Deck deck;
	boolean winner;
	boolean stand;

	public static void main(String[] args) {
		new BlackjackApp().launch();

	}

	private void launch() {
		deck = new Deck();
		playerHand = new BlackjackHand();
		dealerHand = new BlackjackHand();
		kb = new Scanner(System.in);
		System.out.println("Welcome to the Blackjack Table\n");

		do {
			System.out.println("Dealing...");
			dealFirstHand();
			printHand();
			winner = false;
			getPlayerChoice();
			if (stand && !winner) {
				dealCardToDealer();
				printHand();
				checkForWinner();
			}
//			checkForWinner();
		} while (!winner);
	}

	private void checkForWinner() {

		if (dealerHand.getHandValue() < 22 && playerHand.getHandValue() < 22) {
			if (dealerHand.getHandValue() > playerHand.getHandValue()) {
				System.out.println("\nDealer wins.\n");
				winner = true;
			} else if (playerHand.getHandValue() > dealerHand.getHandValue()) {
				System.out.println("\nDealer wins.\n");
				winner = true;
			} else {
				winner = true;
				System.out.println("\nThe hand is a push.\n");
			}
		} else if (dealerHand.getHandValue() > 21) {
			System.out.println("\nPlayer wins!!!\n");
			winner = true;
		} else {
			System.out.println("\nDealer wins!!!\n");
			winner = true;
		}

		winner = false;
	}

	private void dealCardToDealer() {
		while (dealerHand.getHandValue() < 17) {
			dealerHand.addCard(deck.dealCard());
			System.out.println("\nCard dealt to dealer\n" + dealerHand.toString());
		}
		System.out.println("Dealer stands at 17\n");
	}

	private void getPlayerChoice() {
		boolean keepGoing = true;
		int choice;

		do {
			System.out.println("Whould you like to 1) stand or 2) hit? ");
			choice = kb.nextInt();

			switch (choice) {
			case 1:
				System.out.println("case 1");
				System.out.println("Choice == " + choice);
				keepGoing = false;
				stand = true;
				break;
			case 2:
				playerHand.addCard(deck.dealCard());
				printHand();
				keepGoing = false;
				break;
			default:
				break;
			}
			System.out.println(choice + " Choice is...");
		} while (keepGoing);

	}

	private void dealFirstHand() {
		dealerHand.clearHand();
		playerHand.clearHand();
		System.out.println();
		playerHand.addCard(deck.dealCard());
		System.out.println(playerHand.toString());
		dealerHand.addCard(deck.dealCard());
		System.out.println(dealerHand.toString());
		playerHand.addCard(deck.dealCard());
		System.out.println(playerHand.toString());
		dealerHand.addCard(deck.dealCard());
		System.out.println(dealerHand.toString());
		System.out.println();
	}

	private void printHand() {
		System.out.println("\nCurrent hands...");
		System.out.println("Dealer: " + dealerHand.toString() + "\nDealer hand value: " + dealerHand.getHandValue());
		System.out.println("Player: " + playerHand.toString() + "\n Player hand value: " + playerHand.getHandValue());
	}

}
