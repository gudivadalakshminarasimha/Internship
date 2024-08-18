package com.example.EmployeeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.example.EmployeeManagement.Dto.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByUsername(String username);
}