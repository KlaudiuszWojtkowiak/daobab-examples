package io.daobab.example.pizza.dao;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.PizzaPrice;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizza;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizzaSize;
import io.daobab.model.DaoColumn;

public interface IDaoPizzaPrice extends IDaoRelatedToPizza<PizzaPrice>,IDaoRelatedToPizzaSize<PizzaPrice>{

	@Column(name="PRICE", unique=true, nullable=false, precision=13)
	public default DaoColumn<PizzaPrice,Double> colPrice(){
			return define("price");
		};

}
