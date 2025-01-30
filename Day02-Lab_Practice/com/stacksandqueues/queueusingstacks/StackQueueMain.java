package com.stacksandqueues.queueusingstacks;

// Class to test the StackQueue implementation
class StackQueueMain {
	public static void main(String[] args) {
		// Creates an instance of the queue
		StackQueue queue = new StackQueue();

		// Enqueues elements into the queue
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		// Displays all elements in the queue
		queue.display();

		// Displays the front element without removing it
		System.out.println("Front element: " + queue.peek());

		// Dequeues elements from the queue and prints them
		System.out.println("Dequeued: " + queue.dequeue());
		System.out.println("Dequeued: " + queue.dequeue());

		// Displays all elements in the queue after some dequeues
		queue.display();

		// Displays the front element after some dequeues
		System.out.println("Front element after dequeues: " + queue.peek());
	}
}