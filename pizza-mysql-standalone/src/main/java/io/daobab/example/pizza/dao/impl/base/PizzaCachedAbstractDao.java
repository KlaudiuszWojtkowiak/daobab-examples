package io.daobab.example.pizza.dao.impl.base;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.daobab.annotation.DataBaseUnit;
import io.daobab.example.pizza.dao.connector.DictDataBaseUnit;
import io.daobab.structure.cache.logic.AbstractCachedDao;

public abstract class PizzaCachedAbstractDao<E> extends AbstractCachedDao<E>  {

	private static final long serialVersionUID = -3609288408352723433L;

	
	@Inject @DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE)
	private EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}


	


	
}
