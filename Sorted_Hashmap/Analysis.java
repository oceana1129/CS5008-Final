import java.util.Random;

/**
 * a class which tests random values and checks the time it takes to 
 * insert, retrieve, and delete random values from a hashmap
 */
public class Analysis {
    private static final int num_of_tests = 1000000;

    public static void main(String[] args) {
        Hashmap<Integer, Integer> hashmap = new Hashmap<>();
        Random random = new Random();

        System.out.println("Number of Tests: " + num_of_tests);

        // Insertion test
        long startTime = System.nanoTime();
        for (int i = 0; i < num_of_tests; i++) {
            hashmap.put(i, random.nextInt(1000));
        }
        long insertionTime = System.nanoTime() - startTime;
        System.out.println("Insertion Time: " + insertionTime + " ns");

        // Retrieval test
        startTime = System.nanoTime();
        for (int i = 0; i < num_of_tests; i++) {
            hashmap.get(i);
        }
        long retrievalTime = System.nanoTime() - startTime;
        System.out.println("Retrieval Time: " + retrievalTime + " ns");

        // Deletion test
        startTime = System.nanoTime();
        for (int i = 0; i < num_of_tests; i++) {
            hashmap.remove(i);
        }
        long deletionTime = System.nanoTime() - startTime;
        System.out.println("Deletion Time: " + deletionTime + " ns");
    }
}
