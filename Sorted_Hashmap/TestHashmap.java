import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * a text class used to test basic hashmap functions
 */
public class TestHashmap {

    private Hashmap<String, String> hashmap;

    /**
     * sets up our hashmap structure for testing
     */
    @Before
    public void setUp() {
        hashmap = new Hashmap<>();
    }

    /**
     * tests the hashmap put and get functions
     */
    @Test
    public void testPutAndGet() {
        hashmap.put("Siamese", "Snowball");
        hashmap.put("Siamese", "Whiskers");
        hashmap.put("Siamese", "Luna");

        assertEquals("Snowball, Whiskers, Luna", hashmap.get("Siamese"));
    }

    /**
     * tests the hashmap remove function
     */
    @Test
    public void testRemove() {
        hashmap.put("Siamese", "Snowball");
        hashmap.put("Siamese", "Whiskers");
        hashmap.put("Siamese", "Luna");

        assertEquals("Snowball", hashmap.remove("Siamese"));
        assertEquals("Whiskers, Luna", hashmap.get("Siamese"));
    }

    /**
     * tests the hashmap size function
     */
    @Test
    public void testSize() {
        assertEquals(0, hashmap.size());

        hashmap.put("Siamese", "Snowball");

        assertEquals(1, hashmap.size());

        hashmap.remove("Siamese");

        assertEquals(0, hashmap.size());
    }

    /**
     * tests the containKey hashmap function
     */
    @Test
    public void testContainKey() {
        assertFalse(hashmap.containKey("Siamese"));

        hashmap.put("Siamese", "Snowball");

        assertTrue(hashmap.containKey("Siamese"));
        assertFalse(hashmap.containKey("Persian"));
    }

    /**
     * tests the hashmap toString function
     */
    @Test
    public void testToString() {
        hashmap.put("Siamese", "Snowball");
        hashmap.put("Siamese", "Whiskers");
        hashmap.put("Siamese", "Luna");

        String expected = "{\n" +
                "  \"Siamese\": [\"Snowball\", \"Whiskers\", \"Luna\"]\n" +
                "}";
        assertEquals(expected, hashmap.toString());
    }
}
