package Task_4;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	 List<Employee> findByDepartment(String department);
	    List<Employee> findByJoiningDateBetween(LocalDate startDate, LocalDate endDate);
	    List<Employee> findByEmail(String email);
		List<Employee> findByPosition(String position);
		List<Employee> findTopByOrderBySalaryDesc(PageRequest pageRequest);
}
