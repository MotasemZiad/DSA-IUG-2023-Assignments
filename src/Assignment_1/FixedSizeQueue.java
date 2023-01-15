package Assignment_1;

public class FixedSizeQueue {
    private int front;
    private int rear;
    private int size;
    private int[] array;

    public FixedSizeQueue(int capacity) {
        array = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
        size++;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int element = array[front];
        front = (front + 1) % array.length;
        size--;
        return element;
    }
}
