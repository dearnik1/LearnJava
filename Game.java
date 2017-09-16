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
		int matches = 20;
		System.out.println(matches + " matches left");
		String answer;
		Scanner scan = new Scanner(System.in);

		int took;
		while (matches > 0){
			System.out.println("Make your choose:");
			answer = scan.nextLine();

			if (answer == "1" || answer == "2" || answer == "3") {
				took = Integer.parseInt(answer);
				matches -= took;
				took -= 4;               //For computer's win we need opposite turn.
				System.out.println(matches + " matches left");
				System.out.println("Computer took " + took);
				System.out.println(matches + " matches left");
			} else if (answer == "exit"){
				matches = 0;
				break;
			} else {
				System.out.println("Wrong input!");
			}
			System.out.println(matches + " matches left");
			System.out.println("You lose");
			System.out.println("Game Over");
		}


	}
}
