package tasks;

import java.util.Arrays;

public class NamedTasks extends Tasks {
	private String [] task_name;
	private int NumTasks;
	/**
	 * A constructor that receives an array of task names
	 * 
	 * in this class we convert the strings array to int indexes
	 * in order to use Tasks methods.
	 * 
	 * @param names : Strings array
	 */
	public NamedTasks(String[] names) {
		super(names.length);
		NumTasks = names.length;
		task_name = names;
		System.out.println(">NamedTasks Created \n"
				+ Arrays.toString(task_name));
	}
	/**
	 * Adds to the data structure the dependency that says that
	 * task1 can not be executed before task2.
	 * If task1 or task2 are not valid numbers of tasks
	 * it will return false and true.
	 * 
	 * @param	task1	: String : ID of task1
	 * @param	task2	: String : ID of task2
	 * @return	true for success, false if the input is invalid
	 */
	public boolean dependsOn(String task1, String task2) {

		int t1=-1,t2=-1;
		
		// find the index of an element in the array
		for (int i = 0; i < NumTasks; i++) {
			if(task_name[i] == task1)
				t1 = i;
			if(task_name[i] == task2)
				t2 = i;		
		}
		// if the element did not found or t1=t2 return false
		if (t1 == -1 || t2 ==-1 || t1 == t2)
			return false;
		
		System.out.println(t1+" , "+t2);
		
		// use Tasks class to check the dependency 
		if(super.dependsOn(t1, t2))
			return true;
		
		// if failed
		return false;

	}
	/**
	 * nameOrder() return an array in which all the tasks appear in order that sustains 
	 * all the dependencies we have received. If there is no such order 
	 * (ie there is a circle of dependencies), then it will return null.
	 * 
	 * @return Array (String) in the right tasks order, false if there is a circle of dependencies
	 */
	public String[] nameOrder() {
		
		int [] res = super.order();
		String [] finalRes = new String [NumTasks];
				
		for (int i = 0; i < NumTasks; i++) {
			finalRes[i] = task_name[res[i]];
		}
		return finalRes;
	}
}

							
							