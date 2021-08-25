package com.example;

public class LinkedListDemo {
    public static void main(String[] args) {
        /*
            LinkedList list = new LinkedList();
            list.insertAtHead(1);
            list.insertAtHead(10);
            list.insertAtHead(12);
            list.insertAtHead(6);
            list.insertAtHead(20);

            System.out.println(list);
            System.out.println("Length of link list: " + list.length());

            list.deleteFromHead();

            System.out.println(list);
            System.out.println("Length after deleted: " + list.length());

            System.out.println("Found: " + list.find(10));
            System.out.println("Found: " + list.find(20));
        */
        LinkedList list = new LinkedList();
        list.insertAtTail(10);
        list.insertAtTail(11);
        list.insertAtTail(12);
        list.insertAtTail(13);
        list.insertAtTail(15);

        list.insertInSortedLinkedList(14);
        list.insertInSortedLinkedList(20);

        System.out.println(list);
        System.out.println("Length of link list: " + list.length());
    }
}
