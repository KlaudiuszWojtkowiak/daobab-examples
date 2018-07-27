package io.daobab.example.pizza.dao;

import java.util.Date;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.OrderPizza;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToCustomer;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToInsertDate;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizza;
import io.daobab.example.pizza.dao.relation.IDaoRelatedToPizzaSize;
import io.daobab.model.DaoColumn;

public interface IDaoOrderPizza extends IDaoRelatedToPizza<OrderPizza>,IDaoRelatedToPizzaSize<OrderPizza>,IDaoRelatedToCustomer<OrderPizza>,IDaoRelatedToInsertDate<OrderPizza>{


	@Column(name="ORDER_PIZZA_ID")
	public default DaoColumn<OrderPizza,Integer> colOrderPizzaId(){
			return define("orderPizzaId");
		};
	
	@Column(name="DELIVER_DATE")
	public default DaoColumn<OrderPizza,Date> colDeliverDate(){
			return define("deliverDate");
		};
		
		
	
	@Column(name="PRICE")
	public default DaoColumn<OrderPizza,Double> colPrice(){
			return define("price");
		};
}
