package com.stacksandqueues.sortstackusingrecursion;

// Importing the stack for using methods
import java.util.Stack;

// StackSorterMain class to test the sorting functionality
class StackSorterMain {
	public static void main(String[] args) {
		// Create an instance of Stack
		Stack<Integer> stack = new Stack<>();

		// Push elements into the stack
		stack.push(5);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(4);

		// Create an instance of StackSorter
		StackSorter sorter = new StackSorter();

		// Display the original stack
		System.out.println("Original Stack:");
		sorter.displayStack(stack);

		// Sort the stack using recursion
		sorter.sortStack(stack);

		// Display the sorted stack
		System.out.println("\nSorted Stack:");
		sorter.displayStack(stack);
	}
}

