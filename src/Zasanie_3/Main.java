package Zasanie_3;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Student> excellentStudentsTree1 = new BinarySearchTree<>();
        excellentStudentsTree1.insert(new Student("Алиса", 95));
        excellentStudentsTree1.insert(new Student("Богдан", 98));
        excellentStudentsTree1.insert(new Student("Саша", 92));
        excellentStudentsTree1.insert(new Student("Дима", 96));
        excellentStudentsTree1.insert(new Student("Ева", 94));

        BinarySearchTree<Student> excellentStudentsTree2 = new BinarySearchTree<>();
        excellentStudentsTree2.insert(new Student("Филипп", 97));
        excellentStudentsTree2.insert(new Student("Герман", 91));
        excellentStudentsTree2.insert(new Student("Юля", 93));
        excellentStudentsTree2.insert(new Student("Илья", 99));
        excellentStudentsTree2.insert(new Student("Арина", 100));

        System.out.println("Отличные студенты первой группы:");
        printTreeInChristmasTreeShape(excellentStudentsTree1.getRoot(), "");

        System.out.println("Отличные студенты второй группы:");
        printTreeInChristmasTreeShape(excellentStudentsTree2.getRoot(), "");
    }

    private static void printTreeInChristmasTreeShape(AbstractBinarySearchTree.Node<Student> root, String prefix) {
        if (root != null) {
            System.out.println(prefix + root.value.getName() + ": " + root.value.getGrade());
            if (root.leftChild != null || root.rightChild != null) {
                printTreeInChristmasTreeShape(root.leftChild, prefix + "    ");
                printTreeInChristmasTreeShape(root.rightChild, prefix + "    ");
            }
        }
    }
}