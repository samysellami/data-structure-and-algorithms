package lab3.hash_map_LL_firas;

public interface ILinkedHashMap<K,V> {
    int size();
    boolean isEmpty();
    void put(K key, V value);
    void remove(K key);
    V get(K key);
}
