package com.example;

public class StackLinkedList {
    private Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        this.head = newNode;
    }

    public int pop() {
        if (head == null) throw new EmptyStackException("This stack is empty!!!");
        int data = this.head.getData();
        this.head = this.head.getNextNode();
        return data;
    }

    public int peek() {
        if (head == null) throw new EmptyStackException("This stack is empty!!!");
        return this.head.getData();
    }
}
