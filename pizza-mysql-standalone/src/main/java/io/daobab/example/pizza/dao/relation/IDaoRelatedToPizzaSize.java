package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToPizzaSize;
import io.daobab.model.DaoColumn;
import io.daobab.model.DaoRelation;
import io.daobab.structure.IDao;

public interface IDaoRelatedToPizzaSize<E extends RelatedToPizzaSize> extends IDao<E>{
	
	@Column(name="PIZZA_SIZE_ID", unique=true, nullable=false, precision=13)
	public default DaoColumn<E,Integer> colPizzaSizeId(){
			return define("pizzaSizeId");
		};
		
		@Column(name="PIZZA_ID", unique=true, nullable=false, precision=13)
		public default DaoRelation<E,Integer,RelatedToPizzaSize> relPizzaSize(){
				return new DaoRelation<>(colPizzaSizeId(),r->r.getPizzaSizeId());
			};

}
