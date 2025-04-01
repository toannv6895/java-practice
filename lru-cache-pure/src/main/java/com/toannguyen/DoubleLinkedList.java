package com.toannguyen;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(Node node) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    public void removeLast() {
        Node last = tail.prev;
        last.prev.next = last.next;
        last.next.prev = last.prev;
        size--;
    }

    public void removeFirst() {
        Node first = head.next;
        first.prev.next = first.next;
        first.next.prev = first.prev;
        size--;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public int getSize() {
        return size;
    }
}
