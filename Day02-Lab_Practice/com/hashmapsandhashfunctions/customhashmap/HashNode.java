package com.hashmapsandhashfunctions.customhashmap;

// Class representing a key-value pair in the hash map
class HashNode<K, V> {

	// Stores the key of the node
	K key;

	// Stores the value of the node
	V value;

	// Pointer to the next node
	HashNode<K, V> next;

	// Constructor to initialize a hash node with key and value
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
}