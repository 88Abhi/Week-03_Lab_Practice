package com.studentrecordmanagement;

// Represents a single student record in a singly linked list.
class StudentNode {
	// Declares the roll number and age of the student
	int rollNumber;
	int age;

	// Declares the name and grade of the student
	String name;
	String grade;

	// Declares a pointer to the next node in the linked list
	StudentNode next;

	// Constructor to initialize a student node with given values
	public StudentNode(int rollNumber, String name, int age, String grade) {
		// Initializing values to instance variables
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
		this.grade = grade;

		// Initializes next pointer as null (end of list)
		this.next = null;
	}
}

