package com.inventorymanagementsystem;

// Class representing a node in the singly linked list
class InventoryNode {
	// Stores the name of the item
	String itemName;
	// Stores the unique ID of the item
	int itemId;
	// Stores the quantity of the item
	int quantity;
	// Stores the price of a single unit of the item
	double price;
	// Pointer to the next node in the linked list
	InventoryNode next;

	// Constructor to initialize the inventory node with given values
	public InventoryNode(String itemName, int itemId, int quantity, double price) {
		this.itemName = itemName;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}
}
