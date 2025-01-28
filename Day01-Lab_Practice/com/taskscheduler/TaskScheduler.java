package com.taskscheduler;

// Manages task scheduling using a circular linked list
class TaskScheduler {
	// Points to the head of the circular linked list
	private TaskNode head;

	// Points to the last node to maintain circular linking
	private TaskNode tail;

	// Constructor to initialize an empty circular linked list
	public TaskScheduler() {
		this.head = null;
		this.tail = null;
	}

	// Adds a new task at the beginning of the circular linked list
	public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
		TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

		// Checks if the list is empty
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
			return;
		}

		// Sets the new node's next pointer to the current head
		newNode.next = head;

		// Updates the tail’s next pointer to maintain circular linking
		tail.next = newNode;

		// Updates the head pointer to the new node
		head = newNode;
	}

	// Adds a new task at the end of the circular linked list
	public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
		TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

		// Checks if the list is empty
		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
			return;
		}

		// Sets the new node’s next pointer to the head to maintain circular linking
		newNode.next = head;

		// Updates the current tail’s next pointer to the new node
		tail.next = newNode;

		// Updates the tail pointer to the new node
		tail = newNode;
	}

	// Adds a new task at a specific position in the circular linked list
	public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
		TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

		// Checks if the list is empty or position is 1 (insert at beginning)
		if (position == 1 || head == null) {
			addTaskAtBeginning(taskId, taskName, priority, dueDate);
			return;
		}

		TaskNode temp = head;
		int count = 1;

		// Traverses the list to find the position before insertion
		while (count < position - 1 && temp.next != head) {
			temp = temp.next;
			count++;
		}

		// Inserts the new node at the specified position
		newNode.next = temp.next;
		temp.next = newNode;

		// Updates the tail if inserted at the end
		if (newNode.next == head) {
			tail = newNode;
		}
	}

	// Removes a task by its Task ID from the circular linked list
	public void removeTaskById(int taskId) {
		// Checks if the list is empty
		if (head == null) {
			return;
		}

		// Checks if the head node contains the task ID
		if (head.taskId == taskId) {
			if (head == tail) {
				head = null;
				tail = null;
				return;
			}

			// Updates the head and maintains circular linking
			head = head.next;
			tail.next = head;
			return;
		}

		TaskNode temp = head;
		TaskNode prev = null;

		// Traverses the list to find the task before the target node
		do {
			prev = temp;
			temp = temp.next;

			// If task is found, remove it
			if (temp.taskId == taskId) {
				prev.next = temp.next;

				// Updates the tail if the last node is removed
				if (temp == tail) {
					tail = prev;
				}
				return;
			}
		}
		while (temp != head);
	}

	// Views the current task and moves to the next task in the circular list
	public void viewCurrentAndMoveToNext() {
		// Checks if the list is empty
		if (head == null) {
			return;
		}

		TaskNode current = head;

		// Displays each task in order
		do {
			System.out.println("Current Task: Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
			current = current.next;
		}
		while (current != head);
	}

	// Displays all tasks in the circular linked list starting from the head node
	public void displayAllTasks() {
		// Checks if the list is empty
		if (head == null) {
			return;
		}

		TaskNode temp = head;

		// Traverses and prints each task, looping back to the head
		do {
			System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
			temp = temp.next;
		}
		while (temp != head);
	}

	// Searches for a task by priority and displays all tasks with the given priority
	public void searchTaskByPriority(int priority) {
		// Checks if the list is empty
		if (head == null) {
			return;
		}

		TaskNode temp = head;
		boolean found = false;

		// Traverses the list to find tasks with the specified priority
		do {
			if (temp.priority == priority) {
				System.out.println("Task Found: Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
				found = true;
			}
			temp = temp.next;
		}
		while (temp != head);

		// If no task is found, prints a message
		if (!found) {
			System.out.println("No tasks found with priority " + priority);
		}
	}
}

