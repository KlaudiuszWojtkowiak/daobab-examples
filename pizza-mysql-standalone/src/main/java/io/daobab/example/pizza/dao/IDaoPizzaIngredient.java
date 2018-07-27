package io.daobab.example.pizza.dao;

import io.daobab.example.pizza.dao.entity.PizzaIngredient;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToIngredient;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizza;

public interface IDaoPizzaIngredient extends IDaoRelatedToIngredient<PizzaIngredient>,IDaoRelatedToPizza<PizzaIngredient>{



}
