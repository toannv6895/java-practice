package com.toannguyen;

public class Node {
    public int n;
    public int T;
    public int key[];
    public Node child[];
    boolean leaf;

    public Node(int t) {
        this.T = t;
        key = new int[2 * T - 1];
        child = new Node[2 * T];
        leaf = true;
    }

    public int Find(int k) {
        for (int i = 0; i < n; i++) {
            if (key[i] == k) {
                return i;
            }
        }

        return -1;
    }
}
