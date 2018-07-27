package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToOrderPizza;
import io.daobab.model.DaoColumn;
import io.daobab.structure.IDao;

public interface IDaoRelatedToOrderPizza<E extends RelatedToOrderPizza> extends IDao<E>{
	
	@Column(name="ORDER_PIZZA_ID", unique=true, nullable=false, precision=13)
	public default DaoColumn<E,Integer> colOrderPizzaId(){
			return define("orderPizzaId");
		};

}
