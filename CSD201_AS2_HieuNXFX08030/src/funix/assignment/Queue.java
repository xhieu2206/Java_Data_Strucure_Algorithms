package funix.assignment;

public class Queue {
    private int head;
    private int tail;
    private final int maxSize;

    private final Product[] arr;

    public Queue(int max) {
        this.maxSize = max;
        this.arr = new Product[maxSize];
        this.head = -1;
        this.tail = -1;
    }

    public void enqueue(Product data) {
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

    public Product dequeue() {
        if (this.length() == 0) {
            throw new EmptyStackException("This queue is empty!!!");
        }
        Product result = this.arr[this.head];
        if (this.head == this.length() - 1) {
            this.head = 0;
        } else {
            this.head += 1;
        }
        return result;
    }

    public Product peek() {
        return this.arr[this.head];
    }

    public int length() {
        return Math.abs(this.head - this.tail) + 1;
    }

    public Product[] getArr() {
        return arr;
    }
}
