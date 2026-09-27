# University Student Record and Campus Route Management System

## Project Description

This project is a Java console-based application developed for the CIT300 Data Structures and Algorithms module.

The system is designed to manage university student records and campus routes using multiple data structures and algorithms. The application provides student record management, service request handling, efficient searching, and campus route management functionalities.

---

## Objectives

- Manage student records efficiently.
- Demonstrate the practical implementation of data structures and algorithms.
- Apply searching and traversal techniques in real-world scenarios.
- Manage campus locations and routes using graph data structures.
- Develop teamwork and collaboration skills using GitHub version control.

---

## Data Structures Used

- Linked List
- Stack
- Queue
- Binary Search Tree (BST)
- Hash Table (HashMap)
- Graph (Adjacency List)
- Breadth First Search (BFS)

---

## Technologies Used

- Java
- Visual Studio Code (VS Code)
- Git
- GitHub

---

## Features

### Student Management

- Add Student
- Search Student
- Update Student
- Delete Student
- Display Students

### Validation Features

- Duplicate Student ID Validation
- Marks Range Validation (0 - 100)
- Empty Name Validation
- Empty Programme Validation

### Service Request Management

- Add Service Request
- Process Service Requests (FIFO)
- Display Recent Actions

### BST and Hashing

- Display Students Using BST
- Search Students Using Hashing

### Campus Route Management

- Add Campus Locations
- Remove Campus Locations
- Add Connections
- Remove Connections
- Display Connections
- BFS Traversal

---

## Group Members

| Name | Student ID | Responsibility |
|------|------------|---------------|
| M.F.A. Himath | 23DA2-0895 | Linked List and Student Management |
| M.U.M. Usama Lathin | 23DA2-0838 | Stack and Queue |
| A.M. Arfan | 23DA2-0930 | BST and Hashing |
| M.I.M. Amhar | 23DA2-0515 | Graph and BFS |

---

## Project Structure

```text
src/
├── Main.java
├── Student.java
├── StudentLinkedList.java
├── ActionStack.java
├── ServiceQueue.java
├── BSTNode.java
├── StudentBST.java
├── StudentHashTable.java
└── CampusGraph.java
```

---

## How to Run

1. Open the project in Visual Studio Code.
2. Open a terminal inside the `src` folder.
3. Compile the project using:

```bash
javac *.java
```

4. Run the application using:

```bash
java Main
```

5. Select options from the menu to use The system.

---

## Functional Modules

### Linked List

Used for managing student records.

Functions:

- Add Student
- Search Student
- Update Student
- Delete Student
- Display Students

### Stack

Used to *aintain recent actions performed i* the system.

Functions:

- Store Recent Actions
- Display Recent Actions

### Queue

Used to manage student service requests.

Functions:
- Add Service Request
- Process Requests Using FIFO

### Binary Search Tree (BST)

Used to organize and Display student records in sorted order.

Functions:

- Insert Student
- Search Student
- Display Students

### Hashing

Used to perform efficient student searches using student IDs.

Functions:

- Fast Student Search
- Duplicate ID Detection

### Graph and BFS

Used to represent campus locations and route connections.

Functions:

- Add Location
- Remove Location
- Add Connection
- Remove Connection
- Display Connections
- Breadth First Search (BFS) Traversal

---

## Testing

The system was tested for:

- Student Record Operations
- Input Validations
- Stack Operations
- Queue Operations
- BST Operations
- Hash Search Operations
- Graph Operations
- BFS Traversal
- Error Handling

All functionalities were successfully tested and verified.

---

## Conclusion

This project successfully demonstrates the practical application of fundamental data structures and algorithms in a real-world university management scenario.

The system uses Linked Lists for student record management, Stacks for action history tracking, Queues for service request processing, Binary Search Trees (BST) for sorted student storage, Hash Tables for efficient student searching, and Graphs with Breadth First Search (BFS) for campus route management.

The project also showcases teamwork, GitHub collaboration, version control, pull requests, merging, and software integration skills. All required functionalities were implemented, tested, and integrated into a single Java console-based application.

---