package three;
public class Main {
    public static void main(String[] args) {
        Student student1Group1 = new Student("Алексей", 4);
        Student student2Group1 = new Student("Екатерина", 5);
        Student student3Group1 = new Student("Андрей", 3);
        Student student4Group1 = new Student("Ольга", 4);

        Student student1Group2 = new Student("Иван", 3);
        Student student2Group2 = new Student("Мария", 5);
        Student student3Group2 = new Student("Николай", 4);
        Student student4Group2 = new Student("Анна", 5);

        BinarySearchTree<Student> group1Tree = new BinarySearchTree<>();
        BinarySearchTree<Student> group2Tree = new BinarySearchTree<>();

        group1Tree.insert(student1Group1);
        group1Tree.insert(student2Group1);
        group1Tree.insert(student3Group1);
        group1Tree.insert(student4Group1);

        group2Tree.insert(student1Group2);
        group2Tree.insert(student2Group2);
        group2Tree.insert(student3Group2);
        group2Tree.insert(student4Group2);

        BinarySearchTree<Student> excellentStudentsTree = new BinarySearchTree<>();

        searchAndAddExcellentStudent(group1Tree, excellentStudentsTree);

        searchAndAddExcellentStudent(group2Tree, excellentStudentsTree);

        System.out.println("Group 1 Tree:");
        printTree(group1Tree);
        System.out.println("\nGroup 2 Tree:");
        printTree(group2Tree);
        System.out.println("\nExcellent Students Tree:");
        printTree(excellentStudentsTree);
    }

    private static void printTree(AbstractBinarySearchTree<Student> tree) {
        printTreeHelper(tree.getRoot(), 0);
    }
    private static void printTreeHelper(AbstractBinarySearchTree.Node<Student> node, int level) {
        if (node != null) {
            printTreeHelper(node.rightChild, level + 1);

            for (int i = 0; i < level * 4; i++) {
                System.out.print(" ");
            }
            System.out.println(node.value.getName() + " - " + node.value.getGrade());

            printTreeHelper(node.leftChild, level + 1);
        }
    }

    private static void searchAndAddExcellentStudent(
            AbstractBinarySearchTree<Student> sourceTree,
            AbstractBinarySearchTree<Student> excellentStudentsTree) {
        searchAndAddExcellentStudentHelper(sourceTree.getRoot(), excellentStudentsTree);
    }

    private static void searchAndAddExcellentStudentHelper(
            AbstractBinarySearchTree.Node<Student> node,
            AbstractBinarySearchTree<Student> excellentStudentsTree) {
        if (node != null) {
            searchAndAddExcellentStudentHelper(node.leftChild, excellentStudentsTree);

            if (node.value.getGrade() == 5) {
                excellentStudentsTree.insert(node.value);
            }

            searchAndAddExcellentStudentHelper(node.rightChild, excellentStudentsTree);
        }
    }


    private static void inOrderTraversal(AbstractBinarySearchTree.Node<Student> node) {
        if (node != null) {
            inOrderTraversal(node.leftChild);
            System.out.println(node.value.getName() + " - " + node.value.getGrade());
            inOrderTraversal(node.rightChild);
        }
    }
}
