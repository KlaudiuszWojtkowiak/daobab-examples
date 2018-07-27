package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToCustomer;
import io.daobab.model.DaoColumn;
import io.daobab.model.DaoRelation;
import io.daobab.structure.IDao;

public interface IDaoRelatedToCustomer<E extends RelatedToCustomer> extends IDao<E>{
	
	@Column(name="CUSTOMER_ID", unique=true, nullable=false, precision=13)
	public default DaoColumn<E,Integer> colCustomerId(){
			return define("customerId");
		};
		
		@Column(name="CUSTOMER_ID", unique=true, nullable=false, precision=13)
		public default DaoRelation<E,Integer,RelatedToCustomer> relCustomer(){
				return new DaoRelation<>(colCustomerId(),r->r.getCustomerId());
			};

}
