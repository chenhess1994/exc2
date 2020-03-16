package tree;

/**
 * Class node manage a data structure to strings in order to add and count words
 * in the data structure
 * 
 * @author Idan Abergel & Hen Hess
 */
public class Node {
	private int count = 0;
	private Node[] children = new Node[1 + 'z' - 'a'];

	/**
	 * num method gets a string as a parameter and counts how many times this string
	 * appears the in data structure
	 * 
	 * @param s ; String
	 * @return integer ; The number of strings that meet the condition
	 */
	public int num(String s) {
		System.out.println("==================== int num(" + s + ") ====================");
		System.out.println("* Search how many times string " + s + " appears:");
		int st;
		Node cur = this;

		for (int i = 0; i < s.length(); i++) {
			st = s.charAt(i) - 'a';

			if (cur.children[st] != null) {
				// for the first iteration set times to 'count'
				cur = cur.children[st];
				if (i == s.length() - 1)
					return cur.count;
			} else
				return 0;
		}
		System.out.println("\n--Done num(" + s + ")");
		return 0;
	}// num

	/**
	 * add a word to the data structure
	 * @param s ; String added to the data structure
	 */
	public void add(String s) {
		System.out.println("==================== void add(" + s + ") ====================");
		System.out.println("* add " + s + " to the tree:");

		Node cur = this;
		int st;

		for (int i = 0; i < s.length(); i++) {

			st = s.charAt(i) - 'a';

			System.out.println(i + "# Letter " + s.charAt(i) + " st =" + st);

			if (cur.children[st] == null) {
				cur.children[st] = new Node();
				cur = cur.children[st];
				if (i == s.length() - 1)
					cur.count++;
			} else {
				cur = cur.children[st];
				if (i == s.length() - 1)
					cur.count++;
			}
			// System.out.println(" new node created");
			System.out.println("	children[" + st + "]	count = " + cur.count);

		} // for
		System.out.println("--Done add(" + s + ")");
	}

}// class
