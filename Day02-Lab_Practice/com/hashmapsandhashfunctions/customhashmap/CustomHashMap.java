package com.hashmapsandhashfunctions.customhashmap;

import java.util.ArrayList;
import java.util.List;

// Class implementing the custom hash map
class CustomHashMap<K, V> {
	// Defines the default capacity of the hash map
	private static final int DEFAULT_CAPACITY = 10;

	// Defines the load factor threshold for resizing
	private static final double LOAD_FACTOR_THRESHOLD = 0.7;

	// Stores an array of linked lists
	private List<HashNode<K, V>> bucketArray;

	// Stores the current size and capacity of hash  map
	private int size;
	private int capacity;

	// Constructor to initialize the hash map with the default capacity
	public CustomHashMap() {
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
		this.bucketArray = new ArrayList<>(capacity);

		// Initializes each bucket with null
		for (int i = 0; i < capacity; i++) {
			bucketArray.add(null);
		}
	}

	// Method to compute the hash index for a given key
	private int getBucketIndex(K key) {
		return Math.abs(key.hashCode() % capacity);
	}

	// Method to insert or update a key-value pair in the hash map
	public void put(K key, V value) {
		// Computes the index in the bucket array
		int index = getBucketIndex(key);

		// Retrieves the head of the linked list
		HashNode<K, V> head = bucketArray.get(index);

		// Iterates through the linked list
		while (head != null) {
			if (head.key.equals(key)) {
				// Updates the value if the key is found
				head.value = value;
				return;
			}
			head = head.next;
		}

		// Creates a new hash node with the given key-value pair
		HashNode<K, V> newNode = new HashNode<>(key, value);

		// Retrieves the head node again
		head = bucketArray.get(index);

		// Inserts the new node at the beginning
		newNode.next = head;

		// Updates the bucket with the new node as the head
		bucketArray.set(index, newNode);
		size++;

		// Checks if resizing is needed
		if ((1.0 * size) / capacity >= LOAD_FACTOR_THRESHOLD) {
			resize();
		}
	}

	// Method to retrieve a value based on the given key
	public V get(K key) {
		// Computes the index in the bucket array
		int index = getBucketIndex(key);

		// Retrieves the head of the linked list
		HashNode<K, V> head = bucketArray.get(index);

		// Iterates through the linked list to find the key
		while (head != null) {
			if (head.key.equals(key)) {
				// Returns the value if the key is found
				return head.value;
			}
			head = head.next;
		}

		// Returns null if the key does not exist
		return null;
	}

	// Method to remove a key-value pair from the hash map
	public void remove(K key) {
		// Computes the index in the bucket array
		int index = getBucketIndex(key);

		// Retrieves the head of the linked list
		HashNode<K, V> head = bucketArray.get(index);

		// Stores the previous node while traversing the linked list
		HashNode<K, V> previous = null;

		// Iterates through the linked list to find the key
		while (head != null) {
			if (head.key.equals(key)) {
				if (previous != null) {
					// Removes the node by passing it in the linked list
					previous.next = head.next;
				}
				else {
					// Updates the bucket head
					bucketArray.set(index, head.next);
				}
				size--;

				// Exits after removing the key-value pair
				return;
			}

			// Updates the previous node
			previous = head;

			// Moves to the next node
			head = head.next;
		}
	}

	// Method to resize the hash map when the load factor exceeds the threshold
	private void resize() {
		// Stores the current bucket array
		List<HashNode<K, V>> oldBucketArray = bucketArray;

		// Doubles the capacity of the hash map
		capacity *= 2;

		// Resets the size and initializes a new bucket array
		size = 0;
		bucketArray = new ArrayList<>(capacity);

		// Initializes each bucket with null
		for (int i = 0; i < capacity; i++) {
			bucketArray.add(null);
		}

		// Iterates through the old bucket array to rehash all key-value pairs
		for (HashNode<K, V> headNode : oldBucketArray) {
			while (headNode != null) {
				put(headNode.key, headNode.value);
				headNode = headNode.next;
			}
		}
	}

	// Method to get the current size of the hash map
	public int size() {
		return size;
	}
}
