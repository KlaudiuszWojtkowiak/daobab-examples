package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToPizza;
import io.daobab.model.DaoColumn;
import io.daobab.model.DaoRelation;
import io.daobab.structure.IDao;

public interface IDaoRelatedToPizza<E extends RelatedToPizza> extends IDao<E>{
	
	@Column(name="PIZZA_ID", unique=true, nullable=false, precision=13)
	public default DaoColumn<E,Integer> colPizzaId(){
			return define("pizzaId");
		};
		
		@Column(name="PIZZA_ID", unique=true, nullable=false, precision=13)
		public default DaoRelation<E,Integer,RelatedToPizza> relPizza(){
				return new DaoRelation<>(colPizzaId(),r->r.getPizzaId());
			};

}
