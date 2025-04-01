package com.toannguyen;

import java.util.*;

public class LFUCache {
    public HashMap<Integer, Integer> cache;
    public HashMap<Integer, Integer> countMap;
    private SortedMap<Integer, List<Integer>> frequencyMap;
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
            removeFrequency(frequency, key);
            cache.put(key, val);
            countMap.put(key, frequency + 1);
            addFrequency(frequency + 1, key);
        }
        else {
            if (cache.size() == capacity) {
                int lowestFrequency = frequencyMap.firstKey();
                int lowestKey = frequencyMap.get(lowestFrequency).get(0);
                removeFrequency(lowestFrequency, lowestKey);

                countMap.remove(lowestKey);
                cache.remove(lowestKey);
            }

            addFrequency(1, key);

            countMap.put(key, 1);
            cache.put(key, val);
        }
    }

    public int get(int key) {
        if (!cache.containsValue(key)) {
            return -1;
        }

        int frequency = countMap.get(key);

        removeFrequency(frequency, key);
        int newFrequency = frequency + 1;
        addFrequency(newFrequency, key);
        countMap.put(key, newFrequency);

        return cache.get(key);
    }

    private void removeFrequency(int frequency, int key) {
        frequencyMap.get(frequency).remove(Integer.valueOf(key));
        if (frequencyMap.get(frequency).isEmpty()) {
            frequencyMap.remove(frequency);
        }
    }

    private void addFrequency(int frequency, int key) {
        if (frequencyMap.containsKey(frequency)) {
            var curr = frequencyMap.get(frequency);
            curr.add(key);
            frequencyMap.put(frequency, curr);
        }
        else {
            List<Integer> newArray = new ArrayList<>();
            newArray.add(key);
            frequencyMap.put(frequency, newArray);
        }
    }
}
