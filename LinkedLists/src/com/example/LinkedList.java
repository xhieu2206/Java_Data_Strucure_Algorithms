package com.example;

public class LinkedList {
    private Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        Node current = this.head;
        if (current == null) {
            this.head = newNode;
        } else {
            while (current != null) {
                if (current.getNextNode() == null) {
                    break;
                }
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
    }

    public void insertInSortedLinkedList(int data) {
        Node current = this.head;
        if (current == null) {
            this.insertAtHead(data);
            return;
        }
        while (current != null) {
            if (current.getData() >= data) {
                this.insertAtHead(data);
                break;
            }
            if (current.getData() <= data && current.getNextNode() == null) {
                this.insertAtTail(data);
                break;
            } else if (current.getData() <= data && current.getNextNode().getData() >= data) {
                Node newNode = new Node(data);
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
                break;
            }
            current = current.getNextNode();
        }
    }

    public int length() {
        int length = 0;
        Node current = this.head;
        while (current != null) {
            length ++;
            current = current.getNextNode();
        }
        return length;
    }

    public void deleteFromHead() {
        this.head = this.head.getNextNode();
    }

    public Node find(int data) {
        Node current = this.head;
        while (current != null) {
            if (current.getData() == data) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
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
