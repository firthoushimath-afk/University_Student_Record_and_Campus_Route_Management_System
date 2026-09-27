import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();

        ActionStack actionStack = new ActionStack();
        ServiceQueue serviceQueue = new ServiceQueue();

        StudentBST studentBST = new StudentBST();
        StudentHashTable studentHashTable = new StudentHashTable();

        CampusGraph campusGraph = new CampusGraph();

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
            System.out.println("6. Add Service Request");
            System.out.println("7. Process Next Service Request");
            System.out.println("8. Display Recent Actions");
            System.out.println("9. Display Students using BST");
            System.out.println("10. Search Student using Hashing");
            System.out.println("11. Add Campus Location");
            System.out.println("12. Remove Campus Location");
            System.out.println("13. Add Campus Connection");
            System.out.println("14. Remove Campus Connection");
            System.out.println("15. Display Campus Connections");
            System.out.println("16. BFS Traversal");
            System.out.println("17. Exit");           
            System.out.println("======================================");
            System.out.print("Enter Choice : ");

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n========== ADD STUDENT ==========");

                    input.nextLine();

                    System.out.print("Enter Student ID : ");
                    String id = input.nextLine();

                    String name;

                    while (true) {

                        System.out.print("Enter Student Name : ");
                        name = input.nextLine().trim();

                        if (!name.isEmpty()) {
                            break;
                        }

                        System.out.println("Error: Name Cannot Be Empty!");
                    }

                    String programme;

                    while (true) {

                        System.out.print("Enter Programme : ");
                        programme = input.nextLine().trim();

                        if (!programme.isEmpty()) {
                            break;
                        }

                        System.out.println("Error: Programme Cannot Be Empty!");
                    }

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

                        studentBST.insert(student);

                        studentHashTable.addStudent(student);

                        System.out.println("\nStudent Added Successfully!");

                        actionStack.addAction("Added Student " + id);

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

                        studentList.rebuildBST(studentBST);
                        System.out.println("\nStudent Updated Successfully!");
                            actionStack.addAction("Updated Student " + updateId);

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

                        studentHashTable.removeStudent(deleteId);

                        studentList.rebuildBST(studentBST);

                        System.out.println("\nStudent Deleted Successfully!");
                            actionStack.addAction("Deleted Student " + deleteId);

                    } else {

                        System.out.println("\nError: Student Not Found!");
                    }

                    break;

                case 5:

                    studentList.displayStudents();

                    break;

                case 6:

                    input.nextLine();

                    System.out.println("\n========== ADD SERVICE REQUEST ==========");

                    System.out.print("Enter Service Request : ");
                    String request = input.nextLine();

                    serviceQueue.addRequest(request);

                    break;

                case 7:

                    System.out.println("\n========== PROCESS NEXT REQUEST ==========");

                    serviceQueue.processNextRequest();

                    break;

                case 8:

                    System.out.println("\n========== RECENT ACTIONS ==========");

                    actionStack.displayRecentActions();

                    break;

                case 9:

                    System.out.println("\n========== BST STUDENT DISPLAY ==========");

                    studentBST.displayStudents();

                    break;

                case 10:

                    input.nextLine();

                    System.out.println("\n========== HASH SEARCH ==========");

                    System.out.print("Enter Student ID : ");
                    String hashId = input.nextLine();

                    Student hashStudent =
                            studentHashTable.searchStudent(hashId);

                    if (hashStudent != null) {

                        System.out.println("\nStudent Found");

                        System.out.println(hashStudent);

                    } else {

                        System.out.println("\nError: Student Not Found!");
                    }

                    break;

                case 11:

                    input.nextLine();

                    System.out.println("\n========== ADD CAMPUS LOCATION ==========");

                    System.out.print("Enter Location Name : ");
                    String location = input.nextLine();

                    campusGraph.addLocation(location);

                    break;

                case 12:

                    input.nextLine();

                    System.out.println("\n========== REMOVE CAMPUS LOCATION ==========");

                    System.out.print("Enter Location Name : ");
                    String removeLocation = input.nextLine();

                    campusGraph.removeLocation(removeLocation);

                    break;

                case 13:

                    input.nextLine();

                    System.out.println("\n========== ADD CAMPUS CONNECTION ==========");

                    System.out.print("Enter First Location : ");
                    String location1 = input.nextLine();

                    System.out.print("Enter Second Location : ");
                    String location2 = input.nextLine();

                    campusGraph.addConnection(location1, location2);

                    break;
                    
                case 14:

                    input.nextLine();

                    System.out.println("\n========== REMOVE CAMPUS CONNECTION ==========");

                    System.out.print("Enter First Location : ");
                    String removeLocation1 = input.nextLine();

                    System.out.print("Enter Second Location : ");
                    String removeLocation2 = input.nextLine();

                    campusGraph.removeConnection(
                            removeLocation1,
                            removeLocation2);

                    break;

                case 15:

                    System.out.println("\n========== CAMPUS CONNECTIONS ==========");

                    campusGraph.displayConnections();

                    break;

                case 16:

                    input.nextLine();

                    System.out.println("\n========== BFS TRAVERSAL ==========");

                    System.out.print("Enter Start Location : ");
                    String startLocation = input.nextLine();

                    campusGraph.bfsTraversal(startLocation);

                    break;

                case 17:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 17);

        input.close();
    }
}