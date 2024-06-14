package Task_4;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
	 private StudentDao studentDAO;

	    public StudentService() {
	        this.studentDAO = new StudentDAOImpl();
	    }
	    
	    public void addStudent(Student student) {
	        try {
				studentDAO.addStudent(student);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	    }
	    public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
	        return studentDAO.getAllStudents();
	    }

	    public Student getStudentById(Long id) throws ClassNotFoundException, SQLException {
	        return studentDAO.getStudentById(id);
	    }

	    public void updateStudent(Student student) throws ClassNotFoundException, SQLException {
	        studentDAO.updateStudent(student);
	    }

	    public void deleteStudent(Long id) throws ClassNotFoundException, SQLException {
	        studentDAO.deleteStudent(id);
	    }
}
