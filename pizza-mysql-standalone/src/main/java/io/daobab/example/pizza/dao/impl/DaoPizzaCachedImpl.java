package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.IDaoPizzaCached;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;
import io.daobab.example.pizza.dao.impl.base.PizzaCachedAbstractDao;

@Singleton
public class DaoPizzaCachedImpl extends PizzaCachedAbstractDao<Pizza> implements IDaoPizzaCached{

	private static final long serialVersionUID = 1L;

}
