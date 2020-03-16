package tree;

import java.util.Scanner;
/**
 * check the number of strings that have already appeared
 * in the input in reverse order of letters
 * 
 * @author Idan Abergel & Hen Hess
 */
public class ReversedWords {

	private static Scanner s = new Scanner(System.in);;
	
	   /**
	   * checkReversed method gets a big String from the user
	   * the number of strings that have already appeared
	   * in the input in reverse order of letters
	   * @param 
	   * @return integer	; The number of strings that meet the condition
	   * @author Idan Abergel & Hen Hess
	   */
	public static int checkReversed() {
		String input, new_in;
		Node n = new Node();
		Node r = new Node();
		int end, count = 0;

		// System.out.print("Please enter some Strings: ");
		input = s.next();
		do {
			// break if the current string is X
			if (input.equals("X"))
				break;

			// in order to reverse the word, we are changing the string to char's array
			char[] in = input.toCharArray();
			end = in.length;
			char[] result = new char[end];

			for (int i = 0; i < end; i++) // reversed the word
				result[i] = in[end - i - 1];

			// convert the char's array back to a string
			new_in = String.valueOf(result);

			// Divide the solution into two cases
			// palindrome check:

			// if it is a palindrome
			if (new_in.equals(input)) {
				n.add(input);
				if (n.num(input) > 1)
					count++;
			} else { // not palindrome
				n.add(input);
				r.add(new_in);
				if ((r.num(input) > 0 && n.num(input) > 0))
					count++;
			}

			// System.out.println("the word " + new_in + " reverse of " + input + ", " + "
			// the count is:" + count);
			// System.out.print("Please enter another Strings: ");
			input = s.next();
		}while(input != null); 

		System.out.println("count: " + count);
		return count;
	}// checkRevresed

}
