package lab3.hash_map_LL_firas;

import java.util.*;

public class LinkedHashMap<K, V> implements ILinkedHashMap<K, V> {

    private List<Item<K, V>> buckets[];
    private final int SIZE;


    public LinkedHashMap(int size) {
        this.SIZE = Math.abs(size);
        buckets = new List[SIZE];
    }

    public int getIndex(K key) {
        // fixing null values
        // null values are acceptable in Java for generic Types
        if (key == null) return 0;

        int code = Math.abs(key.hashCode());
        return code % SIZE;
    }

    @Override
    public int size() {
        return (int) Arrays.stream(buckets).filter(item -> item != null && item.size() > 0).count();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        return buckets[index] != null
                && buckets[index].size() > 0
                && buckets[index].stream().anyMatch(item -> item!=null && Objects.equals(item.getKey(), key));
        // key could be null
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        if (!containsKey(key)) {
            Item<K, V> item = new Item<>(key, value);
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(item);
        } else {
            Optional<Item<K, V>> item = buckets[index].stream().filter(i -> i!=null && Objects.equals(i.getKey(), key)).findFirst();
            if (item.isPresent())
                item.get().setValue(value);
        }
    }

    @Override
    public void remove(K key) {
        if (containsKey(key)) {
            int index = getIndex(key);

//            buckets[index].removeIf(item -> item.equals(key));

            for (int i = 0; i < buckets[index].size(); i++) {
                if (buckets[index].get(i)!=null && Objects.equals(buckets[index].get(i).getKey(), key)) {
                    buckets[index].remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {

        if (containsKey(key)) {
            int index = getIndex(key);
            Optional<Item<K, V>> item = buckets[index].stream().filter(item1 -> item1!=null && Objects.equals(item1.getKey(), key)).findFirst();
            if (item.isPresent()) {
                return item.get().getValue();

            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "LinkedHashMap{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + this.size() +
                '}';
    }
}

