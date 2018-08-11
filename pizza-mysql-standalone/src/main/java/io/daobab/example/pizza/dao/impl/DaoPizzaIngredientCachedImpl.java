package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoPizzaIngredientCached;
import io.daobab.example.pizza.dao.entity.PizzaIngredient;
import io.daobab.example.pizza.dao.impl.base.PizzaCachedAbstractDao;

@Singleton
public class DaoPizzaIngredientCachedImpl extends PizzaCachedAbstractDao<PizzaIngredient> implements IDaoPizzaIngredientCached{

	private static final long serialVersionUID = 1L;

	

}
