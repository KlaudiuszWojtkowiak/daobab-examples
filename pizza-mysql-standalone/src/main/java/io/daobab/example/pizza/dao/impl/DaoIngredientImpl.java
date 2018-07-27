package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoIngredient;
import io.daobab.example.pizza.dao.entity.Ingredient;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoIngredientImpl extends PizzaAbstractDao<Ingredient> implements IDaoIngredient{

	private static final long serialVersionUID = 1L;

}
