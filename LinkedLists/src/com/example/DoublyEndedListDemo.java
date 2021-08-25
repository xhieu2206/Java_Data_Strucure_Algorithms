package com.example;

public class DoublyEndedListDemo {
    public static void main(String[] args) {
        DoublyEndedList dList = new DoublyEndedList();
        dList.insertAtTail(10);
        dList.insertAtTail(1);
        dList.insertAtTail(16);
        dList.insertAtTail(20);
        dList.insertAtTail(17);

        System.out.println(dList);
    }
}
