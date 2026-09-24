/*
 * TestStudentHashTable
 * Purpose:
 * Tests the functionality of the StudentHashTable class.
 */
public class TestStudentHashTable {

    public static void main(String[] args) {

        StudentHashTable hashTable = new StudentHashTable();

        hashTable.addStudent(
                new Student("S001", "Himath", "IT", 85));

        hashTable.addStudent(
                new Student("S002", "John", "IT", 75));

        hashTable.addStudent(
                new Student("S003", "Nimal", "SE", 90));

        System.out.println("\nDisplaying Students:");

        hashTable.displayStudents();
    }
}