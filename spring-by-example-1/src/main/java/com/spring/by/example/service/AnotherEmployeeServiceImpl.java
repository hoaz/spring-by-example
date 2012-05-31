package com.spring.by.example.service;

import java.util.HashSet;
import java.util.Set;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Position;
import com.spring.by.example.ds.EmployeeDS;

public class AnotherEmployeeServiceImpl implements  AnotherEmployeeService {
	
	private EmployeeDS employeeDS;	

	public void setEmployeeDS(EmployeeDS employeeDS) {
		this.employeeDS = employeeDS;
	}

	@Override
	public Set<Employee> getEmployeeListByPosition(Position position) {
		Set<Employee> result  = new HashSet<Employee>();
		for (Employee employee : employeeDS.getEmployees()) {
			if (employee.getPosition() == position) {
				result.add(employee);
			}
		}
		return result;
	}

}
