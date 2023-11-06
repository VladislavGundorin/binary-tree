package Zadanie_1_and_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  ");
        }
        sb.append(key).append("\n");
        if (left != null) {
            sb.append(left.asIndentedPreOrder(indent + 1));
        }
        if (right != null) {
            sb.append(right.asIndentedPreOrder(indent + 1));
        }
        return sb.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (left != null) {
            result.addAll(left.preOrder());
        }
        if (right != null) {
            result.addAll(right.preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.inOrder());
        }
        result.add(this);
        if (right != null) {
            result.addAll(right.inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.postOrder());
        }
        if (right != null) {
            result.addAll(right.postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }
    @Override
    public void setLeft(AbstractBinaryTree<E> left) {
        this.left = left;
    }

    @Override
    public void setRight(AbstractBinaryTree<E> right) {
        this.right = right;
    }
    @Override
    public List<AbstractBinaryTree<E>> levelOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            AbstractBinaryTree<E> node = queue.poll();
            result.add(node);

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

        return result;
    }
    @Override
    public void printTree(AbstractBinaryTree<E> root, int level) {
        if (root == null) {
            return;
        }

        printTree(root.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(root.getKey());

        printTree(root.getLeft(), level + 1);
    }
    public void printInOrderTree(AbstractBinaryTree<E> root) {
        System.out.println("In-order tree:");
        printTreeInOrder(root, 0);
    }

    private void printTreeInOrder(AbstractBinaryTree<E> root, int level) {
        if (root == null) {
            return;
        }

        printTreeInOrder(root.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(root.getKey());

        printTreeInOrder(root.getLeft(), level + 1);
    }
    public void printPreOrderTree(AbstractBinaryTree<E> root) {
        System.out.println("Pre-order tree:");
        printTreePreOrder(root, 0);
    }

    private void printTreePreOrder(AbstractBinaryTree<E> root, int level) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(root.getKey());

        printTreePreOrder(root.getLeft(), level + 1);
        printTreePreOrder(root.getRight(), level + 1);
    }
    public void printPostOrderTree(AbstractBinaryTree<E> root) {
        System.out.println("Post-order tree:");
        printTreePostOrder(root, 0);
    }

    private void printTreePostOrder(AbstractBinaryTree<E> root, int level) {
        if (root == null) {
            return;
        }

        printTreePostOrder(root.getLeft(), level + 1);
        printTreePostOrder(root.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(root.getKey());
    }
    public void printLevelOrderTree(AbstractBinaryTree<E> root) {
        System.out.println("Level-order tree:");
        if (root == null) {
            return;
        }

        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                AbstractBinaryTree<E> node = queue.poll();
                System.out.print(node.getKey() + " ");

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            System.out.println();
        }
    }


}
