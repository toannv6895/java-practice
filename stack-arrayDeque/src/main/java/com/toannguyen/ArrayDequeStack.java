package com.toannguyen;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeStack<E> implements Stack<E> {
    private final Deque<E> deque;
    int capacity;

    public ArrayDequeStack(int c) {
        deque = new ArrayDeque<>(c);
        capacity = c;
    }

    @Override
    public void push(E item) {
        if (capacity == deque.size()) {
            System.out.println("Stack OverFlow\nProgram Terminated\n");
            System.exit(1);
        }
        deque.addFirst(item);
    }

    @Override
    public E pop() {
        if (deque.isEmpty()) {
            System.out.println("Stack empty");
            System.exit(1);
        }
        return deque.removeFirst();
    }

    @Override
    public E peek() {
        return deque.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public int getSize() {
        return deque.size();
    }
}
