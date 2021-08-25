package com.example;

public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        stackLinkedList.push(10);
        stackLinkedList.push(20);
        stackLinkedList.push(30);
        stackLinkedList.push(40);

        System.out.println("Stack peek: " + stackLinkedList.peek());
        System.out.println("Stack popped item: " + stackLinkedList.pop());
        System.out.println("Stack peek: " + stackLinkedList.peek());
    }
}
