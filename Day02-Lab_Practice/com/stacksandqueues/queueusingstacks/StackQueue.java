package com.stacksandqueues.queueusingstacks;

// Importing the stack for using methods
import java.util.Stack;

// Class representing a queue implemented using two stacks
class StackQueue {
	// Stack used for enqueue operations
	private Stack<Integer> stackEnqueue;

	// Stack used for dequeue operations
	private Stack<Integer> stackDequeue;

	// Constructor to initialize the two stacks
	public StackQueue() {
		stackEnqueue = new Stack<>();
		stackDequeue = new Stack<>();
	}

	// Method to add an element to the queue
	public void enqueue(int value) {
		stackEnqueue.push(value);
	}

	// Method to remove and return an element from the front of the queue
	public int dequeue() {
		// Checks if both stacks are empty
		if (stackEnqueue.isEmpty() && stackDequeue.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}

		// If the dequeue stack is empty, transfer all elements from enqueue stack
		if (stackDequeue.isEmpty()) {
			while (!stackEnqueue.isEmpty()) {
				stackDequeue.push(stackEnqueue.pop());
			}
		}

		// Pop the top element from the dequeue stack
		return stackDequeue.pop();
	}

	// Method to check if the queue is empty
	public boolean isEmpty() {
		// Returns true if both stacks are empty, otherwise false
		return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
	}

	// Method to return the front element of the queue without removing it
	public int peek() {
		// Checks if both stacks are empty
		if (stackEnqueue.isEmpty() && stackDequeue.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}

		// Transfers elements from enqueue stack to dequeue stack if needed
		if (stackDequeue.isEmpty()) {
			while (!stackEnqueue.isEmpty()) {
				stackDequeue.push(stackEnqueue.pop());
			}
		}

		// Returns the top element from the dequeue stack
		return stackDequeue.peek();
	}

	// Method to display all elements of the queue
	public void display() {
		// Checks if both stacks are empty
		if (stackEnqueue.isEmpty() && stackDequeue.isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		// Temporary stack to store elements in correct order
		Stack<Integer> tempStack = new Stack<>();

		// Transfers elements from dequeue stack to temporary stack to maintain order
		for (Integer item : stackDequeue) {
			tempStack.push(item);
		}

		// Transfers elements from enqueue stackFF to temporary stack
		Stack<Integer> reverseEnqueue = new Stack<>();
		for (Integer item : stackEnqueue) {
			reverseEnqueue.push(item);
		}
		while (!reverseEnqueue.isEmpty()) {
			tempStack.push(reverseEnqueue.pop());
		}

		// Displays elements in correct queue order
		System.out.print("Queue Elements: ");
		while (!tempStack.isEmpty()) {
			System.out.print(tempStack.pop() + " ");
		}
		System.out.println();
	}
}


