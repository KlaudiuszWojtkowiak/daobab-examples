package io.daobab.example.pizza.dao;

import io.daobab.example.pizza.dao.entity.IngredientPrice;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToIngredient;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizzaSize;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPrice;

public interface IDaoIngredientPrice extends IDaoRelatedToIngredient<IngredientPrice>,IDaoRelatedToPizzaSize<IngredientPrice>,IDaoRelatedToPrice<IngredientPrice>{



}
