# Research Paper

- Name: Oceana Gershberg
- Semester: Spring 2024
- Topic: Sorted Hashmap
- Link The Repository: https://github.com/Sp24-CS5008-Online-Lionelle/final-reseach-paper-oceana1129

Note the following is an example outline to help you. Please rework as you need.

## Introduction

The algorithm selected for this project is a Sorted Hashmap. If you are familiar with dictionaries in languages such as Python, you could draw many similarities. Dictionaries and hashmaps rely on the abstract data type 'Map'. A map associates keys to values. Keys must be unique, but the associated values do not have to be. For now, we shall be focusing on describing the history of the hashmap and how it works.

### A Brief History

<div style="text-align: center;">
    <img src="https://iq.opengenus.org/content/images/2020/01/Hans_Peter_Luhn_opengenus.jpg" alt="Hans Peter Luhn, the Man behind Hash Map" width="400"/>
</div>

According to "Hans Peter Luhn, the man behind Hash Map" on OpenGenus IQ (n.d.), the hashmap was first made by a computer scientist named Hans Peter Luhn. In 1941, he joined IBM as a researcher responsible with the task of handling large sets of data that can be searched with text. In 1950, he ended up developing an algorithm which he called "Key Word in Context". It could take in a large amount of text and quickly generate an index of words which could be used to search for the text. And it was done so by mapping text to buckets to make them faster to search. Over the years, this concept would be improved into both the system of hashing and hashmaps that we use today.

### How It Is Used Today

Because of the overall efficiency of sorted hashmaps, they are commonly used in a variety of applications. Most commonly, they can be found to help index databases through a database management system (DBMS). They can help quickly index information. This implementation can be seen in relational databases such as MySQL and PostgreSQL. Though, it's important to distinguish that MySQl uses a B-tree implementation and PostgreSQL uses a B-tree variant called B+ trees (Comparison of B-Tree and Hash Indexes, n.d.).

They can also be found in search engines to store and retrieve information efficiently. This can be seen in how web pages and any relevant web pages are stored in a search engine algorithm. It can also show these web pages through whichever are the most related to one another. Other applications include file sustems network routing.

Overall, the ultimate take away is the importance of sorted hashmaps for their efficiency in retrieval and storage. Because the algorithm can handle a variety of operations like sorting, and filtering these reasons ultimately make hashmaps great for performance and scalability. Let's explore how this algorithm works in the first place.

### How Does It Work?

A hashmap is a data structure that relies on a key-value pair mapping. A key represents a specified value where items will be stored. And a value represents the object or data to be stored under that key.

To demonstrate the logic of a hashmap, let's explore an example. Let's say we wanted to build a hashmap and base it off of a Cat adoption center. We want to organize our keys based off of the breed of the cat being entered. Here are some examples of cat breeds: Persian, Ragdoll, Sphynx, Siamese, and unknown (or null). For each breed, there are different cats of that breed.

We would build an array based on the number of cat breeds we are expecting to have. And for each spot in the array, we simply need to match a key to an array index. We determine where keys will go based on the keys hashcode. A hashcode is an interger value which is used for high speed storage and retrieval of information (Deitel & Deitel 2018, p. 399). The hascode of a key is determined by the use of a hash function. The has function will create a psuedo number, and a modular of the index of the array will determine where that number will go.

So for example, we will convert the cat breeds into a hashcode, and mod it by the size of our array, we would get this:

<div style="text-align: center;">
    <img src="https://res.cloudinary.com/oceana-web-designs/image/upload/v1713657983/Key_Hashcodes_upv9oy.png" alt="Keys turned into hashcodes" width="600"/>
</div>

Now when we add more values to the keys, we will be able to organize it based on a hashcode value. And now we can also access the index of a key based on the same process.

What happens when we add more values to a single key? This varies depending on your implementation of a hash map. But in our project, we use a list to store, what are called, hashmap collissions. So if there are multiple values under a key, the values are added together in a list structure.

For our cat breed example, it would look something like this:

<div style="text-align: center;">
    <img src="https://res.cloudinary.com/oceana-web-designs/image/upload/v1713657985/Keys_Values_wkqcsa.png" alt="Hashmap keys with multiple values" width="600"/>
</div>

To make the hashmap sorted, we need to employ a Comparator, which specifies the orders the keys go into.

Overall, a hashmap works as a very simple and efficient way to get access to an object or piece of data quickly and efficiently.

## Analysis of Algorithm

The time complexity of a sorted hashmap can vary depending on the implementation of the structure and it's function. In general, here are the common time complexity of its operations based on whether the implementation used open addressing or closed addressing. Open addressing is when, in a hashmap, collission occurs the algorithm will search for an empty spot to put the colliding element. Closed addressing is when a collission occurs and each value for the key is added to a 'bucket' in the form of a linked list or list.

### Open Addressing Table Time Complexity

| Activity             | Best Case Complexity | Average Case Complexity | Worst Case Complexity |
| -------------------- | -------------------- | ----------------------- | --------------------- |
| **Searching**        | $O(1)$               | $O(1)$                  | $O(n)$                |
| **Insertion**        | $O(1)$               | $O(1)$                  | $O(n)$                |
| **Deletion**         | $O(1)$               | $O(1)$                  | $O(n)$                |
| **Space Complexity** | $O(n)$               | $O(n)$                  | $O(n)$                |

### Closed Addressing Table Time Complexity

| Activity             | Best Case Complexity | Average Case Complexity | Worst Case Complexity |
| -------------------- | -------------------- | ----------------------- | --------------------- |
| **Searching**        | $O(1)$               | $O(1)$                  | $O(n)$                |
| **Insertion**        | $O(1)$               | $O(1)$                  | $O(n)$                |
| **Deletion**         | $O(1)$               | $O(1)$                  | $O(n)$                |
| **Space Complexity** | $O(m+n)$             | $O(m+n)$                | $O(m+n)$              |

_... where m is the size of the hash table and n is the number of items inserted (Iyer, n.d)_

While the average space complexity for a hashmap is $O(n)$.

## Empirical Analysis

When runnning a time analysis on the provided code, we were able to return the following set of data. In ns, nano seconds, we are able to determine the speed of the insertion time, retrieval time, and deletion time in our sorted hashmap with closed addressing. This is done through the [Analysis File](Sorted_Hashmap/Analysis.java), which pulls random numbers to run the hashmap program.

The following empirical numbers can be seen below:

| Number of Tests | Insertion Time (ns) | Retrieval Time (ns) | Deletion Time (ns) |
| --------------- | ------------------- | ------------------- | ------------------ |
| 10              | 55900               | 63100               | 14000              |
| 100             | 116200              | 154600              | 36500              |
| 1000            | 459400              | 539800              | 109100             |
| 10000           | 1999300             | 2009500             | 588700             |
| 100000          | 9768000             | 10403100            | 2489600            |
| 1000000         | 67790700            | 49262400            | 10321500           |
| 10000000        | 526339800           | 340257000           | 50544400           |
| 100000000       | 4360996000          | 2753334100          | 521110900          |

The following data can also be viewed as a graph chart:

<div style="padding: 5px 20px">
    <img src="https://res.cloudinary.com/oceana-web-designs/image/upload/v1713674405/sorted_hashmap_time_complexity_analysis_vfilip.png" alt="Empirical Analysis of Hashmap Data" width="600"/>
</div>

As we can see from our data, the algorithm demonstrates a linear time complexity. As the number of tests increase, so does the time to handle the tests in a linear time complexity. It appears that insertion time had the highest time complexity, retrieval had the middle most time complexity, and deletion time had the lowest time complexity.

Since the worst time complexity for insertion, retrieval, and deletion is $O(n)$, this indicates that there may be some issues within the code itself causing a higher time complexity run time than expected. This may have something to do with the resizing of the hashmap, or some other issue.

## Implementation

For this application, I decided to use Java. Java has a library available for hashmaps, but I wrote the structure on my own. The only library I used was the Comparator java util library. The comparator was used for comparing hash code values.

### Files in the Application

- [Cats Text File](Sorted_Hashmap/cats.txt): a small text file to populate the hashmap
- [Cat Names Text File](Sorted_Hashmap/cat_names.txt): a small text file to populate the hashmap with collission handling
- [Analysis Class](Sorted_Hashmap/Analysis.java): analyses the algorithm to test it's speed
- [Files Class](Sorted_Hashmap/Files.java): provides methods to read data and parse from an external file to populate the hashmap
- [Hasmmap Interface](Sorted_Hashmap/iHashmap.java): an interface for a generic hashmap
- [Hashmap Class](Sorted_Hashmap/Hashmap.java): implements a hashmap structure with support to handle closed collissions and resize dynamically
- [Main Driver](Sorted_Hashmap/Main.java): used to miplement the hashmap, read from files, and return the data
- [TestHashMap Class](Sorted_Hashmap/Analysis.java): used to test the basic functionality of the hashmap

### Key Points of Implementation

The code demonstrates a custom hashmap that supports closed addressing with multiple values for a single key. Each key is associated with one of more values, which are storedin a list. Each element in the array is stored as a `Node` to represent a key-value pair:

```java
private static class Node<K, V> {
    final K key;
    V value;
    Node<K, V> next;

    Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
```

The `put()` method handles the insertion of key value pairs into the hashmap. Finds the index of the key by using hashing:

```java
public void put(K key, V value) {
        int index = hash(key);                                              // get the hash value for the key
        Node<K, V> node = table[index];                                     // get the node at the specific index
        ....
}

public int hash(K key) {
        if (key == null) {                              // null values can be saved as a key
            return 0;                                   // null must return a zero
        }
        return Math.abs(key.hashCode()) % capacity;     // create the hashcode based on the hashmap capacity
    }
```

It also checks for collissions and resizing if necessary.

```java
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
```

There is a `get()` method to retrieve values associated from the key within the hashmap. A `remove()` method to either remove all the elements from the hashmap or a specific value from the hashmap.

There is a `resize()` method to resize the capacity of the hashmap in the case where the load factor is over the current threshold. It will also refactor the original hashmap into the new hashmap

```java
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
```

In our [Main](Sorted_Hashmap/Main.java) driver, we run a hypothetical where we parse through a text file and turn the data into a hashmap structure. The output looks like the following:

```java
{
  "Birman": ["Daisy"],
  "British Shorthair": ["Lily", "Oscar", "Felix"],
  "Scottish Fold": ["Charlie", "Sophie"],
  "Savannah": ["Loki", "Luna"],
  "Sphynx": ["Gizmo"],
  "Himalayan": ["Luna", "Oliver"],
  "Ragdoll": ["Lucy", "Leo"],
  "Manx": ["Oliver", "Luna"],
  "Siamese": ["Snowball", "Whiskers", "Luna"],
  "Abyssinian": ["Luna", "Milo"],
  "Norwegian Forest": ["Bella"],
  "Persian": ["Max", "Chloe", "Oliver"],
  "Maine Coon": ["Simba", "Bella"],
  "American Shorthair": ["Luna", "Simba"],
  "Exotic Shorthair": ["Luna", "Max"],
  "Bengal": ["Tiger", "Nala"]
}
```

### Challenges I Faced

The primary issues I had for this application were of the following. It was difficult implementing proper handling of collissions. I ultimately decided on using closed addressing to handle collissions as it was easier to understand and implement. I also had difficultly implementing the get function, since I decided to use closed addressing. After some thorough debugging, I was able to understand the errors I had with that function. Another major challenge I had was with my toString() function, which would return a string based on the hashmap. I had difficulty returning a string that was formatting in a way to demonstrate the closed addressing of the hashmap.

## Summary

Ultimately, I learned during this process about hashmaps, and hashing in general. It was interesting to learn about the different ways that the structure could be handled through open and closed addressing. It also presented interesting challenges to handle during my implementation. Hashcodes were also a very important concept I feel much more comfortable with now. I can understand the importance of this hashmaps in general. I could see it being used in the future for my own application. Perhaps in personal projects where I plan to rely on some sort of database to pull up and store values.

## Resources

- Deitel, Paul J., and Harvey M. Deitel. Java: How to Program, 11th Edition. Pearson, 2018.
- Cormen, Thomas H., et al. "Introduction to Algorithms." MIT Press, 2009.
- OpenGenus IQ. (n.d.). Hans Peter Luhn, the man behind Hash Map. Retrieved from https://iq.opengenus.org/hans-peter-luhn/
- Iyer, Varun. “Time and Space Complexity of Hash Table Operations.” OpenGenus IQ, OpenGenus Foundation, https://iq.opengenus.org/time-complexity-of-hash-table/.
- MySQL (n.d.), “Comparison of B-Tree and Hash Indexes.”, https://dev.mysql.com/doc/refman/8.0/en/index-btree-hash.html.
