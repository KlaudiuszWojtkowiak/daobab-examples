package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoPizzaSize;
import io.daobab.example.pizza.dao.entity.PizzaSize;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoPizzaSizeImpl extends PizzaAbstractDao<PizzaSize> implements IDaoPizzaSize{

	private static final long serialVersionUID = 1L;

}
