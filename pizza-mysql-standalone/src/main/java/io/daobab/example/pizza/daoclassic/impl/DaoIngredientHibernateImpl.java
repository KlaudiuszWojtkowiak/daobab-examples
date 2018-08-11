package io.daobab.example.pizza.daoclassic.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.daoclassic.IDaoIngredientHibernate;
import io.daobab.example.pizza.daoclassic.entity.IngredientHibernate;
import io.daobab.example.pizza.daoclassic.impl.base.PizzaHibernateAbstractDao;

@Singleton
public class DaoIngredientHibernateImpl extends PizzaHibernateAbstractDao<IngredientHibernate> implements IDaoIngredientHibernate{

	private static final long serialVersionUID = 1L;
	


}
