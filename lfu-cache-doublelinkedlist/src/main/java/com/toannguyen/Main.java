package com.toannguyen;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        // cache = [(1, 1)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue());
        }

        System.out.println("===============");

        cache.put(2, 2);
        // cache = [(1, 1), (2, 2)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue() + "=> count: " + cache.countMap.get(entry.getKey()));
        }

        System.out.println("===============");

        // return 1
        System.out.println("return " + cache.get(1));
        // cache = [(1, 1), (2, 2)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue() + "=> count: " + cache.countMap.get(entry.getKey()));
        }

        System.out.println("===============");

        cache.put(3, 3);
        // cache = [(1, 1), (3, 3)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue() + "=> count: " + cache.countMap.get(entry.getKey()));
        }

        System.out.println("===============");

        // return -1 (not found)
        System.out.println("return " + cache.get(2));
        // cache = [(1, 1), (3, 3)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue() + "=> count: " + cache.countMap.get(entry.getKey()));
        }

        System.out.println("===============");

        cache.put(1, 4);
        // cache = [(1, 4), (3, 3)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue() + "=> count: " + cache.countMap.get(entry.getKey()));
        }

        System.out.println("===============");

        // return 3
        System.out.println("return " + cache.get(3));
        // cache = [(1, 4), (3, 3)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue() + "=> count: " + cache.countMap.get(entry.getKey()));
        }

        System.out.println("===============");

        cache.put(5, 6);
        // cache = [(1, 4), (5, 6)]
        for (Map.Entry entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey() + ":" + ((Node)entry.getValue()).getValue() + "=> count: " + cache.countMap.get(entry.getKey()));
        }
    }
}