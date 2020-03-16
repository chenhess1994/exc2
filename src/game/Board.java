package game;
/**
 * Manage a board game
 * 
 * @author Idan Abergel & Hen Hess
 */
public class Board {

	protected Player[][] board;
	protected int n, m; // n columns, m rows
	private int amount;
	/**
	 * Contractor of class Board
	 * @param n       <Int> number of rows
	 * @param m       <Int> number of columns
	 */
	public Board(int n, int m) {
		board = new Player[n][m];
		this.n = n;
		this.m = m;
		amount = 0;
	}

	/**
	 * Check if the (i,j) coordinate are valid
	 * 
	 * @param i <Int> x coordinate
	 * @param j <Int> y coordinate
	 * @return <Boolean> true if the coordinates valid,
	 * 					 false otherwise
	 */
	private boolean checkCoordinates(int i, int j) {
		if (i > n || i< 0 || j > m || j < 0) {
			return false;
		}
		return true;
	}
	/**
	 * set a player in the board game by coordinates (i,j)
	 * 
	 * @param i <Int> y coordinate
	 * @param j <Int> x coordinate
	 * @param p <Player>
	 * @return <Boolean> true for success, false otherwise
	 */
	protected boolean set(int i, int j, Player p) {
		if(!checkCoordinates(i,j)) return false;
		if (isEmpty(i, j)) {
			board[i][j] = p;
			amount++;
			return true;
		}
		
		return false;
	}
	/**
	 * Check coordinates availability
	 * 
	 * @param i <Int> y coordinate
	 * @param j <Int> x coordinate
	 * @return <Boolean> true if the coordinates empty,
	 * 					 false if the coordinates already token
	 */
	public boolean isEmpty(int i, int j) {
		if(!checkCoordinates(i,j)) return false;	
		if (board[i][j] == null)
			return true;
		return false;
	}
	/**
	 * get a player in (i,j) coordinates
	 * 
	 * @param i <Int> y coordinate
	 * @param j <Int> x coordinate
	 * @return <Player> Player in (i,j)
	 */
	public Player get(int i, int j) {
		if(!checkCoordinates(i,j)) return null;	
		return board[i][j];
	}
	/**
	 * check if the board is full
	 * @return <boolean> true if the board is full, false otherwise
	 */
	public boolean isFull() {
		if (amount == n * m)
			return true;
		return false;
	}

	/**
	 * Display the board as a String
	 * @return <String> String
	 */	
	public String toString() {

		String out = "";
		for (int i = 0; i < n; i++) { //rows
			for (int j = 0; j < m; j++) { // columns
				if (board[i][j] != null)
					out = out + get(i, j).getMark();
				else
					out = out + ".";
			}

			out = out + "\n";
		}
		return out;
	}
	/**
	 * Returns the length of the longest straight line (including diagonals)
	 * in the panel containing the point i, j and is denoted by the same player as the point i, j.
	 * 
	 * @param i <Int> y coordinate
	 * @param j <Int> x coordinate
	 * @return <Int>  max length
	 */
	protected int maxLineContaining(int i, int j) {

		int c = 0, c2 = 0, k, r;
		// check if 
		if(!checkCoordinates(i,j)) return 0;	


		// get the player on point (i,j)
		Player p = get(i, j);

		if (p == null)
			return 0;

		int max = 0;

		// check width lines
		// to the right
		for (k = j, c = 0; k < m; k++) {
			if (get(i, k) == p)
				c++;
			else
				break;
		}
		// to the left
		for (k = j - 1, c2 = 0; k >= 0; k--) {
			if (get(i, k) == p)
				c2++;
			else
				break;
		}

		max = Math.max(c + c2, max);

		// check height lines
		// up
		c2 = 0;
		c = 0;
		for (k = i; k < n; k++) {
			if (get(k, j) == p)
				c++;
			else
				break;
		}
		// down
		for (k = i - 1; k >= 0; k--) {
			if (get(k, j) == p)
				c2++;
			else
				break;
		}

		max = Math.max(c + c2, max);

		// check if the matrix is not a square
//		if (n != m) {
//			System.out.println("Not a square m != n, so cant calc slants");
//			return 0;
//		}
		// FIRST SLANT \
		// check slant up
		k = i;
		r = j;
		c2 = 0;
		c = 0;
		while (k >= 0 && r >= 0) {
			if (get(k, r) == p)
				c++;
			else
				break;
			k--;
			r--;
		}

		// check slant down
		k = i + 1;
		r = j + 1;

		while (k < n && r < m) {
			if (get(k, r) == p)
				c2++;
			else
				break;
			k++;
			r++;
		}
		max = Math.max(c + c2, max);

		// SECOND SLANT
		// check slant up
		k = i;
		r = j;
		c2 = 0;
		c = 0;
		while (k >= 0 && r < m) {
			if (get(k, r) == p)
				c++;
			else
				break;
			k--;
			r++;
		}
		k = i + 1;
		r = j - 1;

		// check slant down
		while (k < n && r >= 0) {
			if (get(k, r) == p)
				c2++;
			else
				break;
			k++;
			r--;
		}
		max = Math.max(c + c2, max);

		System.out.println(p + " so far: " + max);
		return max;
	}// maxLineContaining

}
