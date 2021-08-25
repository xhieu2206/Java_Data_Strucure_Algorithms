package com.example;

public class QueueArrayDemo {
    public static void main(String[] args) {
        Queue queueArray = new Queue(4);
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);

        System.out.println(queueArray);
        System.out.println("Length: " + queueArray.length());

        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.dequeue();
        System.out.println(queueArray);

        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        System.out.println(queueArray);

        queueArray.dequeue();
        queueArray.dequeue();
        queueArray.dequeue();
        System.out.println(queueArray);
    }
}
