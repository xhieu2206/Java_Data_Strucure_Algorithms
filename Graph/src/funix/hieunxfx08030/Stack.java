package funix.hieunxfx08030;

public class Stack {
    private int top;
    private int maxSize;
    private int[] arr;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
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
        this.arr[top] = data;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException("Stack is empty now!!!");
        this.top --;
        return arr[top + 1];
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException("Stack is empty now!!!");
        return arr[top];
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
        return arr;
    }

    public void setStack(int[] stack) {
        this.arr = stack;
    }
}
