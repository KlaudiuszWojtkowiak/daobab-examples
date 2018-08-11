package io.daobab.example.pizza.daoclassic.impl.base;

import java.math.BigDecimal;
import java.util.List;

public interface IHibernateDao<E> {
	
	public List<E> findAll();
	public E findById(BigDecimal id);
	public List<E> findByProperty(String propertyName, final Object value);
	public List<E> findListByQuery(String queryString);
	public E findSingleByQuery(String queryString);
	public <F> F findFieldSingleByQuery(String queryString);
	public <F> List<F> findFieldListByQuery(String queryString);

}
