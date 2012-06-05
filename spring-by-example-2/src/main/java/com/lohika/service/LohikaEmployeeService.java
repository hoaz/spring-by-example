package com.lohika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lohika.dao.GenericDao;
import com.lohika.domain.LohikaEmployee;

@Service("lohikaEmployeeService")
public class LohikaEmployeeService extends AbtractPersistenceService<LohikaEmployee, Long> {

	@Autowired
	private GenericDao<LohikaEmployee, Long> lohikaEmployeeDao;

	@Override
	protected GenericDao<LohikaEmployee, Long> getDomainDAO() {
		return lohikaEmployeeDao;
	}

}
