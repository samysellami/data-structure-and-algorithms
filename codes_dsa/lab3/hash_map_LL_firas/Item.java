package lab3.hash_map_LL_firas;

import java.util.Objects;

public class Item<K, V> {

    private K key;
    private V value;

    public Item(K key, V value) {
        setKey(key);
        setValue(value);
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        var item = (Item<K, V>) o;
        return Objects.equals(key, item.key) && Objects.equals(value, item.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Item{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
