package game;
/**
 * Class TicTacToe manage a TicTacToe game
 * 
 * @author Idan Abergel & Hen Hess
 */
public class TicTacToe extends Game {
	/**
	* constructor for class TicTacToe
	* in this game, there are two players only
	* @param player1  <Player> first player
	* @param player2  <Player> second player
	*/
	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}
	
	/**
	 * In TicTacToe game the victory is the one who have 3 marks in a row
	 * 
	 * @param x	; Integer x Coordinates
	 * @param y	; Integer y Coordinates
	 * @return boolean ; true if the player has won. false otherwise.
	 */
	@Override
	protected boolean doesWin(int x, int y) {
		// This method overrides doesWin() of Games
		// win = someone has line / alachson
		if (maxLineContaining(y,x)==3)
			return true;
		return false;
	}// doesWin
}