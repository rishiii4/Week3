package hashmap.customhashmap;

import java.util.LinkedList;

public class CustomHashMap<K, V> {

    // Inner class representing a key-value pair
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16; // Default size of the hash table
    private LinkedList<Entry<K, V>>[] buckets; // Array of linked lists for separate chaining
    private int size;

    // Constructor initializing the hash table with default capacity
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Computes the index for a given key
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Inserts or updates a key-value pair in the hash map
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key's value
                return;
            }
        }

        bucket.add(new Entry<>(key, value)); // Add new key-value pair
        size++;
    }

    // Retrieves a value by key, returns null if key is not found
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    // Removes a key-value pair from the hash map
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry); // Remove the key-value pair
                size--;
                return;
            }
        }
    }

    //Returns the number of elements in the hash map
    public int size() {
        return size;
    }

    //Checks if the hash map contains a given key
    public boolean containsKey(K key) {
        return get(key) != null;
    }


    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'two': " + map.get("two"));

        map.remove("two");

        System.out.println("Contains 'two'? " + map.containsKey("two"));
        System.out.println("Size: " + map.size());
    }
}

