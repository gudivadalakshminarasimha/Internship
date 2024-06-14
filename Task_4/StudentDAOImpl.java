package Task_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDao {

	@Override
	public void addStudent(Student student) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_dto", "root", "root");
		Statement sta= con.createStatement();
		sta.execute("insert into student values("+student.id+",'"+student.name+"','"+student.age+"','"+student.grade+"','"+student.address+"')");
		sta.close();
		
	}

	@Override
	public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
		List<Student> students = new ArrayList();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_dto", "root", "root");
		PreparedStatement sta=con.prepareStatement("SELECT * FROM student");
		 ResultSet rs = sta.executeQuery();
		while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGrade(rs.getString("grade"));
            student.setAddress(rs.getString("address"));
            students.add(student);
        }
		return students;
	}

	@Override
	public Student getStudentById(Long id) throws ClassNotFoundException,SQLException {
		Student student = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_dto", "root", "root");
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student WHERE id = ?");
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
				 if (rs.next()) {
	                    student = new Student();
	                    student.setId(rs.getLong("id"));
	                    student.setName(rs.getString("name"));
	                    student.setAge(rs.getInt("age"));
	                    student.setGrade(rs.getString("grade"));
	                    student.setAddress(rs.getString("address"));
	                }
		 return student;
	
	}

	@Override
	public void updateStudent(Student student) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_dto", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("UPDATE student SET name = ?, age = ?, grade = ?, address = ? WHERE id = ?");
		pstmt.setString(1, student.getName());
        pstmt.setInt(2, student.getAge());
        pstmt.setString(3, student.getGrade());
        pstmt.setString(4, student.getAddress());
        pstmt.setLong(5, student.getId());
        pstmt.executeUpdate();
	}

	@Override
	public void deleteStudent(Long id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_dto", "root", "root");
		PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE id = ?");
		ps.setLong(1, id);
        ps.executeUpdate();
	}

}
