package Task_3;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class StudentManager {
	private ArrayList<Student> students = new ArrayList<>();
    private HashMap<Integer, Student> studentMap = new HashMap<>();
    private TreeSet<Student> studentSet = new TreeSet<>();

	
	public void addStudent(Student student)  {
		if(studentMap.containsKey(student.getId())) {
			id i= new id();
			System.out.println(i.getMsg());
			
		}if(student.getAge()<0) {
			age a= new age();
			System.out.println(a.getMsg()); 
	 	} 
		students.add(student);
        studentMap.put(student.getId(), student);
        studentSet.add(student);
	}  
	public void removeStudent(int id) throws id {
		Student student = studentMap.get(id);	
		if(student != null) {
			students.remove(student);
			studentMap.remove(id);
			studentSet.remove(student);
		}else {
			throw new id();
		}
	}
	public void updateStudent(int id, String name, int age, String grade, String address) {
		Student student = studentMap.get(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age); 
            student.setGrade(grade);
            student.setAddress(address);
        } else {
            System.out.println("Student not found.");
        }
	} 
	public Student searchStudent(int id) {
		return studentMap.get(id);
	}
	 public void displayAllStudents() {
	        for (Student student : studentSet) {
	            System.out.println(student);
	        }
	    }
	 public void loadFromFile(String filename) {
		 try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename))){
			 students = (ArrayList<Student>) ois.readObject();
	            studentMap.clear();
	            studentSet.clear();
	            for (Student student : students) {
	                studentMap.put(student.getId(), student);
	                studentSet.add(student);
	            }
		 }
		 catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error loading from file: " + e.getMessage());
	        }
	 }
	 public void saveToFile(String filename) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
	            oos.writeObject(students);
	        } catch (IOException e) {
	            System.out.println("Error saving to file: " + e.getMessage());
	        }
	    }
}
