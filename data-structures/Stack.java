import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This class is for stack data structure.
 * @author Jirayu Laungwilawan
 * @version 2.10.2018
 */

public class Stack {
	private List<Integer> stack;
	
	public Stack() {
		stack = new ArrayList<Integer>();
	}

	/**
	 * Return the top of the stack.
	 * @return the top element of the stack
	 */
	public int pop() {
		int num = -1;
		try {
			num = stack.get(0);
			stack.remove(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Stack is empty!");
		}
		return num;
	}
	
	/**
	 * Push the element to the top of the stack.
	 * @param element to push to stack
	 */
	public void push(int num) {
		stack.add(0, num);
	}
	
	/**
	 * Clear the stack
	 */
	public void clear() {
		stack.clear();
	}
	
	/**
	 * Print the stack
	 */
	public void showStack() {
		if (stack.isEmpty()) {
			System.out.println("The stack is empty.");
		} else {			
			for (Integer integer : stack) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		String menu = "";
		while (!menu.equals("e")) {
			System.out.println("Please select the menu: (p)ush, (po)p, (s)how stack, (c)lear stack, (e)xit.");
			System.out.print("Your input: ");
			menu = sc.nextLine();
			switch (menu) {
			case "p":
				System.out.print("Please put the number to push: ");
				s.push(Integer.parseInt(sc.nextLine()));
				break;
			case "po":
				System.out.println("The number that pop: " + s.pop());
				break;
			case "s":
				System.out.print("Show stack: ");
				s.showStack();
				break;
			case "c":
				System.out.println("Stack have been clear.");
				s.clear();
				break;
			default:
				break;
			}
		}
		sc.close();
		System.out.println("Program terminated.");
	}

}
