/*
* StudentHashTable
* Purpose:
* Stores student records using HashMap for fast lookup.
*
* Features:
* - Add Student
* - Search Student by ID
* - Display Students
* - Duplicate ID Validation
*/
import java.util.HashMap;

public class StudentHashTable {

    private HashMap<String, Student> studentTable;

    // Constructor
    public StudentHashTable() {
        studentTable = new HashMap<>();
    }

    // Add student
    public void addStudent(Student student) {

        String studentId = student.getStudentId();

        if (studentTable.containsKey(studentId)) {
            System.out.println("Error: Student ID Already Exists");
            return;
        }

        studentTable.put(studentId, student);
        System.out.println("Student added successfully.");
    }
    // Search student by ID
    public Student searchStudent(String studentId) {

        if (studentTable.containsKey(studentId)) {
            return studentTable.get(studentId);
        }

        return null;
    }
        // Display all students
    public void displayStudents() {

        if (studentTable.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : studentTable.values()) {

            System.out.println(student);
            System.out.println("--------------------");
        }
    }
}