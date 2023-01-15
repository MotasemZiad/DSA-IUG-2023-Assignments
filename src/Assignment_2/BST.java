package Assignment_2;

import java.util.*;

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

    public BST() {
        root = null;
    }

    public void addToBst(E e) {
        root = addToBst(e, root);
    }

    private Node<E> addToBst(E e, Node<E> root) {
        if (root == null) {
            return new Node<E>(e, null);
        }
        int cmp = e.compareTo(root.getElement());
        if (cmp < 0) {
            root.left = addToBst(e, root.left);
            root.left.parent = root;
        } else if (cmp > 0) {
            root.right = addToBst(e, root.right);
            root.right.parent = root;
        }
        return root;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E removedElement = node.getElement();
        if (node.left == null && node.right == null) {
            if (node.parent == null) {
                root = null;
            } else if (node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else if (node.left != null && node.right != null) {
            Position<E> min = treeMinimum(node.right);
            node.element = min.getElement();
            remove(min);
        } else {
            Node<E> child = node.left != null ? node.left : node.right;
            if (node.parent == null) {
                root = child;
            } else if (node.parent.left == node) {
                node.parent.left = child;
            } else {
                node.parent.right = child;
            }
            child.parent = node.parent;
        }
        return removedElement;
    }

    public Position<E> sibling(Position<E> p) {
        Node<E> node = validate(p);
        if (node.parent == null) {
            return null;
        }
        if (node.parent.left == node) {
            return node.parent.right;
        }
        return node.parent.left;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> children = new ArrayList<>();
        Node<E> node = validate(p);
        if (node.left != null) {
            children.add(node.left);
        }
        if (node.right != null) {
            children.add(node.right);
        }
        return children;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid internal node.");

        Node<E> node = (Node<E>) p;

        if (node.parent == node)
            throw new IllegalArgumentException("p is no longer in the tree.");

        return node;
    }

    private Position<E> treeMinimum(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
