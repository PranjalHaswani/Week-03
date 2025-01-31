package com.day2;
import java.util.LinkedList;

class HashMap<K, V> {

    private static final int DEFAULT_CAPACITY =16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    // Entry class to hold key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        table = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Hash function to compute the index
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }


    // Insertion
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if key already exists, update the value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update the value
                return;
            }
        }

        // Otherwise, add new entry
        bucket.add(new Entry<>(key, value));
        size++;
    }

    // Retrieval
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value; // Return value if found
            }
        }
        return null; // Return null if key not found
    }

    // Deletion
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry); // Remove entry
                size--;
                return;
            }
        }
    }

    // Size of the hash map
    public int size() {
        return size;
    }

    // Check if the hash map is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Display the content of the hash map
    public void display() {
        for (int i = 0; i < table.length; i++) {
            if (table[i].size() > 0) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }
}
public class CustomHashMap{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        System.out.println("Size: " + map.size());
        map.display();

        System.out.println("Bob's age: " + map.get("Bob"));

        map.remove("Alice");
        System.out.println("After removal of Alice:");
        map.display();

        System.out.println("Is empty: " + map.isEmpty());
    }
}