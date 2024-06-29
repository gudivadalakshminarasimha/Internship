package Task_4;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	 @Autowired
	    private EmployeeRepository employeeRepository;

	    // CRUD operations

	    public Employee addEmployee(Employee employee) {
	        validateEmployee(employee);
	        return employeeRepository.save(employee);
	    }

	    public Employee updateEmployee(Employee employee) {
	        validateEmployee(employee);
	        return employeeRepository.save(employee);
	    }

	    public void deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	    }

	    public Optional<Employee> getEmployee(Long id) {
	        return employeeRepository.findById(id);
	    }

	    public List<Employee> getEmployeesByDepartment(String department) {
	        return employeeRepository.findByDepartment(department);
	    }

	    public void updateEmployeeSalary(Long id, BigDecimal salary) {
	        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	        employee.setSalary(salary);
	        employeeRepository.save(employee);
	    }

	    // Calculate Total Salary by Department
	    public BigDecimal calculateTotalSalaryByDepartment(String department) {
	        return employeeRepository.findByDepartment(department).stream()
	                .map(Employee ::getSalary)
	                .reduce(BigDecimal.ZERO, BigDecimal::add);
	    }

	    // Find Employees by Joining Date Range
	    public List<Employee> findEmployeesByJoiningDateRange(LocalDate startDate, LocalDate endDate) {
	        return employeeRepository.findByJoiningDateBetween(startDate, endDate);
	    }

	    // Update Employee Position Based on Experience
	    public void updateEmployeePositionBasedOnExperience(Long id, int yearsOfExperience) {
	        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	        if (yearsOfExperience > 5) {
	            employee.setPosition("Senior " + employee.getPosition());
	            employeeRepository.save(employee);
	        }
	    }

	    // Generate Employee Report
	    public String generateEmployeeReport(Long id) {
	        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	        return String.format("Employee Report:\nName: %s\nPosition: %s\nDepartment: %s\nSalary: %s\n",
	                employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getSalary().toString());
	    }

	    // Validate Employee Data
	    private void validateEmployee(Employee employee) {
	        if (employee.getName() == null || employee.getName().isEmpty()) {
	            throw new IllegalArgumentException("Name cannot be empty");
	        }
	        if (employee.getSalary() == null || employee.getSalary().compareTo(BigDecimal.ZERO) <= 0) {
	            throw new IllegalArgumentException("Salary must be a positive number");
	        }
	        if (!employee.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}")) {
	            throw new IllegalArgumentException("Invalid email format");
	        }
	    }

	    // Calculate Average Salary by Position
	    public BigDecimal calculateAverageSalaryByPosition(String position) {
	        List<Employee> employees = employeeRepository.findByPosition(position);
	        return employees.stream()
	                .map(Employee::getSalary)
	                .reduce(BigDecimal.ZERO, BigDecimal::add)
	                .divide(BigDecimal.valueOf(employees.size()), BigDecimal.ROUND_HALF_UP);
	    }

	    // Employee Promotion Eligibility Check
	    public boolean checkPromotionEligibility(Long id, int performanceScore, int yearsOfService) {
	        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	        return performanceScore > 8 && yearsOfService > 3;
	    }

	    // Send Notification to Employees
	    public void sendNotificationToEmployees(String message) {
	        // For simplicity, just print the message to the console
	        employeeRepository.findAll().forEach(employee -> System.out.println("Notification to " + employee.getName() + ": " + message));
	    }

	    // Department Performance Analysis
	    public List<String> analyzeDepartmentPerformance() {
	        // For simplicity, assume performance scores are stored in Employee entity and are integers
	        return employeeRepository.findAll().stream()
	                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee ::getPerfomanecscore)))
	                .entrySet().stream()
	                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
	                .map(Map.Entry::getKey)
	                .collect(Collectors.toList());
	    }	

	    // Update Department Budget Based on Employee Count
	    public BigDecimal updateDepartmentBudgetBasedOnEmployeeCount(String department, BigDecimal budgetPerEmployee) {
	        long employeeCount = employeeRepository.findByDepartment(department).size();
	        return budgetPerEmployee.multiply(BigDecimal.valueOf(employeeCount));
	    }

	    // Find Top N Highest Paid Employees
	    public List<Employee> findTopNHighestPaidEmployees(int n) {
	        return employeeRepository.findTopByOrderBySalaryDesc(PageRequest.of(0, n));
	    }

	    // Check for Duplicate Employees
	    public List<Employee> checkForDuplicateEmployees() {
	        return employeeRepository.findAll().stream()
	                .collect(Collectors.groupingBy(Employee::getEmail))
	                .entrySet().stream()
	                .filter(entry -> entry.getValue().size() > 1)
	                .flatMap(entry -> entry.getValue().stream())
	                .collect(Collectors.toList());
	    }
}
