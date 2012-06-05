package com.spring.by.example.dao;

import java.io.Serializable;

//@Repository
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<E, PK extends Serializable> extends AbstractGenericDaoImpl<E, PK> implements GenericDao<E, PK> {

}
