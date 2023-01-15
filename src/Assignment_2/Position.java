package Assignment_2;

interface Position<E> {
    E getElement() throws IllegalStateException;
}

class BST<E extends Comparable<E>> {
    private Node<E> root;

    private class Node<E> implements Position<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
            left = null;
            right = null;
        }

        public E getElement() {
            return element;
        }
    }
}
