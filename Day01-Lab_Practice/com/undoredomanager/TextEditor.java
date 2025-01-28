package com.undoredomanager;

// Class that manages the Undo/Redo functionality for the text editor
class TextEditor {
	// Stores the reference to the current state in the doubly linked list
	private TextStateNode currentState;

	// Stores the head of the doubly linked list (oldest state)
	private TextStateNode head;

	// Stores the tail of the doubly linked list (latest state)
	private TextStateNode tail;

	// Stores the total number of saved states
	private int size;

	// Defines the maximum number of states allowed in history
	private static final int MAX_HISTORY = 10;

	// Constructor to initialize the text editor with an empty state
	public TextEditor() {
		// Initializes head, tail, and current state as null
		this.head = null;
		this.tail = null;
		this.currentState = null;

		// Initializes the size as zero
		this.size = 0;
	}

	// Adds a new text state when the user types or performs an action
	public void addTextState(String newText) {
		// Creates a new text state node with given content
		TextStateNode newNode = new TextStateNode(newText);

		// Checks if there are no existing states
		if (currentState == null) {
			// Sets the new node as the head, tail, and current state
			head = newNode;
			tail = newNode;
			currentState = newNode;
			size = 1;
			return;
		}

		// If new text is added after an undo operation, clears forward history
		if (currentState.next != null) {
			currentState.next = null;
		}

		// Links the new node to the current state
		newNode.prev = currentState;
		currentState.next = newNode;

		// Updates the current state to the new node
		currentState = newNode;

		// Updates the tail to the new node
		tail = newNode;

		// Increments the size of the history
		size++;

		// Checks if the history size exceeds the maximum limit
		if (size > MAX_HISTORY) {
			head = head.next;
			head.prev = null;
			size--;
		}
	}

	// Implements the undo functionality
	public void undo() {
		// Checks if there is a previous state available
		if (currentState != null && currentState.prev != null) {
			currentState = currentState.prev;
		}
	}

	// Implements the redo functionality
	public void redo() {
		// Checks if there is a next state available
		if (currentState != null && currentState.next != null) {
			currentState = currentState.next;
		}
	}

	// Displays the current state of the text in the editor
	public void displayCurrentState() {
		// Checks if there is an active state
		if (currentState != null) {
			System.out.println("Current Text: " + currentState.text);
		}
		else {
			System.out.println("No text available.");
		}
	}
}
