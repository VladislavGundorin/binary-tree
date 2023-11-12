package three;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    @Override
    public void insert(E element) {
        root = insertRecursive(root, element);
    }

    private Node<E> insertRecursive(Node<E> current, E element) {
        if (current == null) {
            return new Node<>(element);
        }

        if (element.compareTo(current.value) < 0) {
            current.leftChild = insertRecursive(current.leftChild, element);
        } else if (element.compareTo(current.value) > 0) {
            current.rightChild = insertRecursive(current.rightChild, element);
        }

        return current;
    }

    @Override
    public boolean contains(E element) {
        return containsRecursive(root, element);
    }

    private boolean containsRecursive(Node<E> current, E element) {
        if (current == null) {
            return false;
        }

        if (element.equals(current.value)) {
            return true;
        }

        if (element.compareTo(current.value) < 0) {
            return containsRecursive(current.leftChild, element);
        } else {
            return containsRecursive(current.rightChild, element);
        }
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> result = searchRecursive(root, element);
        if (result == null) {
            return new BinarySearchTree<>();
        } else {
            return new BinarySearchTree<>(result);
        }
    }

    private Node<E> searchRecursive(Node<E> current, E element) {
        if (current == null || element.equals(current.value)) {
            return current;
        }

        if (element.compareTo(current.value) < 0) {
            return searchRecursive(current.leftChild, element);
        } else {
            return searchRecursive(current.rightChild, element);
        }
    }

    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        if (root != null) {
            return root.leftChild;
        } else {
            return null;
        }
    }

    @Override
    public Node<E> getRight() {
        if (root != null) {
            return root.rightChild;
        } else {
            return null;
        }
    }

    @Override
    public E getValue() {
        if (root != null) {
            return root.value;
        } else {
            return null;
        }
    }

    private BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    public BinarySearchTree() {
        this.root = null;
    }
}