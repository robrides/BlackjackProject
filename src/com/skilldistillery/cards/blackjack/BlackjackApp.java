package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Scanner kb;
	private Dealer dealer;
	private BlackjackPlayer player;
	private boolean dealerWin;
	private boolean playerWin;
	private boolean keepPlaying;
	private boolean push;
	private boolean bust;
	private int bet;

	public static void main(String[] args) throws InterruptedException {
		new BlackjackApp().init();
	}

	private void init() throws InterruptedException {
		int numDecks = 0;
		kb = new Scanner(System.in);
		printWelcome();
		System.out.print("\n\nHow many decks of cards would you like in the Dealer's shoe? >> ");
		try {
			numDecks = kb.nextInt();
		} catch (Exception e) {
			System.err.println("Please enter a number.");
			kb.hasNextLine();
		}
		dealer = new Dealer(numDecks);
		player = new BlackjackPlayer();
		run();
	}

	private void run() throws InterruptedException {
		do {
			printMenu();
			printWelcome();
			bust = false;
			dealerWin = false;
			playerWin = false;
			dealInitialHand();
			if (!dealerWin && !playerWin) {
				getPlayerChoice();
				while (!push && !dealerWin && !playerWin && !bust && dealer.getHandValue() < 17
						&& player.getHandValue() <= 21) {
					dealer.dealCardToDealer();
					dealer.toString();
				}
				player.toString();
			} else {
				betResult();
			}
			checkForWinner();
			betResult();
			playAgain();
		} while (keepPlaying);
	}

	private void betResult() {
		if (playerWin) {
			player.increaseMoney(bet);
			System.out.println("\nPlayer wallet: $" + getPlayerMoneyStatus());
		} else if (dealerWin) {
			player.decreaseMoney(bet);
			System.out.println("\nPlayer wallet: $" + getPlayerMoneyStatus());
		}
	}

	private void dealInitialHand() throws InterruptedException {
		System.out.println("\nAces are a value of 11.");
		getInitialMoney();
		bet();
		System.out.println("\nDealing...");
		dealer.dealFirstHand(player);
		printBothHands();
		checkForBust();
		checkInitialBlackjack();
	}

	private void getInitialMoney() {
		if (player.moneyStatus() <= 0) {
			System.out.println("\nYour wallet: $" + player.moneyStatus());
			System.out.print("Please add money to continue >>");
			try {
				player.increaseMoney(kb.nextInt());
			} catch (Exception e) {
				System.err.println("Please enter a number.");
				kb.nextLine();
			}
		} else {
			System.out.println("\nYour wallet: $" + player.moneyStatus());
			System.out.print("Would you like to add more money to your wallet? 1) Yes, 2) No >> ");
			int choice = 0;
			try {
				choice = kb.nextInt();
			} catch (Exception e) {
				System.err.println("Please enter a number.");
				kb.nextLine();
			}
			switch (choice) {
			case 1:
				System.out.print("\nEnter amount >> ");
				try {
					player.increaseMoney(kb.nextInt());
				} catch (Exception e) {
					System.err.println("Please enter a number.");
					kb.nextLine();
				}
				break;
			case 2:
				break;
			default:
				break;
			}
		}
	}

	private int getPlayerMoneyStatus() {
		return player.moneyStatus();
	}

	private void bet() {
		do {
		System.out.print("\nEnter bet amount: >> ");
		try {
			bet = kb.nextInt();
		} catch (Exception e) {
			System.out.println("\nPlease enter a number.");
			kb.nextLine();
		}
		if (player.moneyStatus() < bet) {
			System.out.println("\nYou do not have enough money for that bet.");
			
		} else {
			System.out.println("\nBet accepted.");
		}
		} while (bet > player.moneyStatus());
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
			System.err.println("\nPlease enter a Number.");
			kb.nextLine();
		}
	}

	private void printWelcome() {
		char a = '\u2664', b = '\u2665', c = '\u2666', d = '\u2667';
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b
				+ c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b
				+ c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b
				+ c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ "                                  " + c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ "  Welcome to the Blackjack Table  " + c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ "                                  " + c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b
				+ c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b
				+ c + d + a + b + c + d + a + b + c + d + a + b + c + d);
		System.out.println("" + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d
				+ a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b + c + d + a + b
				+ c + d + a + b + c + d + a + b + c + d + a + b + c + d);
	}

	private void printMenu() {
		int choice;
		try {
			do {
				System.out.println("\nPlease chose from the menu below: ");
				System.out.println("1) Play Blackjack.");
				System.out.println("2) Print Decks going into the Shoe.");
				System.out.println("3) Print all Cards from all decks in the Shoe.");
				System.out.println("4) Quit.");
				System.out.print("Enter choice: >> ");
				choice = kb.nextInt();
				switch (choice) {
				case 1:
					break;
				case 2:
					System.out.println(dealer.printShoeDeck());
					break;
				case 3:
					System.out.println(dealer.printShoeCards());
					break;
				case 4:
					System.exit(0);
					break;
				default:
					break;
				}
			} while (choice != 1);
			System.out.println("\n\n");
		} catch (Exception e) {
			System.err.println("\nPlease enter a number.");
			kb.nextLine();
		}
	}

	private void checkInitialBlackjack() throws InterruptedException {
		if (player.getHandValue() > 21 || dealer.getHandValue() > 21) {
			bust = true;
			System.out.println("\nBust on double Aces.  Not allowed in this version.");
		} else if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
			if (player.checkBlackjackHand() && dealer.checkBlackjackHand())
				;
			dealerWin = false;
			playerWin = false;
		} else if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			if (player.checkBlackjackHand() && dealer.checkBlackjackHand())
				;
			dealerWin = false;
			playerWin = false;
		}
	}

	private void checkForWinner() throws InterruptedException {
		if (dealer.getHandValue() > 21) {
			System.out.println("\nPlayer wins!!!\n");
			Thread.sleep(500);
			System.out.println(player.toString());
			playerWin = true;
		} else if (player.getHandValue() > 21) {
			System.out.println("\nDealer wins!!!\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
			dealerWin = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() > player.getHandValue()) {
			System.out.println("\nDealer wins.\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
			dealerWin = true;
		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < player.getHandValue()) {
			System.out.println("\nPlayer wins.\n");
			Thread.sleep(500);
			System.out.println(player.toString());
			playerWin = true;
		} else if (dealer.getHandValue() == player.getHandValue()) {
			System.out.println("\nThe hand is a push.\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
			System.out.println(player.toString());
			push = true;
		} else if (dealer.getHandValue() == 21 && player.getHandValue() != 21) {
			System.out.println("\nDealer wins.\n");
			Thread.sleep(500);
			System.out.println(dealer.toString());
		} else if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			System.out.println("\nPlayer wins.\n");
			Thread.sleep(500);
			System.out.println(player.toString());
			playerWin = true;
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
				System.err.println("\nPlease enter a number.");
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
