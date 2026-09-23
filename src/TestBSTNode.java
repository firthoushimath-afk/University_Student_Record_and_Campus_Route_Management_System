public class TestBSTNode {

    public static void main(String[] args) {

        Student student = new Student(
                "S001",
                "Himath",
                "IT",
                85);

        BSTNode node = new BSTNode(student);

        System.out.println(node.student);
    }
}