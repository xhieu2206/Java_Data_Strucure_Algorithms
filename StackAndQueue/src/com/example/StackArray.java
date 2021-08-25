package com.example;

public class StackArray {
    private int top;
    private int maxSize;
    private int[] stack;

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;
    }

    private boolean isMaxSize() {
        return top == maxSize;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (isMaxSize()) return;
        this.top ++;
        this.stack[top] = data;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException("Stack is empty now!!!");
        this.top --;
        return stack[top + 1];
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException("Stack is empty now!!!");
        return stack[top];
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }
}
