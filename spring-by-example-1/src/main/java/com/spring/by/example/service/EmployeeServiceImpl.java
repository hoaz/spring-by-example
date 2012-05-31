package com.spring.by.example.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Role;
import com.spring.by.example.domain.Technology;
import com.spring.by.example.ds.EmployeeDS;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDS employeeDS;

	@Override
	public Set<Employee> getEmployeeListByRoleAndTechology(Role role, Technology technology) {
		Set<Employee> result = new HashSet<Employee>();
		for (Employee employee : employeeDS.getEmployees()) {
			if (employee.getRole() == role && employee.getTechnology() == technology) {
				result.add(employee);
			}
		}		
		return result;
	}
	
	

}
