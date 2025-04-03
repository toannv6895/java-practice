package com.toannguyen;

public interface Stack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int getSize();
}
