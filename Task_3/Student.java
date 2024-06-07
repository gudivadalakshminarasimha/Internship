package Task_3;

import java.util.Objects;

public class Student implements Comparable<Student> {
	
	private int id;
	private String name;
	private int age;
	private String grade;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	} 
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(int id, String name, int age, String grade, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.address = address;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", address=" + address
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, age, grade, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(grade, other.grade)
				&& id == other.id && Objects.equals(name, other.name);
	}
	
	 public int compareTo(Student other) {
	        return Integer.compare(this.id, other.id);
	    }
}
