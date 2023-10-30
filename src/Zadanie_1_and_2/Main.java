package Zadanie_1_and_2;

import Zadanie_1_and_2.AbstractBinaryTree;
import Zadanie_1_and_2.BinaryTree;

public class Main {
    public static void main(String[] args) {
        AbstractBinaryTree<Integer> tree = new BinaryTree<>(4);
        tree.setLeft(new BinaryTree<>(2));
        tree.setRight(new BinaryTree<>(6));
        tree.getLeft().setLeft(new BinaryTree<>(1));
        tree.getLeft().setRight(new BinaryTree<>(3));
        tree.getRight().setLeft(new BinaryTree<>(5));
        tree.getRight().setRight(new BinaryTree<>(7));

        System.out.println("In-order traversal:");
        tree.forEachInOrder(element -> System.out.print(element + " "));

        System.out.println("\nPre-order traversal:");
        tree.preOrder().forEach(node -> System.out.print(node.getKey() + " "));

        System.out.println("\nPost-order traversal:");
        tree.postOrder().forEach(node -> System.out.print(node.getKey() + " "));

        System.out.println("\nLevel-order traversal:");
        tree.levelOrder().forEach(node -> System.out.print(node.getKey() + " "));
    }
}