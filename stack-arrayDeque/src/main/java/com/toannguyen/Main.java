package com.toannguyen;

public class Main {
    public static void main(String[] args) {
        ArrayDequeStack stack = new ArrayDequeStack<Integer>(5);
        System.out.println("Is empty? " + stack.isEmpty());
        stack.push(2);
        stack.push(3);
        System.out.println("Size " + stack.getSize());
        stack.pop();
        System.out.println("Size " + stack.getSize());
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(4);
        System.out.println("Size " + stack.getSize());
        // Should throw exception
        stack.push(5);
        stack.push(7);

        System.out.println("Size " + stack.getSize());
    }
}