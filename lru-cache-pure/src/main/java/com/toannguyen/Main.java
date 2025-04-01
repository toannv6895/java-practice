package com.toannguyen;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        // you can understand the cache as a queue
        // assume the left side is the head of the queue and the right side is the tail
        // the most recently used is at the head of the
        // queue, and the least recently used is at the tail
        // parentheses represent the key-value pair (key, val)

        cache.put(1, 1);
        // cache = [(1, 1)]
        for (Node node : cache.map.values()) {
            System.out.println(node.key + ":" + node.value);
        }

        System.out.println("===============");

        cache.put(2, 2);
        // cache = [(1, 1), (2, 2)]
        for (Node node : cache.map.values()) {
            System.out.println(node.key + ":" + node.value);
        }

        System.out.println("===============");

        // return 1
        System.out.println("return " + cache.get(1));
        // cache = [(2, 2), (1, 1)]
        // explanation: because key 1 was recently accessed, it is moved to the head of the queue
        // return the value corresponding to key 1, which is 1
        for (Node node : cache.map.values()) {
            System.out.println(node.key + ":" + node.value);
        }

        System.out.println("===============");

        cache.put(3, 3);
        // cache = [(1, 1), (3, 3)]
        // explanation: the cache is full, need to delete content to make space
        // prefer to delete the least recently used data, which is the data at the tail
        // then insert the new data at the head of the queue
        for (Node node : cache.map.values()) {
            System.out.println(node.key + ":" + node.value);
        }

        System.out.println("===============");

        // return -1 (not found)
        System.out.println("return " + cache.get(2));
        // cache = [(1, 1), (3, 3)]
        // explanation: there is no data with key 2 in the cache
        for (Node node : cache.map.values()) {
            System.out.println(node.key + ":" + node.value);
        }

        System.out.println("===============");

        cache.put(1, 4);
        // cache = [(3, 3), (1, 4)]
        // explanation: key 1 already exists, overwrite the original value 1 with 4
        // don't forget to also move the key-value pair to the head of the queue
        for (Node node : cache.map.values()) {
            System.out.println(node.key + ":" + node.value);
        }

        System.out.println("===============");
    }
}