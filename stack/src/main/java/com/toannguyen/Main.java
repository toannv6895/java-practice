package com.toannguyen;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println("Is empty? " + stack.isEmpty());
        stack.push(2);
        stack.push(3);
        System.out.println("Size " + stack.size());
        stack.pop();
        System.out.println("Size " + stack.size());
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(4);
        System.out.println("Size " + stack.size());
        // Should throw exception
        stack.push(5);
    }
}