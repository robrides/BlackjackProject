package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Scanner kb;
	private Dealer dealer;
	private Player player;
	private boolean winner;
	private boolean keepPlaying;
	private boolean bust;

	public static void main(String[] args) throws InterruptedException {
		new BlackjackApp().init();

	}

	private void init() throws InterruptedException {
		dealer = new Dealer();
		player = new Player();
		kb = new Scanner(System.in);
		run();
	}

	private void run() throws InterruptedException {
		System.out.println("Welcome to the Blackjack Table\n");

		do {
			printMenu();
			bust = false;
			winner = false;
			System.out.println("\n\nAces are a value of 11.");
			System.out.println("\nDealing...");
			dealer.dealFirstHand(player);
			printBothHands();
			checkForBust();
			checkInitialBlackjack();
			if (!winner) {
				getPlayerChoice();
				while (!winner && !bust && dealer.getHandValue() < 17 && player.getHandValue() <= 21) {
					dealer.dealCardToDealer();
					dealer.toString();
				}
				player.toString();
			}
			checkForWinner();
			playAgain();
		} while (keepPlaying);
	}

	private void playAgain() {
		System.out.println("\nWould you like to play again? 1) Yes | 2) Quit >> ");
		try {
			int playAgain = kb.nextInt();
			if (playAgain == 1) {
				keepPlaying = true;
			} else {
				keepPlaying = false;
			}
		} catch (Exception e) {
			System.err.println("\nPlease enter a Number.\n");
			kb.nextLine();
		}
	}

	private void printMenu() {
		int choice;
		try {
			do {
				System.out.println("\nPlease chose from the menu below: ");
				System.out.println("1) Play Blackjack");
				System.out.println("2) Print Deck");
				System.out.println("3) Quit");
				choice = kb.nextInt();
				switch (choice) {
				case 1:
					break;
				case 2:
					System.out.println(dealer.printDeck());
					break;
				case 3:
					System.exit(0);
					break;
				default:
					break;
				}
			} while (choice != 1);
		} catch (Exception e) {
			System.err.println("\nPlease enter a number.\n");
			kb.nextLine();
		}
	}

	private void checkInitialBlackjack() throws InterruptedException {
		if (player.getHandValue() > 21 || dealer.getHandValue() > 21) {
			bust = true;
			System.out.println("\nBust on double Aces.  Not allowed in this version.\n");
		} else if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
			if (player.checkBlackjackHand() && dealer.checkBlackjackHand())
				;
			winner = false;
		} else if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			if (player.checkBlackjackHand() && dealer.checkBlackjackHand())
				;
			winner = true;
		}
	}

	private void checkForWinner() throws InterruptedException {
		if (dealer.getHandValue() > 21) {
			System.out.println("\nPlayer wins!!!\n");
			Thread.sleep(500);
			System.out.println(player.toString());
			winner = true;
		} else if (player.getHandValue() > 21) {
			System.out.println("\nDealer wins!!!\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
			winner = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() > player.getHandValue()) {
			System.out.println("\nDealer wins.\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
			winner = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < player.getHandValue()) {
			System.out.println("\nPlayer wins.\n");
			Thread.sleep(500);
			System.out.println(player.toString());
			winner = true;
		} else if (dealer.getHandValue() == player.getHandValue()) {
			System.out.println("\nThe hand is a push.\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
			System.out.println(player.toString());
			winner = true;
		} else if (dealer.getHandValue() == 21 && player.getHandValue() != 21) {
			System.out.println("\nDealer wins.\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
		} else if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			System.out.println("\nPlayer wins.\n");
			Thread.sleep(500);
			System.out.println(player.toString());
		}
	}

	private void checkForBust() {
		if (dealer.getHandValue() > 21 || player.getHandValue() > 21) {
			bust = true;
		}
	}

	private void getPlayerChoice() throws InterruptedException {
		boolean keepGoing = true;
		int choice;

		do {
			System.out.print("\nWhould you like to 1) Stand or 2) Hit? >> ");
			try {
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
			} catch (Exception e) {
				System.err.println("\nPlease enter a number.\n");
				kb.nextLine();
			}
		} while (keepGoing && !bust);
	}

	public void printBothHands() throws InterruptedException {
		System.out.println("\nCurrent hands...");
		System.out.println(dealer.printDealerHand());
		Thread.sleep(500);
		System.out.println(player.toString());
		Thread.sleep(500);
	}

}
