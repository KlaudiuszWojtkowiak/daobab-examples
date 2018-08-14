package io.daobab.example.pizza.dao.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.daobab.annotation.DataBaseUnit;
import io.daobab.example.pizza.dao.IDaoIngredientPrice;
import io.daobab.example.pizza.dao.connector.DictDataBaseUnit;
import io.daobab.example.pizza.dao.entity.IngredientPrice;
import io.daobab.springjpa.AbstractSpringDao;

@DataBaseUnit(DictDataBaseUnit.PIZZA_DATABASE)
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DaoIngredientPriceImpl extends AbstractSpringDao<IngredientPrice> implements IDaoIngredientPrice{

	private static final long serialVersionUID = 1L;

}
