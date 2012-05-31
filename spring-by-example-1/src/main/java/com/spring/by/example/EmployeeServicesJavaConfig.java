package com.spring.by.example;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Position;
import com.spring.by.example.ds.EmployeeDS;
import com.spring.by.example.service.AnotherEmployeeService;
import com.spring.by.example.service.AnotherEmployeeServiceImpl;

@PropertySource("file:src/main/resources/employee.properties")
@Configuration
public class EmployeeServicesJavaConfig {

	@Autowired
	private Environment environment;

	@Bean
	public EmployeeDS employeeDS() {
		return new EmployeeDS() {
			@Override
			public Set<Employee> getEmployees() {
				Set<Employee> result = new HashSet<Employee>();
				Employee me = new Employee();
				me.setFirstName(environment.getProperty("me.firstName"));
				me.setLastName(environment.getProperty("me.lastName"));
				me.setPosition(Position.valueOf(environment.getProperty("me.position")));
				result.add(me);
				Employee eugene = new Employee();
				eugene.setFirstName(environment.getProperty("eugene.firstName"));
				eugene.setLastName(environment.getProperty("eugene.lastName"));
				eugene.setPosition(Position.valueOf(environment.getProperty("eugene.position")));
				result.add(eugene);
				return result;
			}
		};
	}

	@Bean
	public AnotherEmployeeService anotherEmployeeService() {
		AnotherEmployeeServiceImpl result = new AnotherEmployeeServiceImpl();
		result.setEmployeeDS(employeeDS());
		return result;
	}

}
