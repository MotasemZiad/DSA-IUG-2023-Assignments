package Assignment_1;

public class ArrayDeque {
    private int front;
    private int rear;
    private int size;
    private int[] array;

    public ArrayDeque(int capacity) {
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

    public void insertFront(int element) {
        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }
        front = (front - 1 + array.length) % array.length;
        array[front] = element;
        size++;
    }

    public void insertRear(int element) {
        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        int element = array[front];
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        rear = (rear - 1 + array.length) % array.length;
        int element = array[rear];
        size--;
        return element;
    }

}
