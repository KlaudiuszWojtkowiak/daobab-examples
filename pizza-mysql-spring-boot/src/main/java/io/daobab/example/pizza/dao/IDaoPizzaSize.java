package io.daobab.example.pizza.dao;

import io.daobab.example.pizza.dao.entity.PizzaSize;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToName;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizzaSize;

public interface IDaoPizzaSize extends IDaoRelatedToName<PizzaSize>,IDaoRelatedToPizzaSize<PizzaSize>{


}
