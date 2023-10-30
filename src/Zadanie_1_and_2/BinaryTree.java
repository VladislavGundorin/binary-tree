package Zadanie_1_and_2;

import Zadanie_1_and_2.AbstractBinaryTree;

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
}
