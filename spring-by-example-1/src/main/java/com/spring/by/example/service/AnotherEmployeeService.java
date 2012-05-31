package com.spring.by.example.service;

import java.util.Set;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Position;

public interface AnotherEmployeeService {
	
	Set<Employee> getEmployeeListByPosition(Position position);

}
