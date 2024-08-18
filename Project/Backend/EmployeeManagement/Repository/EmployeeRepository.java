package com.example.EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagement.Dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

