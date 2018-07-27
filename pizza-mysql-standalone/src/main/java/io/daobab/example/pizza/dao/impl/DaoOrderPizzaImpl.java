package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoOrderPizza;
import io.daobab.example.pizza.dao.entity.OrderPizza;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoOrderPizzaImpl extends PizzaAbstractDao<OrderPizza> implements IDaoOrderPizza{

	private static final long serialVersionUID = 1L;

}
