package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Scanner kb;
	private Dealer dealer;
	private Player player;
	private boolean winner;
	private boolean keepPlaying;
	private boolean bust;

	public static void main(String[] args) {
		new BlackjackApp().init();

	}

	private void init() {
		dealer = new Dealer();
		player = new Player();
		kb = new Scanner(System.in);
		run();
	}

	private void run() {
		System.out.println("Welcome to the Blackjack Table\n");

		do {
			System.out.println("\n\nDealing...");
			dealer.dealFirstHand(player);
			printBothHands();
			winner = false;
			getPlayerChoice();
			while (!bust && dealer.getHandValue() < 17 && player.getHandValue() < 21) {
				dealer.dealCardToDealer();
				printBothHands();
			}
			checkForWinner();
			System.out.println("Would you like to play again? 1) Yes 2) Quit >> ");
			int playAgain = kb.nextInt();
			if (playAgain == 1) {
				keepPlaying = true;
			} else {
				keepPlaying = false;
			}
		} while (keepPlaying);
	}

	private void checkForWinner() {

		if (dealer.getHandValue() > 21) {
			System.out.println("\nPlayer wins!!!\n");
			winner = true;
		} else if (player.getHandValue() > 21) {
			System.out.println("\nDealer wins!!!\n");
			winner = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() > player.getHandValue()) {
			System.out.println("\nDealer wins.\n");
			winner = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < player.getHandValue()) {
			System.out.println("\nPlayer wins.\n");
			winner = true;
		} else if (dealer.getHandValue() == player.getHandValue()) {
			System.out.println("\nThe hand is a push.\n");
			winner = true;
		} else if (dealer.getHandValue() == 21 && player.getHandValue() != 21) {
			System.out.println("\nDealer wins.\n");
		} else if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			System.out.println("\nPlayer wins.\n");
		}
	}

	private void checkForBust() {
		if (dealer.getHandValue() > 21 || player.getHandValue() > 21) {
			bust = true;
		}
	}

	private void getPlayerChoice() {
		boolean keepGoing = true;
		int choice;

		do {
			System.out.println("Whould you like to 1) stand or 2) hit? ");
			choice = kb.nextInt();

			switch (choice) {
			case 1:
				keepGoing = false;
				break;
			case 2:
				dealer.addCardToPlayer(player);
				printBothHands();
				checkForBust();
				keepGoing = true;
				break;
			default:
				break;
			}
		} while (keepGoing && !bust);
	}

	public void printBothHands() {
		System.out.println("\nCurrent hands...");
		System.out.println("Dealer: " + dealer.toString() + "\nDealer hand value: " + dealer.getHandValue());
		System.out.println("Player: " + player.toString() + "\n Player hand value: " + player.getHandValue());
	}

}
