package io.daobab.example.pizza.dao.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.annotation.DataBaseUnit;
import io.daobab.example.pizza.dao.IDaoPizzaIngredientCached;
import io.daobab.example.pizza.dao.connector.DictDataBaseUnit;
import io.daobab.example.pizza.dao.entity.PizzaIngredient;
import io.daobab.springjpa.AbstractSpringCachedDao;

@DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE)
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DaoPizzaIngredientCachedImpl extends AbstractSpringCachedDao<PizzaIngredient> implements IDaoPizzaIngredientCached{

	private static final long serialVersionUID = 1L;

	

}
