/*
* StudentBST
* Purpose:
* Stores student records using a Binary Search Tree for sorted data.
*
* Features:
* - Insert Student
* - Search Student by ID
* - Display Students in sorted order
*/
public class StudentBST {

    private BSTNode root;

    // Constructor
    public StudentBST() {
        root = null;
    }

    public BSTNode getRoot() {
        return root;
    }

    // Public insert method
    public void insert(Student student) {
        root = insertRecursive(root, student);
    }
    // Display all students in sorted order
    public void displayStudents() {
        inOrderTraversal(root);
    }

    // In-order traversal
    private void inOrderTraversal(BSTNode node) {

        if (node != null) {

            inOrderTraversal(node.left);

            System.out.println(node.student);
            System.out.println("--------------------");

            inOrderTraversal(node.right);
        }
    }
    // Search student by ID
    public Student search(String studentId) {
        return searchRecursive(root, studentId);
    }

    // Recursive search
    private Student searchRecursive(BSTNode current, String studentId) {

        if (current == null) {
            return null;
        }

        int comparison = studentId.compareTo(
                current.student.getStudentId());

        if (comparison == 0) {
            return current.student;
        }

        if (comparison < 0) {
            return searchRecursive(current.left, studentId);
        }

        return searchRecursive(current.right, studentId);
    }
    // Recursive insert
    private BSTNode insertRecursive(BSTNode current, Student student) {

        // Insert if spot is empty
        if (current == null) {
            return new BSTNode(student);
        }

        int comparison = student.getStudentId()
                                .compareTo(current.student.getStudentId());

        // Go left
        if (comparison < 0) {
            current.left = insertRecursive(current.left, student);
        }

        // Go right
        else if (comparison > 0) {
            current.right = insertRecursive(current.right, student);
        }

        // Duplicate ID
        else {
            System.out.println("Error: Student ID Already Exists");
        }

        return current;
    }
}