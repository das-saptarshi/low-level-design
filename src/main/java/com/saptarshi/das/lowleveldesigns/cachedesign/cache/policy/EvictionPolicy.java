package com.saptarshi.das.lowleveldesigns.cachedesign.cache.policy;

public interface EvictionPolicy<K> {
    void accessed(K key);

    K evict();

    K evict(K key);
}
