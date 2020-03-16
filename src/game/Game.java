package game;

import java.util.Scanner;

/**
 * Class Game manage a game and define basic functions
 * 
 * @author Idan Abergel & Hen Hess
 */
public class Game extends Board {

	protected Player[] players;
	protected Scanner s = new Scanner(System.in);

	/**
	 * constructor for class Game in a game, there are two players only board size
	 * is n*m
	 * 
	 * @param n       <Int> number of rows
	 * @param m       <Int> number of columns
	 * @param player1 <Player> first player
	 * @param player2 <Player> second player
	 */
	public Game(int n, int m, Player p1, Player p2) {
		super(n, m); // Board Contractor
		players = new Player[2]; // create new two players
		players[0] = p1;
		players[1] = p2;
	}

	/**
	 * check if the player is in the coordinates (i,j)=(0,0). if he is, he is a
	 * winner.
	 * 
	 * @param i <Int> x coordinate
	 * @param j <Int> y coordinate
	 * @return <Boolean> true if won, false otherwise
	 */
	protected boolean doesWin(int i, int j) {
		// win = someone in (0,0)
		if (i == 0 && j == 0)
			return true;
		return false;
	}// doesWin

	/**
	 * Runs one step in the game.Reading from the player his coordinates. Place in
	 * the game board, if possible. And returns true if he wins.
	 * 
	 * @param p <Player> Player
	 * @return <Boolean> true if won, false otherwise
	 */
	protected boolean onePlay(Player p) {
		int i = 0, j = 0;
		while (true) {
			System.out.println(p.toString() + ",please enter x and y:");

			i = s.nextInt();
			j = s.nextInt();

			if (!isEmpty(i, j)) {
				System.out.println("There is a piece there already...");
				continue;
			} else {
				this.set(i, j, p);
				System.out.println(this.toString());
				if (doesWin(i, j)) {
					return true;
				} else
					return false;
			}
		}

	}// onePlay

	/**
	 * Manage a game. Manage the players' turns and return the winning player.
	 * 
	 * @return <Player> Player winner
	 */
	public Player play() {

		while (true) {

			if (isFull())
				return null;

			// first player plays
			if (onePlay(players[0])) {
				System.out.println(players[0].toString() + " Won!");
				return players[0];
			}

			// second player plays
			if (onePlay(players[1])) {
				System.out.println(players[1].toString() + " Won!");
				return players[1];
			}
		}

	}// play

}
