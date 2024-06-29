package Task_4;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
@RestController
@RequestMapping("/employees")
public class EmployeeController  {

	 @Autowired
	    private EmployeeService employeeService;

	    @PostMapping
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return employeeService.addEmployee(employee);
	    }

	    @PutMapping
	    public Employee updateEmployee(@RequestBody Employee employee) {
	        return employeeService.updateEmployee(employee);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	    }

	    @GetMapping("/{id}")
	    public Optional<Employee> getEmployee(@PathVariable Long id) {
	        return employeeService.getEmployee(id);
	    }

	    @GetMapping("/department/{department}")
	    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
	        return employeeService.getEmployeesByDepartment(department);
	    }

	    @PutMapping("/{id}/salary")
	    public void updateEmployeeSalary(@PathVariable Long id, @RequestParam BigDecimal salary) {
	        employeeService.updateEmployeeSalary(id, salary);
	    }

	    @GetMapping("/total-salary/{department}")
	    public BigDecimal calculateTotalSalaryByDepartment(@PathVariable String department) {
	        return employeeService.calculateTotalSalaryByDepartment(department);
	    }

	    @GetMapping("/date-range")
	    public List<Employee> findEmployeesByJoiningDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
	        return employeeService.findEmployeesByJoiningDateRange(startDate, endDate);
	    }

	    @PutMapping("/{id}/position")
	    public void updateEmployeePositionBasedOnExperience(@PathVariable Long id, @RequestParam int yearsOfExperience) {
	        employeeService.updateEmployeePositionBasedOnExperience(id, yearsOfExperience);
	    }

	    @GetMapping("/{id}/report")
	    public String generateEmployeeReport(@PathVariable Long id) {
	        return employeeService.generateEmployeeReport(id);
	    }

	    @GetMapping("/average-salary/{position}")
	    public BigDecimal calculateAverageSalaryByPosition(@PathVariable String position) {
	        return employeeService.calculateAverageSalaryByPosition(position);
	    }

	    @GetMapping("/{id}/promotion-eligibility")
	    public boolean checkPromotionEligibility(@PathVariable Long id, @RequestParam int performanceScore, @RequestParam int yearsOfService) {
	        return employeeService.checkPromotionEligibility(id, performanceScore, yearsOfService);
	    }

	    @PostMapping("/notifications")
	    public void sendNotificationToEmployees(@RequestParam String message) {
	        employeeService.sendNotificationToEmployees(message);
	    }

	    @GetMapping("/department-performance")
	    public List<String> analyzeDepartmentPerformance() {
	        return employeeService.analyzeDepartmentPerformance();
	    }

	    @PutMapping("/department-budget")
	    public BigDecimal updateDepartmentBudgetBasedOnEmployeeCount(@RequestParam String department, @RequestParam BigDecimal budgetPerEmployee) {
	        return employeeService.updateDepartmentBudgetBasedOnEmployeeCount(department, budgetPerEmployee);
	    }

	    @GetMapping("/top-salaries")
	    public List<Employee> findTopNHighestPaidEmployees(@RequestParam int n) {
	        return employeeService.findTopNHighestPaidEmployees(n);
	    }

	    @GetMapping("/duplicates")
	    public List<Employee> checkForDuplicateEmployees() {
	        return employeeService.checkForDuplicateEmployees();
	    }

}
