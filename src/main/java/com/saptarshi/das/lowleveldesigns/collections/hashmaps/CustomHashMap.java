package com.saptarshi.das.lowleveldesigns.collections.hashmaps;

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private final Entry<K, V>[] entries;

    public CustomHashMap() {
        entries = new Entry[INITIAL_CAPACITY];
    }

    public CustomHashMap(final int capacity) {
        final int newCapacity = findCapacity(capacity);
        entries = new Entry[newCapacity];
    }

    private int findCapacity(final int capacity) {
        int n = capacity - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n < 0) ? 1 : (n > MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n - 1;
    }

    static class Entry<K, V> {
        public K key;
        public V value;
        public Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(final K key, final V value) {
        final int index = key.hashCode() % entries.length;
        if (entries[index] == null) {
            entries[index] = new Entry<>(key, value);
        } else {
            Entry<K, V> node = entries[index];
            Entry<K, V> previous = node;

            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                previous = node;
                node = node.next;
            }
            assert previous != null;
            previous.next = new Entry<>(key, value);
        }
    }

    public V get(final K key) {
        final int index = key.hashCode() % entries.length;
        Entry<K, V> node = entries[index];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        final CustomHashMap<Integer, String> map = new CustomHashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(2, "E");
        map.put(10, "R");

        System.out.println("1: " + map.get(1));
        System.out.println("2: " + map.get(2));
        System.out.println("3: " + map.get(3));
        System.out.println("4: " + map.get(4));
        System.out.println("10: " + map.get(10));
    }
}
