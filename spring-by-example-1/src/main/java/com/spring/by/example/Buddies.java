package com.spring.by.example;


import static com.spring.by.example.util.EmployeeUtil.whoAmIAndMyBuddies;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.by.example.domain.Employee;

public class Buddies {	

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:context.xml");
		Employee me  = (Employee) context.getBean("me");
		Employee eugene  = (Employee) context.getBean("eugene");
		whoAmIAndMyBuddies(me);
		whoAmIAndMyBuddies(eugene);		

	}
}
