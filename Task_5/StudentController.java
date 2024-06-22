package Task_5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Service.StudentService;
import com.jspStudent.dto.Student;

@RestController
public class StudentController {
	
		
	 @Autowired
	    private StudentService service;

	    @PostMapping("/save")
	    public Student saveStudent(@RequestBody Student student) {
	        return service.saveStudent(student);
	    }

	    @GetMapping("/fetch")
	    public List<Student> getAllStudents() {
	        return service.getAllStudents();
	    }

	    @GetMapping("/id")
	    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
	        Student student = service.getStudentById(id);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        }
	        return ResponseEntity.notFound().build();
	    }

	    @PutMapping("/id")
	    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
	        Student updatedStudent = service.updateStudent(id, studentDetails);
	        if (updatedStudent != null) {
	            return ResponseEntity.ok(updatedStudent);
	        }
	        return ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/id")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
	        service.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
