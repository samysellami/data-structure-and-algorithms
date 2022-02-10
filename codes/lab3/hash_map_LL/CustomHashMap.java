// package lab3.hash_map_LL;

@SuppressWarnings("unchecked")
public class CustomHashMap<K, V> implements CustomHashMapInterface<K, V> {

    private int capacity = 16; // Initial default capacity
    // private int size = 0;
    private Entry<K, V>[] table; // Array of Entry object

    public CustomHashMap() {
        table = new Entry[capacity];
    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = index(key);
        Entry newEntry = new Entry(key, value, null);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> previousNode = null;
            Entry<K, V> currentNode = table[index];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            // if (previousNode.getNext() == null)
            if (previousNode != null)
                previousNode.setNext(newEntry);
        }
    }

    public V get(K key) {
        V value = null;
        int index = index(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    public void remove(K key) {
        int index = index(key);
        Entry previous = null;
        Entry entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                if (previous == null) {
                    entry = entry.getNext();
                    table[index] = entry;
                    return;
                } else {
                    previous.setNext(entry.getNext());
                    return;
                }
            }
            previous = entry;
            entry = entry.getNext();
        }
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> currentNode = table[i];
                while (currentNode != null) {
                    System.out.println(
                            String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> currentNode = table[i];
                while (currentNode != null) {
                    size = size + 1;
                    currentNode = currentNode.getNext();
                }
            }
        }
        return size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    private int index(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }
}
