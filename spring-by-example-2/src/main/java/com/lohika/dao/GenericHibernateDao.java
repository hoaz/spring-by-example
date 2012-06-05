package com.lohika.dao;

import java.io.Serializable;

//@Repository
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDao<E, PK extends Serializable> extends AbstractGenericDaoImpl<E, PK> implements GenericDao<E, PK> {

}
