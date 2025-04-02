package com.toannguyen;

public class Node {
    private int key;
    private int value;
    Node next;
    Node prev;

    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
