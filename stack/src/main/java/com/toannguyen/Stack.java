package com.toannguyen;

public class Stack {
    private int arr[];
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack OverFlow\nProgram Terminated\n");
            System.exit(1);
        }

        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack empty");
            System.exit(1);
        }

        return arr[top--];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
