package com.saptarshi.das.lowleveldesigns.cachedesign.cache.policy;

import com.saptarshi.das.lowleveldesigns.cachedesign.algorithms.DoublyLinkedList;
import com.saptarshi.das.lowleveldesigns.cachedesign.algorithms.DoublyLinkedNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Map<K, DoublyLinkedNode<K>> map;
    private final DoublyLinkedList<K> list;

    public LRUEvictionPolicy() {
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    @Override
    public void accessed(K key) {
        if (this.map.containsKey(key)) {
            this.list.remove(this.map.get(key));
        }
        final DoublyLinkedNode<K> node = this.list.addToHead(key);
        this.map.put(key, node);
    }

    @Override
    public K evict() {
        return this.list.removeFromLast();
    }

    @Override
    public K evict(K key) {
        if (this.map.containsKey(key)) {
            this.list.remove(this.map.get(key));
        }

        return key;
    }
}
