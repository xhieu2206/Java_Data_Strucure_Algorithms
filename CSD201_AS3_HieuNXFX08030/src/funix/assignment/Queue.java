package funix.assignment;

public class Queue {
    private int head;
    private int tail;
    private final int maxSize;
    private final TreeNode[] arr;

    public Queue(int max) {
        this.maxSize = max;
        this.arr = new TreeNode[maxSize];
        this.head = -1;
        this.tail = -1;
    }

    public void enqueue(TreeNode data) {
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

    public TreeNode dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            TreeNode item = arr[head];
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1) % maxSize;
            }
            return item;
        }
    }

    public TreeNode peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return this.arr[this.head];
    }

    public int length() {
        return Math.abs(this.head - this.tail) + 1;
    }

    public boolean isEmpty() {
        return head == -1;
    }
}
