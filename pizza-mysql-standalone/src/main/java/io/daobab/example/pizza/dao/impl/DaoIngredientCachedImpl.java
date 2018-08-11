package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoIngredient;
import io.daobab.example.pizza.dao.IDaoIngredientCached;
import io.daobab.example.pizza.dao.entity.Ingredient;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;
import io.daobab.example.pizza.dao.impl.base.PizzaCachedAbstractDao;

@Singleton
public class DaoIngredientCachedImpl extends PizzaCachedAbstractDao<Ingredient> implements IDaoIngredientCached{

	private static final long serialVersionUID = 1L;

}
