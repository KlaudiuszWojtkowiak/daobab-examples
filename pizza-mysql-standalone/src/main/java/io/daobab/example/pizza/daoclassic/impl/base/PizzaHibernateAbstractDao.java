package io.daobab.example.pizza.daoclassic.impl.base;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import io.daobab.annotation.DataBaseUnit;
import io.daobab.example.pizza.dao.connector.DictDataBaseUnit;

public abstract class PizzaHibernateAbstractDao<E>  implements IHibernateDao<E>{

	protected Logger log=Logger.getLogger(this.getClass().getSimpleName());

	
	@Inject @DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE)
	private EntityManager em;
	
	private Class<E> clazz;
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	@SuppressWarnings("unchecked")
	public Class<E> getClazz(){
		if (clazz==null){
			clazz=((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		}
		return clazz;
	}
	
	public String getClassName() {
		return getClazz().getSimpleName();
	}

	
	@Override
	public E findById(BigDecimal id) {
		try {
			E instance = getEntityManager().find(getClazz(), id);
			return instance;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "find failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> findByProperty(String propertyName, final Object value) {
		try {
			final String queryString = "select model from "+getClassName()+" model where model." + propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			List<E> result=query.getResultList();
			return result;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE,"find by property name failed", re);
			throw re;
		}
	}
	
	@Override
	public List<E> findListByQuery(String queryString) {
		try {
			Query query = getEntityManager().createQuery(queryString);
			@SuppressWarnings("unchecked")
			List<E> result=query.getResultList();
			return result;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE,"find by property name failed", re);
			throw re;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public E findSingleByQuery(String queryString) {
		try {
			Query query = getEntityManager().createQuery(queryString);
			return (E)query.getSingleResult();
		} catch (RuntimeException re) {
			log.log(Level.SEVERE,"find by property name failed", re);
			throw re;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <F> F findFieldSingleByQuery(String queryString) {
		try {
			Query query = getEntityManager().createQuery(queryString);
			return (F)query.getSingleResult();
		} catch (RuntimeException re) {
			log.log(Level.SEVERE,"find by property name failed", re);
			throw re;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <F> List<F> findFieldListByQuery(String queryString) {
		try {
			Query query = getEntityManager().createQuery(queryString);
			return (List<F>)query.getResultList();
		} catch (RuntimeException re) {
			log.log(Level.SEVERE,"find by property name failed", re);
			throw re;
		}
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		try {
			final String queryString = "select model from "+getClassName()+" model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "find all failed", re);
			throw re;
		}
	}


	
}
