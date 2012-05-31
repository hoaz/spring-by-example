package com.spring.by.example.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.by.example.dao.EmployeeDao;
import com.spring.by.example.domain.Employee;
import com.spring.by.example.domain.Role;

@ContextConfiguration("classpath*:jdbc-test.xml")
@Profile("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTest {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void testDaoUseCases() {
		Employee me = employeeDao.find(Long.valueOf(1l));

		Employee eugene = employeeDao.find(Long.valueOf(2l));

		assertTrue(me.getFirstName().equals("Oleksiy"));
		assertTrue(me.getLastName().equals("Rezchykov"));

		assertTrue(eugene.getFirstName().equals("Eugene"));
		assertTrue(eugene.getLastName().equals("Skripnik"));

		assertTrue(me.getRole() == Role.TL);

		// demote Alex back to DEV
		me.setRole(Role.DEV);
		employeeDao.update(me);

		Employee anotherInstanceOfMe = employeeDao.find(Long.valueOf(1l));

		assertTrue(anotherInstanceOfMe.getRole() == Role.DEV);

	}

}
