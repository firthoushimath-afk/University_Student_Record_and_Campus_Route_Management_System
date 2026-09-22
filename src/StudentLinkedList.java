public class StudentLinkedList {

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;

    public StudentLinkedList() {
        head = null;
    }

    public boolean addStudent(Student student) {

        if (head == null) {
            head = new Node(student);
            return true;
        }

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId()
                    .equalsIgnoreCase(student.getStudentId())) {

                return false; // Duplicate ID
            }

            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        current.next = new Node(student);
        return true;
    }

    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.student);
            System.out.println("----------------------");
            current = current.next;
        }
    }

    public Student searchStudent(String studentId) {

    Node current = head;

    while (current != null) {

        if (current.student.getStudentId()
                .equalsIgnoreCase(studentId)) {

            return current.student;
        }

        current = current.next;
    }

    return null;
    }

    public boolean updateStudent(String studentId,
                             String newName,
                             String newProgramme,
                             double newMarks) {

    Student student = searchStudent(studentId);

    if (student == null) {
        return false;
    }

    student.setName(newName);
    student.setProgramme(newProgramme);
    student.setMarks(newMarks);

    return true;
    }

    public boolean deleteStudent(String studentId) {

    if (head == null) {
        return false;
    }

    if (head.student.getStudentId()
            .equalsIgnoreCase(studentId)) {

        head = head.next;
        return true;
    }

    Node current = head;

    while (current.next != null) {

        if (current.next.student.getStudentId()
                .equalsIgnoreCase(studentId)) {

            current.next = current.next.next;
            return true;
        }

        current = current.next;
    }

    return false;
    }

}
