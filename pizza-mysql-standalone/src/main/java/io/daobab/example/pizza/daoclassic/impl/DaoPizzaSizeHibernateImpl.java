package io.daobab.example.pizza.daoclassic.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.daoclassic.IDaoPizzaSizeHibernate;
import io.daobab.example.pizza.daoclassic.entity.PizzaSizeHibernate;
import io.daobab.example.pizza.daoclassic.impl.base.PizzaHibernateAbstractDao;

@Singleton
public class DaoPizzaSizeHibernateImpl extends PizzaHibernateAbstractDao<PizzaSizeHibernate> implements IDaoPizzaSizeHibernate{

	private static final long serialVersionUID = 1L;


}
