package funix.assignment;

public class Stack {
    private int top;
    private int maxSize;
    private Product[] stack;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Product[maxSize];
        top = -1;
    }

    private boolean isMaxSize() {
        return top == maxSize;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(Product data) {
        if (isMaxSize()) return;
        this.top ++;
        this.stack[top] = data;
    }

    public Product pop() {
        if (isEmpty()) throw new EmptyStackException("Stack is empty now!!!");
        this.top --;
        return stack[top + 1];
    }

    public Product peek() {
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

    public Product[] getStack() {
        return stack;
    }

    public void setStack(Product[] stack) {
        this.stack = stack;
    }
}
