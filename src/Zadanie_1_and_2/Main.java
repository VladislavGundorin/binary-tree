package Zadanie_1_and_2;

public class Main {
    public static void main(String[] args) {
//        BinaryTree<Integer> tree = new BinaryTree<>(8);
//        tree.setLeft(new BinaryTree<>(4));
//        tree.setRight(new BinaryTree<>(12));
//        tree.getLeft().setLeft(new BinaryTree<>(2));
//        tree.getLeft().setRight(new BinaryTree<>(6));
//        tree.getRight().setLeft(new BinaryTree<>(10));
//        tree.getRight().setRight(new BinaryTree<>(14));
//        tree.getLeft().getLeft().setLeft(new BinaryTree<>(1));
//        tree.getLeft().getLeft().setRight(new BinaryTree<>(3));
//        tree.getLeft().getRight().setLeft(new BinaryTree<>(5));
//        tree.getLeft().getRight().setRight(new BinaryTree<>(7));
//        tree.getRight().getLeft().setLeft(new BinaryTree<>(9));
//        tree.getRight().getLeft().setRight(new BinaryTree<>(11));
//        tree.getRight().getRight().setLeft(new BinaryTree<>(13));
//        tree.getRight().getRight().setRight(new BinaryTree<>(15));

        BinaryTree<Integer> tree = new BinaryTree<>(4);
        tree.setLeft(new BinaryTree<>(2));
        tree.setRight(new BinaryTree<>(6));
        tree.getLeft().setLeft(new BinaryTree<>(1));
         tree.getRight().setLeft(new BinaryTree<>(5));
        tree.getLeft().setRight(new BinaryTree<>(3));
        tree.getRight().setRight(new BinaryTree<>(7));

        System.out.println("Tree in Christmas tree shape:");
        tree.printTree(tree, 0);
//BFS
        tree.printInOrderTree(tree);

        tree.printPreOrderTree(tree);

        tree.printPostOrderTree(tree);
//BFS
        tree.printLevelOrderTree(tree);

    }
}