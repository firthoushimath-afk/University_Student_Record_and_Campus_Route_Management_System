import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println(" UNIVERSITY MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");

            System.out.println("======================================");
            System.out.print("Enter Choice : ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n========== ADD STUDENT ==========");

                    input.nextLine();

                    System.out.print("Enter Student ID : ");
                    String id = input.nextLine();

                    System.out.print("Enter Student Name : ");
                    String name = input.nextLine();

                    System.out.print("Enter Programme : ");
                    String programme = input.nextLine();

                    double marks;

                    while (true) {

                        System.out.print("Enter Marks (0 - 100) : ");
                        marks = input.nextDouble();

                        if (marks >= 0 && marks <= 100) {
                            break;
                        }

                        System.out.println("Error: Marks must be between 0 and 100.");
}
                    Student student = new Student(id, name, programme, marks);

                    if (studentList.addStudent(student)) {
                        System.out.println("\nStudent Added Successfully!");
                    } else {
                        System.out.println("\nError: Student ID Already Exists!");
                    }

                    break;

                case 2:

                    input.nextLine();

                    System.out.println("\n========== SEARCH STUDENT ==========");

                    System.out.print("Enter Student ID : ");
                    String searchId = input.nextLine();

                    Student foundStudent =
                            studentList.searchStudent(searchId);

                    if (foundStudent != null) {

                        System.out.println("\nStudent Found");
                        System.out.println("--------------------------------");

                        System.out.println("Student ID : "
                                + foundStudent.getStudentId());

                        System.out.println("Name       : "
                                + foundStudent.getName());

                        System.out.println("Programme  : "
                                + foundStudent.getProgramme());

                        System.out.println("Marks      : "
                                + foundStudent.getMarks());

                    } else {

                        System.out.println("\nError: Student Not Found!");
                    }

                    break;

                case 3:

                    input.nextLine();

                    System.out.println("\n========== UPDATE STUDENT ==========");

                    System.out.print("Enter Student ID : ");
                    String updateId = input.nextLine();

                    System.out.print("Enter New Name : ");
                    String newName = input.nextLine();

                    System.out.print("Enter New Programme : ");
                    String newProgramme = input.nextLine();

                    double newMarks;

                    while (true) {

                        System.out.print("Enter New Marks (0 - 100) : ");
                        newMarks = input.nextDouble();

                        if (newMarks >= 0 && newMarks <= 100) {
                            break;
                        }

                        System.out.println("Error: Marks must be between 0 and 100.");
                    }

                    if (studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks)) {

                        System.out.println("\nStudent Updated Successfully!");

                    } else {

                        System.out.println("\nError: Student Not Found!");
                    }

                    break;

                case 4:

                    input.nextLine();

                    System.out.println("\n========== DELETE STUDENT ==========");

                    System.out.print("Enter Student ID : ");
                    String deleteId = input.nextLine();

                    if (studentList.deleteStudent(deleteId)) {

                        System.out.println("\nStudent Deleted Successfully!");

                    } else {

                        System.out.println("\nError: Student Not Found!");
                    }

                    break;

                case 5:

                    studentList.displayStudents();

                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        input.close();
    }
}