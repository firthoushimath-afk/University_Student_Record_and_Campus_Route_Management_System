public class Main {

    public static void main(String[] args) {

        StudentLinkedList studentList = new StudentLinkedList();

        studentList.addStudent(
                new Student("S001", "Himath", "IT", 85));

        studentList.addStudent(
                new Student("S002", "Arfan", "CS", 78));

        studentList.addStudent(
                new Student("S003", "Usama", "SE", 90));

        boolean deleted = studentList.deleteStudent("S002");

        if (deleted) {
            System.out.println("Student Deleted Successfully");
        } else {
            System.out.println("Student Not Found");
        }

        studentList.displayStudents();
    }
}