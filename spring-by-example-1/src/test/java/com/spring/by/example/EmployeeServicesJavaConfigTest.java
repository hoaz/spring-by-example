package com.spring.by.example;

import static com.spring.by.example.util.EmployeeUtil.whoAmI;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Position;
import com.spring.by.example.service.AnotherEmployeeService;

@ContextConfiguration(classes = EmployeeServicesJavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServicesJavaConfigTest {

	@Autowired AnotherEmployeeService anotherEmployeeService;

	@Test
	public void outputWhoAmI() {
		Set<Employee> candidates = anotherEmployeeService.getEmployeeListByPosition(Position.SENIOR);
		assertEquals(2, candidates.size());

		for (Employee employee : candidates) {
			whoAmI(employee);
		}
	}

}
