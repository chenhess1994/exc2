package tasks;

import java.util.Arrays;
/**
 * Organize tasks automatically
 * 
 * @author Idan Abergel & Hen Hess
 */
public class Tasks {
	// [row][column]
	private int[][] matrix;
	private int numTasks; // amount of tasks

	/**
	 * Contractor of class Tasks
	 * @param num     <Int> number of tasks to initialize
	 */
	public Tasks(int num) {
		matrix = new int[num][num];
		setNumTasks(num);
	}
	/**
	 * Adds to the data structure the dependency that says that
	 * task1 can not be executed before task2.
	 * If task1 or task2 are not valid numbers of tasks
	 * it will return false and true.
	 * 
	 * @param	task1		<Int> ID of task1
	 * @param	task2		<Int> ID of task2
	 * @return	true for success, false if the input is invalid
	 */
	public boolean dependsOn(int task1, int task2) {

		// input validation
		if ((task1 < 0 || task2 < 0) || (task1 > getNumTasks() - 1 
				|| task2 > getNumTasks() - 1) ||task1 == task2)
			return false;

		matrix[task2][task1] = 1;
		return true;
	}

	/**
	 * order() return an array in which all the tasks appear in order that sustains 
	 * all the dependencies we have received. If there is no such order 
	 * (ie there is a circle of dependencies), then it will return null.
	 * 
	 * @return Array (int) in the right tasks order, false if there is a circle of dependencies
	 */
	public int[] order() {
		int[] res = new int[getNumTasks()]; // result array
		int[] color = new int[getNumTasks()];// color = 1 if we already visited row #i
		int c = 0; // how many tasks in the array result
					// to indicate the first iteration of the while
		int i, j;
		boolean ZeroColumn;
		
		
		System.out.println("Original:");
		print();
		
		System.out.println("================================================");
		while (c != getNumTasks()) {
			
			System.out.println("C = " + c);
			for (j = 0; j < getNumTasks() ; j++) {
				
				ZeroColumn = true;
				// System.out.println(">Check Column "+ j);
				

				if (color[j] == 1) {
					System.out.println(j + " >> skipping");
					continue;
				}
				print();
				for (i = 0; i < getNumTasks() && ZeroColumn; i++) {
					// scan a column in order to search a zero Column
					System.out.println("[" + i + "][" + j + "] = " + matrix[i][j]);
					if (matrix[i][j] != 0) {
						ZeroColumn = false;
						System.out.println(" false");
					}

				}
				if (ZeroColumn) {
					System.out.println(">reseting row #" + j);
					for (i = 0; i < getNumTasks(); i++) {
						matrix[j][i] = 0;
					}
					color[j] = 1;
					// set the task priority in the array
					res[c] = j;
					c++;				
					
				}

				System.out.println(">C = " + c);
				System.out.println("color:  " + j + Arrays.toString(color));
				System.out.println("res:    " + j + Arrays.toString(res));
				System.out.println("----");
			} // for j

			if (c == 0) {
				/*
				 * IF AFTER THE FIRST ITTERATION WE DIDN'T FOUND EMPTY COLUMN,
				 * SO THERE IS A CIRCLE
				 */
				return null;
			}

		} // while

		System.out.println("RETURN:"+Arrays.toString(res));
		return res;

	}

	/**
	 * numTasks Getter
	 * 
	 * @return <Int> int numTasks
	 */	
	private int getNumTasks() {
		return numTasks;
	}
	/**
	 * numTasks Setter
	 * @param numTasks : int
	 */	
	private void setNumTasks(int numTasks) {
		this.numTasks = numTasks;
	}

	// our additional function that printing the matrix -> used for testing and debugging
	private void print() {
		System.out.print("    ");
		for (int i = 0; i < matrix.length; i++) {

			System.out.print(i + " ");
		}
		System.out.print("\n");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
