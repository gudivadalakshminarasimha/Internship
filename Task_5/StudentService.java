package Task_5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspStudent.dto.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	 public List<Student> getAllStudents() {
	        return repo.findAll();
	    }

	    public Student getStudentById(Long id) {
	        return repo.findById(id).orElse(null);
	    }

	    public Student updateStudent(Long id, Student studentDetails) {
	        Student student = repo.findById(id).orElse(null);
	        if (student != null) {
	            student.setName(studentDetails.getName());
	            student.setAge(studentDetails.getAge());
	            student.setGrade(studentDetails.getGrade());
	            student.setAddress(studentDetails.getAddress());
	            return repo.save(student);
	        }
	        return null;
	    }

	    public void deleteStudent(Long id) {
	    	repo.deleteById(id);
	    }
	
}
