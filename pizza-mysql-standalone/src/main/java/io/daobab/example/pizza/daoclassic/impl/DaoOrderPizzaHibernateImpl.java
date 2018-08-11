package io.daobab.example.pizza.daoclassic.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.daoclassic.IDaoOrderPizzaHibernate;
import io.daobab.example.pizza.daoclassic.entity.OrderPizzaHibernate;
import io.daobab.example.pizza.daoclassic.impl.base.PizzaHibernateAbstractDao;

@Singleton
public class DaoOrderPizzaHibernateImpl extends PizzaHibernateAbstractDao<OrderPizzaHibernate> implements IDaoOrderPizzaHibernate{

	private static final long serialVersionUID = 1L;


	
}
