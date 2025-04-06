import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display student details
    public void displayStudentDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

class StudentManagementSystem {
    private Student[] students;
    private int studentCount;
    private static final int MAX_STUDENTS = 100;

    public StudentManagementSystem() {
        students = new Student[MAX_STUDENTS];
        studentCount = 0;
    }


    public void addStudent(int id, String name, double marks) {
        if (studentCount < MAX_STUDENTS) {
            students[studentCount++] = new Student(id, name, marks);
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student limit reached. Cannot add more students.");
        }
    }

    // Display all students
    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println("Student " + (i + 1) + ":");
                students[i].displayStudentDetails();
                System.out.println();
            }
        }
    }

    public void searchStudentById(int id) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].id == id) {
                students[i].displayStudentDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new student
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    sms.addStudent(id, name, marks);
                    break;

                case 2:
                    // Display all students
                    sms.displayAllStudents();
                    break;

                case 3:
                    // Search for a student by ID
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    sms.searchStudentById(searchId);
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting Student Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
