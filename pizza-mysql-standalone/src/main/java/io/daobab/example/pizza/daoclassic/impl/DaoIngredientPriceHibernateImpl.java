package io.daobab.example.pizza.daoclassic.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.daoclassic.IDaoIngredientPriceHibernate;
import io.daobab.example.pizza.daoclassic.entity.IngredientPriceHibernate;
import io.daobab.example.pizza.daoclassic.impl.base.PizzaHibernateAbstractDao;

@Singleton
public class DaoIngredientPriceHibernateImpl extends PizzaHibernateAbstractDao<IngredientPriceHibernate> implements IDaoIngredientPriceHibernate{

	private static final long serialVersionUID = 1L;
	

}
