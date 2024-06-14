package Task_4;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
	 void addStudent(Student student) throws ClassNotFoundException, SQLException;
	    List<Student> getAllStudents() throws ClassNotFoundException, SQLException;
	    Student getStudentById(Long id) throws ClassNotFoundException, SQLException;
	    void updateStudent(Student student) throws ClassNotFoundException, SQLException;
	    void deleteStudent(Long id) throws ClassNotFoundException, SQLException;
}
