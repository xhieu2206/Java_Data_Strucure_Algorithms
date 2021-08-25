package com.example;

public class DoublyLinkedList {
    private DoublyLinkedNode head;

    public void insertAtHead(int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        newNode.setNextNode(this.head);
        if (this.head != null) {
            this.head.setPreviousNode(newNode);
        }
        this.head = newNode;
    }

    public int length() {
        int length = 0;
        DoublyLinkedNode current = this.head;
        while (current != null) {
            length ++;
            current = current.getNextNode();
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{ ");
        DoublyLinkedNode current = this.head;
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
