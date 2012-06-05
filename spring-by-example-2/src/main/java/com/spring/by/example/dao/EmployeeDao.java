package com.spring.by.example.dao;

import org.springframework.stereotype.Repository;

import com.spring.by.example.domain.Employee;

@Repository
public class EmployeeDao extends AbstractGenericDaoImpl<Employee, Long> {

}
