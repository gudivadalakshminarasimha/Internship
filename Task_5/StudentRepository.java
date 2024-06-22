package Task_5;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspStudent.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
