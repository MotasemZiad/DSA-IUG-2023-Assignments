package Assignment_1;

public class DoubleLinkedDeque {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int element;
        Node next;
        Node prev;

        public Node(int element) {
            this.element = element;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertFront(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertRear(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        int element = head.element;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return element;
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        int element = tail.element;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return element;
    }

}
