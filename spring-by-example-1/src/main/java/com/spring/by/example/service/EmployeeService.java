package com.spring.by.example.service;

import java.util.Set;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Role;
import com.spring.by.example.domain.Technology;

public interface EmployeeService {
	
	Set<Employee> getEmployeeListByRoleAndTechology(Role role, Technology technology);

}
