package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoPizza;
import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoPizzaImpl extends PizzaAbstractDao<Pizza> implements IDaoPizza{

	private static final long serialVersionUID = 1L;

}
