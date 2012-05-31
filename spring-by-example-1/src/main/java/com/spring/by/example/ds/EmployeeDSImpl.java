package com.spring.by.example.ds;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Role;
import com.spring.by.example.domain.Technology;

@Repository
public class EmployeeDSImpl implements EmployeeDS {


	private Set<Employee> employees = new HashSet<Employee>();
	
	private @Value ("${me.firstName}") String myFirstName;
	private @Value ("${me.lastName}") String myLastName;
	private @Value ("${me.role}") String myRole;
	private @Value ("${me.technology}") String myTechnology;
	
	private @Value ("${eugene.firstName}") String eugeneFirstName; 
	private @Value ("${eugene.lastName}") String eugeneLastName;
	private @Value ("${eugene.role}") String eugeneRole;
	private @Value ("${eugene.technology}") String eugeneTechnology;
	

	@SuppressWarnings("unused")
	@PostConstruct
	private void buildMe() {
		Employee me = new Employee();
		me.setFirstName(myFirstName);
		me.setLastName(myLastName);
		me.setRole(Role.valueOf(myRole));
		me.setTechnology(Technology.valueOf(myTechnology));
		employees.add(me);
	}	
	
	@SuppressWarnings("unused")
	@PostConstruct
	private void buildEugene() {
		Employee eugene = new Employee();		
		eugene.setFirstName(eugeneFirstName);
		eugene.setLastName(eugeneLastName);
		eugene.setRole(Role.valueOf(eugeneRole));
		eugene.setTechnology(Technology.valueOf(eugeneTechnology));
		employees.add(eugene); 
	}

	@Override
	public Set<Employee> getEmployees() {
		return Collections.unmodifiableSet(employees);
	}

}
