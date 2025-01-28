package com.studentrecordmanagement;

// Manages student records using a singly linked list.
class StudentRecordList {
	// Declares the head of the linked list
	private StudentNode head;

	// Constructor to initialize an empty linked list
	public StudentRecordList() {
		// Initializes head as null
		this.head = null;
	}

	// Adds a new student record at the beginning of the linked list
	public void addAtBeginning(int rollNumber, String name, int age, String grade) {
		// Creates a new student node with given details
		StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

		// Sets new node's next pointer to the current head
		newNode.next = head;

		// Updates head to point to the new node
		head = newNode;
	}

	// Adds a new student record at the end of the linked list
	public void addAtEnd(int rollNumber, String name, int age, String grade) {
		// Creates a new student node with given details
		StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

		// Checks if the list is empty
		if (head == null) {
			head = newNode;
			return;
		}

		// Initializes a temporary pointer to traverse the list
		StudentNode temp = head;

		// Traverses the list until the last node
		while (temp.next != null) {
			temp = temp.next;
		}

		// Updates the last node's next pointer to the new node
		temp.next = newNode;
	}

	// Deletes a student record by roll number
	public void deleteByRollNumber(int rollNumber) {
		// Checks if the list is empty
		if (head == null) {
			return;
		}

		// Checks if the first node contains the roll number
		if (head.rollNumber == rollNumber) {
			head = head.next;
			return;
		}

		// Initializes a temporary pointer to find the node
		StudentNode temp = head;

		// Traverses the list to find the node before the target node
		while (temp.next != null && temp.next.rollNumber != rollNumber) {
			temp = temp.next;
		}

		// Checks if the target node is found
		if (temp.next != null) {
			temp.next = temp.next.next;
		}
	}

	// Searches for a student record by roll number
	public StudentNode searchByRollNumber(int rollNumber) {
		// Initializes a temporary pointer to traverse the list
		StudentNode temp = head;

		// Traverses the list to find the target roll number
		while (temp != null) {
			if (temp.rollNumber == rollNumber) {
				return temp;
			}

			// Moves to the next node
			temp = temp.next;
		}

		// Returns null if no match is found
		return null;
	}

	// Updates a student's grade based on roll number
	public void updateGrade(int rollNumber, String newGrade) {
		// Calls the search method to find the student
		StudentNode student = searchByRollNumber(rollNumber);

		// Checks if the student exists
		if (student != null) {
			student.grade = newGrade;
		}
	}

	// Displays all student records in the linked list
	public void displayRecords() {
		// Initializes a temporary pointer to traverse the list
		StudentNode temp = head;

		// Traverses the list until the end and print details
		while (temp != null) {
			System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
			temp = temp.next;
		}
	}
}
