package com.saptarshi.das.lowleveldesigns.cachedesign.cache;

import com.saptarshi.das.lowleveldesigns.cachedesign.cache.storage.Storage;
import com.saptarshi.das.lowleveldesigns.cachedesign.cache.policy.EvictionPolicy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.spec.ECField;

@Slf4j
public class Cache<K, V> {
    private final Storage<K, V> storage;
    private final EvictionPolicy<K> evictionPolicy;
    private final int capacity;
    private int size;

    private Cache(int capacity, Storage<K, V> storage, EvictionPolicy<K> evictionPolicy) {
        this.size = 0;
        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(final K key, final V value) {
        if (this.size == this.capacity) {
            final K evictedKey = this.evictionPolicy.evict();
            this.storage.remove(evictedKey);
            this.size--;
        }

        this.storage.add(key, value);
        this.evictionPolicy.accessed(key);
        this.size++;
    }

    public V get(final K key) {
        final V value = this.storage.get(key);
        this.evictionPolicy.accessed(key);
        return value;
    }

    public void  evict(final K key) {
        this.storage.remove(key);
        this.evictionPolicy.evict(key);
    }
}
