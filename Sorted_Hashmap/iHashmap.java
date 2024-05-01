/**
 * an interface representing a generic hashmap
 *
 * @param <K>
 * @param <V>
 */
public interface iHashmap <K, V> {
    public void put(K key, V value);
    public V get(K key);
    public V remove(K key);
    void remove();
    public boolean containKey(K Key);
    public int size();
    public boolean isEmpty();
    public String toString();
}