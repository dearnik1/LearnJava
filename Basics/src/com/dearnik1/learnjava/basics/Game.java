package com.dearnik1.learnjava.basics;

import java.util.Scanner;

public class Game {

	/* 
	
	Write a game Player vs Computer.
	
	There are 20 matches.
	Player makes the first move and can take 1, 2 or 3 matches per one move.
	Computer makes the second move (same, 1, 2 or 3 matches). The one who made the last move wins.
	Computer must always win.
	
	Stop game immediately if user enters "exit"
	Use java.util.Scanner to get the user input. 
	
	One round should look like this:
	
	  New Game
	  20 matches left
	  Make your choose:
	  4
	  Wrong input!
	  Make your choose:
	  3
	  17 matches left
	  Computer took 2
	  15 matches left
	  Make your choose:
	  
	  ...
	  
	  2 matches left
	  Computer took 2
	  0 matches left
	  You lose
	  Game Over
	
	*/
	public static void main(String[] args) {
		System.out.println("New Game");
		int matchesLeft = 20;
		System.out.println(matchesLeft + " matches left");
		String answer;
		Scanner scan = new Scanner(System.in);

		int matchesTaken;
		while (matchesLeft > 0) {
			System.out.println("Make your choose:");
			answer = scan.nextLine();

			if (answer.equals("1") || answer.equals("2") || answer.equals("3")) {
				matchesTaken = Integer.parseInt(answer);
				matchesLeft -= matchesTaken;
				matchesTaken = 4 - matchesTaken;               //For computer's win we need opposite turn.
				System.out.println(matchesLeft + " matches left");
				matchesLeft -= matchesTaken;
				System.out.println("Computer took " + matchesTaken);
				System.out.println(matchesLeft + " matches left");
			} else if (answer.equals("exit")) {
				matchesLeft = -1;
				break;
			} else {
				System.out.println("Wrong input!");
			}
		}
		if (matchesLeft != 1) {
			System.out.println(matchesLeft + " matches left");
			System.out.println("You lose");
		}
		System.out.println("Game Over");



	}
}
