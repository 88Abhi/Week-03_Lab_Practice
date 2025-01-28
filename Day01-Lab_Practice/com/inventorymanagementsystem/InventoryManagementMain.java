package com.inventorymanagementsystem;

// InventoryManagementMain class to test the inventory management system
class InventoryManagementMain {
	public static void main(String[] args) {
		// Creates an instance of the inventory management system
		InventoryManagementSystem inventory = new InventoryManagementSystem();

		// Adds sample items to the inventory
		System.out.println("Added items in the inventory");
		inventory.addAtBeginning("Laptop", 101, 5, 75000);
		inventory.addAtEnd("Smartphone", 102, 10, 30000);
		inventory.addAtPosition("Tablet", 103, 7, 20000, 2);

		// Sort them in ascending order
		inventory.sortInventoryByItemId();

		// Displays the inventory list
		inventory.displayInventory();

		// Updates the quantity of an item
		System.out.println("\nUpdating quantity of item which have id 102: ");
		inventory.updateQuantity(102, 12);

		// Displays the inventory list
		inventory.displayInventory();

		// Removes an item by ID
		System.out.println("\nRemoving item from inventory of id 103: ");
		inventory.removeItem(103);

		// Displays the inventory list
		inventory.displayInventory();

		// Displays the total value of the inventory
		System.out.println("\nTotal Inventory Value: " + inventory.calculateTotalValue());

		// Searches for an item and displays details if found
		InventoryNode foundItem = inventory.searchByItemId(101);
		if (foundItem != null) {
			System.out.println("\nItem Found: " + foundItem.itemName);
		}
	}
}



