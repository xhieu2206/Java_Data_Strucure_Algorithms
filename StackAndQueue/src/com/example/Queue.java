package com.example;

public class Queue {
    private int head;
    private int tail;
    private final int maxSize;
    private final int[] arr;

    public Queue(int max) {
        this.maxSize = max;
        this.arr = new int[maxSize];
        this.head = -1;
        this.tail = -1;
    }

    public void enqueue(int data) {
        if ((tail + 1) % maxSize == head) {
            System.out.println("Queue if full!");
        } else {
            tail = (tail + 1) % maxSize;
            arr[tail] = data;
            if (head == -1) {
                head = tail;
            }
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int item = arr[head];
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1) % maxSize;
            }
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return this.arr[this.head];
    }

    public int length() {
        return Math.abs(this.head - this.tail) + 1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int i = this.head;
        while (i != tail) {
            result.append(arr[i]).append(" ");
            i ++;
            if (i == this.maxSize) {
                i = 0;
            }
        }
        result.append(arr[tail]);
        return result.toString();
    }
}
