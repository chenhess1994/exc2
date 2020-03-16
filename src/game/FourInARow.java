package game;
/**
 * Class FourInARow manage a FourInARow game
 * 
 * @author Idan Abergel & Hen Hess
 */
public class FourInARow extends Game {
	/**
	* constructor for class FourInARow
	* in this game, there are two players only
	* the board size always defined as 6*7
	* @param player1  <Player> first player
	* @param player2  <Player> second player
	*/
	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}
	/**
	 * In FourInARow game the victory is the one who have 4 marks in a row
	 * 
	 * @param i	; Integer y Coordinates (row)
	 * @param j	; Integer x Coordinates (column)
	 * @return boolean ; true if the player has won. false otherwise.
	 */
	@Override
	protected boolean doesWin(int i, int j) {
	// This method overrides doesWin() of Games
		// win = someone has line / slant
		if (maxLineContaining(i,j)==4)
			return true;
		return false;
	}// doesWin

	/**
	 * additional private function to check if column i is full
	 * 
	 * @param j	; Integer j Coordinates
	 * @return <Int> Integer: 	positive value: the first empty location in the column (from the bottom!)
	 * 							-1 if the column full.
	 */
	private int columnFull(int j) {
		for (int i = n-1; i >= 0; i--) {
			if (isEmpty(i, j))
				return i;
		}
		return -1;
	}
	/**
	 * Manage one turn in a game. read Integer from Scanner and place it, if possible in the game board.
	 * 
	 * @param p	; Player who is playing this turn.
	 * @return true ; the player p has won
	 * 			false ; player lose or input is not valid
	 */
	@Override
	protected boolean onePlay(Player p) {
		int i, row;
		
			System.out.println(p.toString() + ", please enter column num:");
			i = s.nextInt();
			System.out.println(i);
			
			//check input is valid
			if( i < 0 || i>=n)
				return false;
			
			// check availability of the column, in not return false.
			if ((row = columnFull(i)) < 0) {
				System.out.println("This column is full");
				return false;
			}
			
			// set the player in available location in the column.
			this.set(row, i, p);
			System.out.println(this.toString());

			// check if player has won
		if (doesWin(row,i))
			return true;
		return false;
	}

}
