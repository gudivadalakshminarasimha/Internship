package Task_4;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
	  private static StudentService studentService = new StudentService();
	    private static Scanner scanner = new Scanner(System.in);
	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	        while (true) {
	            printMenu();
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    addStudent();
	                    break;
	                case 2:
	                    viewAllStudents();
	                    break;
	                case 3:
	                    viewStudentById();
	                    break;
	                case 4:
	                    updateStudent();
	                    break;
	                case 5:
	                    deleteStudent();
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	    private static void printMenu() {
			System.out.println("\nStudent Management System");
	        System.out.println("1. Add a new student");
	        System.out.println("2. View all students");
	        System.out.println("3. View a student by ID");
	        System.out.println("4. Update a student");
	        System.out.println("5. Delete a student");
	        System.out.println("6. Exit");
	        System.out.print("Enter your choice: ");
			
		}
		private static void deleteStudent() throws ClassNotFoundException, SQLException {
			System.out.print("Enter student ID: ");
	        Long id = scanner.nextLong();
	        scanner.nextLine(); 

	        studentService.deleteStudent(id);
	        System.out.println("Student deleted successfully!");
			
		}
		private static void updateStudent() throws ClassNotFoundException, SQLException {
			System.out.print("Enter student ID: ");
	        Long id = scanner.nextLong();
	        scanner.nextLine();

	        Student student = studentService.getStudentById(id);
	        if (student != null) {
	            System.out.print("Enter new name: ");
	            String name = scanner.nextLine();
	            System.out.print("Enter new age: ");
	            int age = scanner.nextInt();
	            scanner.nextLine(); 
	            System.out.print("Enter new grade: ");
	            String grade = scanner.nextLine();
	            System.out.print("Enter new address: ");
	            String address = scanner.nextLine();

	            student.setName(name);
	            student.setAge(age);
	            student.setGrade(grade);
	            student.setAddress(address);

	            studentService.updateStudent(student);
	            System.out.println("Student updated successfully!");
	        } else {
	            System.out.println("Student not found.");
	        }
			
		}
		private static void viewStudentById() throws ClassNotFoundException, SQLException {
			System.out.print("Enter student ID: ");
	        Long id = scanner.nextLong();
	        scanner.nextLine(); 

	        Student student = studentService.getStudentById(id);
	        if (student != null) {
	            System.out.println(student);
	        } else {
	            System.out.println("Student not found.");
	        }
			
		}
		private static void viewAllStudents() throws ClassNotFoundException, SQLException {
			 List<Student> students = studentService.getAllStudents();
		        for (Student student : students) {
		            System.out.println(student);
		        }
			
		}
		private static void addStudent() {
			System.out.print("Enter id: ");
			long id=scanner.nextLong();
			scanner.nextLine(); 
			 System.out.print("Enter name: ");
		        String name = scanner.nextLine();
		        System.out.print("Enter age: ");
		        int age = scanner.nextInt();
		        scanner.nextLine(); 
		        System.out.print("Enter grade: ");
		        String grade = scanner.nextLine();
		        System.out.print("Enter address: ");
		        String address = scanner.nextLine();

		        Student student = new Student(id,name, age, grade, address);
		        studentService.addStudent(student);
		        System.out.println("Student added successfully!");
		    }
			
		}
