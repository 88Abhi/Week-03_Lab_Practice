package com.socialmedia;

// SocialMediaMain class to demonstrate social media friend connections
public class SocialMediaMain {
	public static void main(String[] args) {
		// Initializes the SocialMediaFriendManager
		SocialMediaFriendManager manager = new SocialMediaFriendManager();

		// Adds new users to the system
		manager.addUser(1, "Abhishek", 20);
		manager.addUser(2, "Ajeet", 22);
		manager.addUser(3, "Amit", 21);

		// Adds friend connections between users
		manager.addFriendConnection(1, 2);
		manager.addFriendConnection(2, 3);

		// Displays the friends of user 1 and user 2
		System.out.println("Friends of specific user ids:");
		manager.displayFriends(1);
		manager.displayFriends(2);

		// Finds and displays mutual friends between user 1 and user 3
		manager.findMutualFriends(1, 3);

		// Counts and displays the number of friends for each user
		System.out.println("\nCount of friends of each user: ");
		manager.countFriends();

		System.out.println("\nSearching for user by ID or Name:");
		manager.searchUser("Abhishek");
		manager.searchUser("3");

		// Removes the friend connection between user 1 and user 2
		manager.removeFriendConnection(1, 2);

		manager.displayFriends(3);
		System.out.println("\nAfter removing connection of user 1 & 2: ");
		System.out.println("\nCount of friends of each user: ");
		manager.countFriends();
	}
}
