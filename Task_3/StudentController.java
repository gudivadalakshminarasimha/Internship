package Task_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentController {
	private static StudentManager studentManager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    addStudent(); 
                    break;
                case 2:
                    removeStudent();
                    break; 
                case 3:
                    updateStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    studentManager.saveToFile("students.dat");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student by ID");
        System.out.println("3. Update student details by ID");
        System.out.println("4. Search for a student by ID");
        System.out.println("5. Display all students");
        System.out.println("6. Exit and save data");
        System.out.print("Enter your choice: ");
    }
 
    private static void addStudent(){
    	boolean b = true;
        int id1 = 0;
         while (b) {
             System.out.print("Enter student ID: ");
             try {
                 int id = scanner.nextInt();
                 if (id > 0) { // Ensuring the ID is a positive integer
                     id1 = id;
                     b = false;
                 } else {
                     System.out.println("Please enter a positive integer value.");
                 }
             } catch (InputMismatchException e) {
                 System.out.println("Please enter a positive integer value.");
                 scanner.next(); // Clear the invalid input
             }
         }           
        System.out.print("Enter student name: "); 
        String name = scanner.nextLine();
        scanner.nextLine(); 
        System.out.print("Enter student age: ");
        b=true;
        int age1=0;
        while (b) {
            System.out.print("Enter student ID: ");
            try {
                int age = scanner.nextInt();
                if (age > 0) { // Ensuring the ID is a positive integer
                    age1 = age;
                    b = false;
                } else {
                    System.out.println("Please enter a positive integer value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a positive integer value.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.nextLine();  // Consume newline 
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        Student student = new Student(id1, name, age1, grade, address);
        studentManager.addStudent(student);
    } 
 
    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        studentManager.removeStudent(id);
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new student grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter new student address: ");
        String address = scanner.nextLine();

        studentManager.updateStudent(id, name, age, grade, address);
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        Student student = studentManager.searchStudent(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    } 

    private static void displayAllStudents() {
        studentManager.displayAllStudents();
    }
}
