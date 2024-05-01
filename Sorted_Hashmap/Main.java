import java.io.IOException;
import java.util.List;

/**
 * the main driver used for our hashmap application
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Hashmap<String, String> hashmap = new Hashmap<>();      // INITIALIZE HASHMAP

        hashmap.put("Kitty", "Hopey");                // individually add to hashmap
        hashmap.put("Kitty", "Whiskers");
        hashmap.put("Kitty", "Luna");
        hashmap.put("Orange", "Luna");
        System.out.println(hashmap);
        System.out.println(hashmap.get("Kitty"));           // tests get methods
        System.out.println(hashmap.get("Orange"));
        hashmap.remove();                                       // clear hashmap


        Files file1 = new Files("final-reseach-paper-oceana1129/Sorted_Hashmap/cats.txt");           // SAVE FILE
        List<String[]> array1 = file1.readFileAsArray();        // read file as an array


        for (String[] tuple : array1) {                         // add key value pairs to the hashmap
            if (tuple.length == 2) {                            // tuple must have two elements
                hashmap.put(tuple[0], tuple[1]);                // add to hashmap
            }
        }

        System.out.println(hashmap);                            // PRINT HASHMAP

        hashmap.remove();                                       // clear hashmap
        System.out.println(hashmap);                            // should indicate empty hashmap

        Files file2 = new Files("final-reseach-paper-oceana1129/Sorted_Hashmap/cat_names.txt");      // SAVE FILE
        List<String[]> array2 = file2.readFileAsArray();        // read file as an array


        for (String[] tuple : array2) {                         // add key value pairs to the hashmap
            if (tuple.length == 2) {                            // tuple must have two elements
                hashmap.put(tuple[0], tuple[1]);                // add to hashmap
            }
        }
        System.out.println(hashmap);                            // new hashmap

        hashmap.remove();                                       // clear hashmap
        System.out.println(hashmap);                            // should indicate empty hashmap
    }

}
