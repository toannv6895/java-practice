package com.toannguyen;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class LFUCache {
    public HashMap<Integer, Node> cache;
    public HashMap<Integer, Integer> countMap;
    private SortedMap<Integer, DoubleLinkedList> frequencyMap;
    int capacity;

    public LFUCache(int c) {
        this.capacity = c;
        cache = new HashMap<>();
        countMap = new HashMap<>();
        frequencyMap = new TreeMap<>();
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            int frequency = countMap.get(key);
            Node curr = cache.get(key);
            removeFrequency(frequency, curr);

            // add new node for countMap and frequencyMap
            int newFrequency = frequency + 1;
            Node newNode = new Node(key, val);
            countMap.put(key, newFrequency);
            cache.put(key, newNode);

            // add new value
            addNewFrequency(newFrequency, newNode);
        }
        else {
            if (capacity == cache.size()) {
                int lowestFrequency = frequencyMap.firstKey();
                var removed = frequencyMap.get(lowestFrequency).removeLast();
                countMap.remove(removed.getKey());
                cache.remove(removed.getKey());
            }

            Node newNode = new Node(key, val);
            countMap.put(key, 1);
            cache.put(key, newNode);
            addNewFrequency(1, newNode);
        }
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        int frequency = countMap.get(key);
        Node curr = cache.get(key);
        removeFrequency(frequency, curr);

        int newFrequency = frequency + 1;

        countMap.put(key, newFrequency);

        addNewFrequency(newFrequency, curr);

        return curr.getValue();
    }

    private void removeFrequency(int frequency, Node curr) {
        frequencyMap.get(frequency).remove(curr);
        if (frequencyMap.get(frequency).getSize() == 0) {
            frequencyMap.remove(frequency);
        }
    }

    private void addNewFrequency(int newFrequency, Node curr) {
        if (frequencyMap.containsKey(newFrequency)) {
            frequencyMap.get(newFrequency).add(curr);
        }
        else {
            var newDoubleLinkedList = new DoubleLinkedList();
            newDoubleLinkedList.add(curr);
            frequencyMap.put(newFrequency, newDoubleLinkedList);
        }
    }
}
