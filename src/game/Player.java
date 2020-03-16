package game;
/**
 * Class Player define a player and his mark
 * 
 * @author Idan Abergel & Hen Hess
 */
public class Player {
	private String name;
	private char mark;
	/**
	* constructor for class Player
	* in this game, there are two players only
	* @param name  <String> player name
	* @param mark  <char> char player's mark
	*/
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	/**
	* Player name getter
	* @return name  <String>
	*/
	public String getName() {
		return this.name;
	}
	/**
	* Player mark getter
	* @return char mark <char>
	*/
	public char getMark() {
		return this.mark;
	}

	/**
	* Player to string by format name(mark)
	* @return String name(mark) <String>
	*/
	public String toString() {
		return name + "(" + mark + ")";
	}
}// class
