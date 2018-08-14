package io.daobab.example.pizza.dao;

import io.daobab.example.pizza.dao.entity.Pizza;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToDescription;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToName;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizza;
import io.daobab.structure.cache.ICachedDataBaseDao;

public interface IDaoPizzaCached extends  ICachedDataBaseDao<Pizza>,IDaoRelatedToPizza<Pizza>,IDaoRelatedToName<Pizza>,IDaoRelatedToDescription<Pizza>{


}
