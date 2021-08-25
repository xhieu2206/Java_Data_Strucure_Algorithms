package com.example;

public class DoublyEndedList {
    private Node head;
    private Node tail;

    public void insertAtTail (int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
             this.head = newNode;
        }

        if (this.tail != null) {
            this.tail.setNextNode(newNode);
        }
        this.tail = newNode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{ ");
        Node current = this.head;
        while (current != null) {
            if (current.getNextNode() != null) {
                result.append(current.toString()).append(", ");
            } else {
                result.append(current.toString()).append("");
            }
            current = current.getNextNode();
        }
        result.append(" }");
        return result.toString();
    }
}
