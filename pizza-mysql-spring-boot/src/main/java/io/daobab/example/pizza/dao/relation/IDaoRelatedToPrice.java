package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToPrice;
import io.daobab.model.DaoColumn;
import io.daobab.structure.IDao;

public interface IDaoRelatedToPrice<E extends RelatedToPrice> extends IDao<E>{
	
	@Column(name="PRICE", unique=true, nullable=false, precision=13)
	public default DaoColumn<E,Double> colPrice(){
			return define("price");
		};
}
