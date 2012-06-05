package com.lohika.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lohika.domain.LohikaEmployee;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class LohikaEmployeeServiceTest {

	@Resource
	private PersistenceService<LohikaEmployee, Long> lohikaEmployeeService;

	@Test
	public void testListAllEmployees() {
		List<LohikaEmployee> employees = lohikaEmployeeService.find();
		assertEquals(2, employees.size());
	}

	@Test
	public void testFindEmployee() {

		LohikaEmployee me = lohikaEmployeeService.find(1l);
		assertTrue(me.getFirstName().equals("Oleksiy"));
		assertTrue(me.getLastName().equals("Rezchykov"));
		assertTrue(me.getProject().equals("Labs"));
		assertTrue(me.getProjectMates().size() == 1);

		LohikaEmployee eugene = me.getProjectMates().iterator().next();
		assertTrue(eugene.getFirstName().equals("Eugene"));
		assertTrue(eugene.getLastName().equals("Skripnik"));
		assertTrue(eugene.getProject().equals("Labs"));
		assertTrue(eugene.getProjectMates().size() == 1);

	}

	@Test
	public void testSaveEmployee() {
		LohikaEmployee employee = new LohikaEmployee();
		employee.setFirstName("some name");
		employee.setLastName("some last name");
		employee.setProject("some project");

		Long id = lohikaEmployeeService.save(employee);
		LohikaEmployee savedEmployee = lohikaEmployeeService.find(id);
		assertTrue(savedEmployee.getFirstName().equals(employee.getFirstName()));
		assertTrue(savedEmployee.getLastName().equals(employee.getLastName()));

	}

	@Test
	public void testUpdateEmployee() {
		LohikaEmployee me = lohikaEmployeeService.find(1l);
		me.setFirstName("Alexey");
		me.setLastName("Rezchikov");
		lohikaEmployeeService.update(me);
		LohikaEmployee anotherInstanceofMe = lohikaEmployeeService.find(1l);
		assertTrue(me.getFirstName().equals(anotherInstanceofMe.getFirstName()));
		assertTrue(me.getLastName().equals(anotherInstanceofMe.getLastName()));
	}

	@Test
	public void testDeleteEmpployee() {
		LohikaEmployee me = lohikaEmployeeService.find(1l);
		lohikaEmployeeService.delete(me);
		LohikaEmployee anotherInstanceOfMe = lohikaEmployeeService.find(1l);
		assertNull(anotherInstanceOfMe);

	}

}
