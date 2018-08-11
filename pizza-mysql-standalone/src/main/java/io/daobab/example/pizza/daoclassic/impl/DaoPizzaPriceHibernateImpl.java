package io.daobab.example.pizza.daoclassic.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.daoclassic.IDaoPizzaPriceHibernate;
import io.daobab.example.pizza.daoclassic.entity.PizzaPriceHibernate;
import io.daobab.example.pizza.daoclassic.impl.base.PizzaHibernateAbstractDao;

@Singleton
public class DaoPizzaPriceHibernateImpl extends PizzaHibernateAbstractDao<PizzaPriceHibernate> implements IDaoPizzaPriceHibernate{

	private static final long serialVersionUID = 1L;

}
