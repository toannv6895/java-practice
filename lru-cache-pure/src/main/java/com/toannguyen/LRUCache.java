package com.toannguyen;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> map;
    private DoubleLinkedList cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        cache.remove(node);
        cache.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);

        // remove old node if duplicate key
        if (map.containsKey(key)) {
            Node removedNode = map.get(key);
            cache.remove(removedNode);
            map.remove(key);
        }

        // remove least recently if reach the max capacity
        if (capacity == cache.getSize()) {
            Node node = cache.removeLast();
            cache.remove(node);
            map.remove(node.key);
        }

        // add new node to most recently
        map.put(key, newNode);
        cache.addFirst(newNode);
    }
}
