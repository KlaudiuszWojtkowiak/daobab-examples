package io.daobab.example.pizza.dao.impl;

import javax.inject.Singleton;

import io.daobab.example.pizza.dao.IDaoPizzaPrice;
import io.daobab.example.pizza.dao.entity.PizzaPrice;
import io.daobab.example.pizza.dao.impl.base.PizzaAbstractDao;

@Singleton
public class DaoPizzaPriceImpl extends PizzaAbstractDao<PizzaPrice> implements IDaoPizzaPrice{

	private static final long serialVersionUID = 1L;

}
