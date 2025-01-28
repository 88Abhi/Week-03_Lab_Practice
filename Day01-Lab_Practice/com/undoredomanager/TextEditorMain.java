package com.undoredomanager;

// TextEditorMain class to demonstrate the Undo/Redo functionality in the text editor
public class TextEditorMain {
	public static void main(String[] args) {
		// Initializes the TextEditor instance
		TextEditor editor = new TextEditor();

		// Adds multiple text states as the user types
		editor.addTextState("1. Hello");
		editor.addTextState("2. Hello, World!");
		editor.addTextState("3. Hello, World! How are you?");
		editor.addTextState("4. Hello, World! How are you doing today?");

		// Displays the current text state
		editor.displayCurrentState();

		// Performs an undo operation
		editor.undo();
		editor.displayCurrentState();

		// Performs another undo operation
		editor.undo();
		editor.displayCurrentState();

		// Performs a redo operation
		editor.redo();
		editor.displayCurrentState();

		// Adds a new text state after undo
		editor.addTextState("5. Hello, World! How have you been?");
		editor.displayCurrentState();

		// Tries multiple undo operations to test the limit
		for (int i = 0; i < 5; i++) {
			editor.undo();
			editor.displayCurrentState();
		}

		// Tries multiple redo operations
		for (int i = 0; i < 5; i++) {
			editor.redo();
			editor.displayCurrentState();
		}
	}
}
