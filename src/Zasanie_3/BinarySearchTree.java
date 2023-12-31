package Zasanie_3;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    @Override
    public void insert(E element) {
        root = insertRec(root, element);
    }

    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            return new Node<>(element);
        }
        if (element.compareTo(root.value) < 0) {
            root.leftChild = insertRec(root.leftChild, element);
        } else if (element.compareTo(root.value) > 0) {
            root.rightChild = insertRec(root.rightChild, element);
        }

        return root;
    }

    @Override
    public boolean contains(E element) {
        return containsRec(root, element);
    }

    private boolean containsRec(Node<E> root, E element) {
        if (root == null) {
            return false;
        }

        if (element.compareTo(root.value) == 0) {
            return true;
        } else if (element.compareTo(root.value) < 0) {
            return containsRec(root.leftChild, element);
        } else {
            return containsRec(root.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        if (contains(element)) {
            BinarySearchTree<E> resultTree = new BinarySearchTree<>();
            resultTree.root = searchRec(root, element);
            return resultTree;
        }
        return null;
    }

    private Node<E> searchRec(Node<E> root, E element) {
        if (root == null || element.compareTo(root.value) == 0) {
            return root;
        }

        if (element.compareTo(root.value) < 0) {
            return searchRec(root.leftChild, element);
        }

        return searchRec(root.rightChild, element);
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        return (root != null) ? root.leftChild : null;
    }

    @Override
    public Node<E> getRight() {
        return (root != null) ? root.rightChild : null;
    }

    @Override
    public E getValue() {
        return (root != null) ? root.value : null;
    }
}