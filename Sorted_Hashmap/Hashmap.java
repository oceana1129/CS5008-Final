import java.util.Comparator;

/**
 * a class which represents a generic hashmap structure
 */
public class Hashmap<K, V> implements iHashmap<K, V>{
    // constants for the hashmap
    private static final int DEFAULT_CAPACITY = 100;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // attributes of the hashmap
    private int capacity;                       // capacity of the hash map
    private float loadFactor;                   // load factor for resizing
    private int size;                           // key-value pairs in the map
    private Node<K, V>[] table;                 // array to store the hash map entries
    private Comparator<K> comparator;           // comparator for sorting keys

    /**
     * private static class representing a node in the hashmap
     *
     * @param <K> the key of the entry
     * @param <V> the value associated with the key
     */
    private static class Node<K, V> {
        final K key;                            // key of the node
        V value;                                // value associated with the key
        Node<K, V> next;                        // reference to next node
                                                // available in case there is more than one value associated with a key

        /**
         * constructor to initialize a node
         * @param key the key of the node
         * @param value the value associated with the key
         * @param next  reference to the next node
         */
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * constructor to make a hash map with the default capacity and load factor
     */
    public Hashmap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR, null);
    }

    /**
     * constructor to make a hashmap with a specified capacity and load factor
     *
     * @param capacity the capacity of the hash map
     * @param loadFactor the load factor for resizing
     */
    public Hashmap(int capacity, float loadFactor, Comparator<K> comparator) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.comparator = comparator;
        this.table = (Node<K, V>[]) new Node[capacity]; // initialize the table array
    }


    /**
     * create the hash value for a key as an int
     *
     * @param key the specified key
     * @return a has value associated with the key
     */
    public int hash(K key) {
        if (key == null) {                              // null values can be saved as a key
            return 0;                                   // null must return a zero
        }
        return Math.abs(key.hashCode()) % capacity;     // create the hashcode based on the hashmap capacity
    }


    /**
     * compare two keys using a comparator,
     * otherwise use natural ordering
     *
     * @param key1 the first key to compare
     * @param key2 the second key to compare
     * @return a negative if less than, zero if equal, or a positive if greater than the second
     */
    private int compareKeys(K key1, K key2) {
        int hashCode1 = key1.hashCode();
        int hashCode2 = key2.hashCode();

        // if hashmaps of the two keys are the same then return 0
        // if hashmap of key2 is less than key1 then return -1
        // if hashmap of key2 is greater than key1 then return 1
        return Integer.compare(hashCode2, hashCode1);
    }

    /**
     * put a key value pair into the hashmap
     * will make sure the key is added to the correct index
     * if the key doesn't exist then create a new node
     * and update the hashmap size if necessary
     *
     * @param key the key of the entry
     * @param value the value associated with the key
     */
    @Override
    public void put(K key, V value) {
        int index = hash(key);                                              // get the hash value for the key
        Node<K, V> node = table[index];                                     // get the node at the specific index
        Node<K, V> prev = null;

        
        while (node != null && compareKeys(node.key, key) != 0) {           // traverse until key is found or at the end of the linked list
            prev = node;
            node = node.next;
        }

        if (node != null && compareKeys(node.key, key) == 0) {              // key exists, add the new value to the existing list of values
                                                                            // traverse the list of values to check if the value already exists
            Node<K, V> valueNode = node;
            while (valueNode != null && !valueNode.value.equals(value)) {
                prev = valueNode;
                valueNode = valueNode.next;
            }

            if (valueNode == null) {                                        // If value doesn't exist, add it to the list
                prev.next = new Node<>(key, value, null);
            }
        }
        else {                                                              // KEY DOESN'T EXIST
                                                                            // create a new node for the key-value pair
            Node<K, V> newNode = new Node<>(key, value, null);

            if (prev == null) {
                table[index] = newNode;                                     // new node becomes the head
            } else {
                prev.next = newNode;                                        // Iisert the new node after prev
            }

            size++;                                                         // INCREASE SIZE

            if (size > capacity * loadFactor) {                             // IF RESIZE IS NECESSARY
                resize();                                                   // then resize the hashmap
            }
        }
    }



    /**
     * get the associate value from the key within the hash map
     *
     * @param key the key we are searching for
     * @return return the value of the key
     */
    @Override
    public V get(K key) {
        int index = hash(key);                      // get the hash value for the key
        Node<K, V> node = table[index];             // get the node at the index

        StringBuilder values = new StringBuilder();  // StringBuilder to concatenate values
        while (node != null) {                      // TRAVERSE LINKED LIST AT SPECIFIED INDEX
            if (compareKeys(node.key, key) == 0) {  // KEY IS FOUND
                values.append(node.value).append(", "); // append value to StringBuilder
            }
            node = node.next;                       // move to the next node
        }
        if (values.length() > 0) {                  // remove the trailing comma and space

            values.setLength(values.length() - 2);
            return (V) values.toString(); // return the concatenated values
        }
        return null;                                // KEY IS NOT FOUND
    }

    /**
     * remove a key value pair from the hashmap
     *
     * @param key the key value
     * @return the value of the removed node
     */
    @Override
    public V remove(K key) {
        int index = hash(key);                      // get the hash value for the key

        Node<K, V> node = table[index];             // get the node at the computed index
        Node<K, V> prev = null;                     // reference to the previous node

        while (node != null && compareKeys(node.key, key) != 0) {
            prev = node;
            node = node.next;
        }

        if (node == null) {
            return null;                            // KEY IS NOT FOUND
        }

        V removedValue = node.value;

        if (prev == null) {
            table[index] = node.next;
        }
        else {
            prev.next = node.next;
        }

        size--;
        return removedValue;
    }

    /**
     * will remove every entry from the map
     */
    @Override
    public void remove() {
        table = (Node<K, V>[]) new Node[capacity];  // set the table to a new empty table
        size = 0;                                   // set the current size to zero
    }

    /**
     * resize the hash map if the load factor exceeds the current threshold
     * doubles the capacity of the hashmap and rehashes the entries
     */
    private void resize() {
        int newCapacity = capacity * 2;             // double the new size
        Node<K, V>[] newTable = new Node[newCapacity]; // create a new table with the new current size

        for (int i = 0; i < capacity; i++) {        // ITERATE THROUGH CURRENT TABLE
            Node<K, V> node = table[i];             // get the node at the current index of the current table

            while (node != null) {                      // ITERATE THROUGH LINKED LIST AT THE INDEX
                Node<K, V> next = node.next;            // store the next node
                int index = hash(node.key);             // get the index for the node based on its key
                                                        // update values for the new table
                node.next = newTable[index];            // update next node at the index
                newTable[index] = node;                 // update table index with node
                node = next;                            // continue traversal with next node
            }
        }
        table = newTable;                           // update the current table with the new table
        capacity = newCapacity;                     // change the current size to the new size
    }

    /**
     * will determine whether a key is found in the current hashmap
     *
     * @param key the key value
     * @return a boolean indicating if the key is in the hashmap
     */
    @Override
    public boolean containKey(K key) {
        return get(key) != null;
    }

    /**
     * return the size of the hashmap
     *
     * @return the size of the current hashmap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * will return whether the current hashmap is empty or not
     *
     * @return a boolean if the current hashmap is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * will return a string representing the current hashmap
     * if the hashmap is empty, it will return a specific string
     * otherwise, it will create a string with the key value pairs
     *
     * @return a string representing the current hashmap
     */
    @Override
    public String toString() {
        if (isEmpty() || table == null) {           // if table is null or empty
            return "Hashmap is empty.";
        }

        StringBuilder sb = new StringBuilder();     // set up a string builder
        sb.append("{\n");                             // add curly brace to beginning

        // Iterate through the table and append key-value pairs to the StringBuilder
        for (int i = 0; i < capacity; i++) { // ITERATE THROUGH CURRENT TABLE
            Node<K, V> node = table[i];
            if (node != null) {
                sb.append("  \"").append(node.key).append("\": [");
                boolean isFirst = true;
                while (node != null) { // ITERATE THROUGH LINKED LIST AT THE INDEX
                    if (!isFirst) {
                        sb.append(", ");
                    }
                    sb.append("\"").append(node.value).append("\"");
                    node = node.next; // set the node to next
                    isFirst = false;
                }
                sb.append("],\n");
            }
        }

        // Remove the trailing comma and new line if there are elements
        if (sb.length() > 3) { // Check if there are elements to trim
            sb.setLength(sb.length() - 2); // Remove the last comma and new line
        }

        sb.append("\n}");                             // add curly brace to end
        return sb.toString();                       // return the string
    }
}
