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
			checkInitialBlackjack();
			if (!winner) {
				getPlayerChoice();
				while (!winner && !bust && dealer.getHandValue() < 17 && player.getHandValue() < 21) {
					dealer.dealCardToDealer();
					printBothHands();
				}
			}
			checkForWinner();
			playAgain();
		} while (keepPlaying);
	}

	private void playAgain() {
		System.out.println("\nWould you like to play again? 1) Yes | 2) Quit >> ");
		int playAgain = kb.nextInt();
		if (playAgain == 1) {
			keepPlaying = true;
		} else {
			keepPlaying = false;
		}
	}

	private void printMenu() {
		int choice;
		try {
			do {
				System.out.println("Please chose from the menu below: ");
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
			System.out.println("\nPlease enter a number.\n");
		}
	}

	private void checkInitialBlackjack() throws InterruptedException {
		if (dealer.getHandValue() == 21) {
//			System.out.println("\nDealer wins!!!\n");
//			Thread.sleep(1000);
//			System.out.println(dealer.toString());
			winner = true;
		}
	}

	private void checkForWinner() throws InterruptedException {
		if (dealer.getHandValue() > 21) {
			System.out.println("\nPlayer wins!!!\n");
			Thread.sleep(1000);
			System.out.println(dealer.toString());
			winner = true;
		} else if (player.getHandValue() > 21) {
			System.out.println("\nDealer wins!!!\n");
			Thread.sleep(1000);
			System.out.println(dealer.toString());
			winner = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() > player.getHandValue()) {
			System.out.println("\nDealer wins.\n");
			Thread.sleep(1000);
			System.out.println(dealer.toString());
			winner = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < player.getHandValue()) {
			System.out.println("\nPlayer wins.\n");
			Thread.sleep(1000);
			System.out.println(dealer.toString());
			winner = true;
		} else if (dealer.getHandValue() == player.getHandValue()) {
			System.out.println("\nThe hand is a push.\n");
			Thread.sleep(1000);
			System.out.println(dealer.toString());
			winner = true;
		} else if (dealer.getHandValue() == 21 && player.getHandValue() != 21) {
			System.out.println("\nDealer wins.\n");
			Thread.sleep(1000);
			System.out.println(dealer.toString());
		} else if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			System.out.println("\nPlayer wins.\n");
			Thread.sleep(1000);
			System.out.println(dealer.toString());
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
			System.out.println("\nWhould you like to 1) stand or 2) hit? ");
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

	public void printBothHands() throws InterruptedException {
		System.out.println("\nCurrent hands...");
		System.out.println(dealer.printDealerHand() + "\nDealer hand value: ??");
		Thread.sleep(1000);
		System.out.println(player.toString() + "\nPlayer hand value: " + player.getHandValue());
		Thread.sleep(1000);
	}

}
