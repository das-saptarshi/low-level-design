package com.saptarshi.das.lowleveldesigns.cachedesign.cache.storage;

import java.util.HashMap;

public class MapStorage<K, V> implements Storage<K, V> {
    private final HashMap<K, V> storage;

    public MapStorage() {
        this.storage = new HashMap<>();
    }

    @Override
    public void add(K key, V value) {
        this.storage.put(key, value);
    }

    @Override
    public V get(K key) {
        return this.storage.get(key);
    }

    @Override
    public void remove(K key) {
        this.storage.remove(key);
    }
}
