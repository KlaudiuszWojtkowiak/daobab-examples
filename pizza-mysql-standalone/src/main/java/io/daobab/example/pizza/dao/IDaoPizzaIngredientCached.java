package io.daobab.example.pizza.dao;

import io.daobab.example.pizza.dao.entity.PizzaIngredient;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToIngredient;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizza;
import io.daobab.structure.cache.ICachedDataBaseDao;

public interface IDaoPizzaIngredientCached extends ICachedDataBaseDao<PizzaIngredient>,IDaoRelatedToIngredient<PizzaIngredient>,IDaoRelatedToPizza<PizzaIngredient>{



}
