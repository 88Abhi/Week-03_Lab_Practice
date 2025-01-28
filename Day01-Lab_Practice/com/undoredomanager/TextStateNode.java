package com.undoredomanager;

// Class representing a node in the doubly linked list, storing a text state
class TextStateNode {
	// Stores the text content of the current state
	String text;

	// Stores the reference to the previous state (undo operation)
	TextStateNode prev;

	// Stores the reference to the next state (redo operation)
	TextStateNode next;

	// Constructor to initialize a text state node with given content
	public TextStateNode(String text) {
		// Initializes the text content
		this.text = text;

		// Sets the previous and next states as null
		this.prev = null;
		this.next = null;
	}
}
