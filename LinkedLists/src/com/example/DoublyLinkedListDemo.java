package com.example;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtHead(10);
        list.insertAtHead(15);
        list.insertAtHead(9);
        list.insertAtHead(5);
        list.insertAtHead(20);

        System.out.println(list);
    }
}
