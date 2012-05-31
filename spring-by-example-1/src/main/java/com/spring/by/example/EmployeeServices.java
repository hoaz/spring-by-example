package com.spring.by.example;

import static com.spring.by.example.util.EmployeeUtil.whoAmI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Role;
import com.spring.by.example.domain.Technology;
import com.spring.by.example.service.EmployeeService;

public class EmployeeServices {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:annotationContext.xml");
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		for (Employee employee : employeeService.getEmployeeListByRoleAndTechology(Role.DEV, Technology.JAVA)) {
			whoAmI(employee);
		}
	}

}
