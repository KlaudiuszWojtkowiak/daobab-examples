package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoOrderAdditional;
import io.daobab.example.pizza.dao.entity.OrderAdditional;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoOrderAdditionalImpl extends PizzaAbstractDao<OrderAdditional> implements IDaoOrderAdditional{

	private static final long serialVersionUID = 1L;

}
