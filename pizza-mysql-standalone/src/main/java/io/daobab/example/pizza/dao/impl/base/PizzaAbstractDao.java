package io.daobab.example.pizza.dao.impl.base;

import java.util.function.Supplier;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.daobab.annotation.DataBaseUnit;
import io.daobab.example.pizza.dao.connector.DictDataBaseUnit;
import io.daobab.exception.DaobabRollbackException;
import io.daobab.structure.base.DaoQueryHandler;
import io.daobab.structure.logic.AbstractDao;

public class PizzaAbstractDao<E> extends AbstractDao<E> implements DaoQueryHandler{

	private static final long serialVersionUID = -3609288408352723433L;
	
	private Logger log=Logger.getLogger(this.getClass().getSimpleName());

	
	@Inject @DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE)
	private EntityManager em;
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
	
	
	@Override
	public DaoQueryHandler getDaoQueryHandler() {
		return this;
	}
	
	


	@Override
	public void handleQuery(String query) {
		log.info("DB ------->    "+query);
	}


	@Override
	public <T> T aroundTransaction(Supplier<T> t) {
		return aroundJEETransaction(t);
	}
	
}
