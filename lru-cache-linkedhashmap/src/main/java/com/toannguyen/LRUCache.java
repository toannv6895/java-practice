package com.toannguyen;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    public int capacity;
    public LRUCache(int c) {
        super(c + 1, 1.0f, true);
        this.capacity = c;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        // Remove the eldest element whenever
        // size of cache exceeds the capacity
        return (size() > this.capacity);
    }
}
