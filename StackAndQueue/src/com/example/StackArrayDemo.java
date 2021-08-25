package com.example;

public class StackArrayDemo {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(10);
        stackArray.push(1);
        stackArray.push(12);
        stackArray.push(5);
        stackArray.push(4);
        stackArray.push(78);
        stackArray.push(12);
        stackArray.push(45);
        stackArray.push(67);
        stackArray.push(2);

        System.out.println("Stack length: " + (stackArray.getTop() + 1));

        stackArray.push(20);
        System.out.println("Stack length: " + (stackArray.getTop() + 1));

        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        System.out.println("Stack length: " + (stackArray.getTop() + 1));

        System.out.println("Stack peek: " + stackArray.peek() + ", position is " + stackArray.getTop());
    }
}
