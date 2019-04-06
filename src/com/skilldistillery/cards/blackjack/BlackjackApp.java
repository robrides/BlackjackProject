package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Scanner kb;
//	private BlackjackHand playerHand;
//	private BlackjackHand dealerHand;
	private Dealer dealer;
//	private Deck deck;
	private Player player;
	boolean winner;
	boolean stand;

	public static void main(String[] args) {
		new BlackjackApp().launch();

	}

	private void launch() {
		dealer = new Dealer();
		player = new Player();
		kb = new Scanner(System.in);
		System.out.println("Welcome to the Blackjack Table\n");

		do {
			System.out.println("Dealing...");
			dealer.dealFirstHand(player);
			printHand();
			winner = false;
			getPlayerChoice();
			if (stand && !winner) {
				dealer.dealCardToDealer();
				printHand();
				checkForWinner();
			}
//			checkForWinner();
		} while (!winner);
	}

	private void checkForWinner() {

		if (dealer.getHandValue() < 22 && player.getHandValue() < 22) {
			if (dealer.getHandValue() > player.getHandValue()) {
				System.out.println("\nDealer wins.\n");
				winner = true;
			} else if (player.getHandValue() > dealer.getHandValue()) {
				System.out.println("\nDealer wins.\n");
				winner = true;
			} else {
				winner = true;
				System.out.println("\nThe hand is a push.\n");
			}
		} else if (dealer.getHandValue() > 21) {
			System.out.println("\nPlayer wins!!!\n");
			winner = true;
		} else {
			System.out.println("\nDealer wins!!!\n");
			winner = true;
		}

		winner = false;
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
				dealer.addCardToPlayer(player);
				printHand();
				keepGoing = false;
				break;
			default:
				break;
			}
			System.out.println(choice + " Choice is...");
		} while (keepGoing);

	}

	private void printHand() {
		System.out.println("\nCurrent hands...");
		System.out.println("Dealer: " + dealer.toString() + "\nDealer hand value: " + dealer.getHandValue());
		System.out.println("Player: " + player.toString() + "\n Player hand value: " + player.getHandValue());
	}

}
