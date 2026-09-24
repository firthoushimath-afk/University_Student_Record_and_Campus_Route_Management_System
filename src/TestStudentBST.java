public class TestStudentBST {

    public static void main(String[] args) {

        StudentBST bst = new StudentBST();

        bst.insert(new Student("S002", "John", "IT", 75));
        bst.insert(new Student("S001", "Himath", "IT", 85));
        bst.insert(new Student("S003", "Nimal", "SE", 90));

        System.out.println("Searching for S001");

        Student found = bst.search("S001");

        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Student Not Found");
        }

        System.out.println("\nSearching for S999");

        Student notFound = bst.search("S999");

        if (notFound != null) {
            System.out.println(notFound);
        } else {
            System.out.println("Student Not Found");
        }
    }
}