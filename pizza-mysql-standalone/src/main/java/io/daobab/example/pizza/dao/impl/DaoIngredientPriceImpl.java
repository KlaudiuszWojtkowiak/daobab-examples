package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoIngredientPrice;
import io.daobab.example.pizza.dao.entity.IngredientPrice;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoIngredientPriceImpl extends PizzaAbstractDao<IngredientPrice> implements IDaoIngredientPrice{

	private static final long serialVersionUID = 1L;

}
