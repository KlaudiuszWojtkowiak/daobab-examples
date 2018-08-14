package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToDescription;
import io.daobab.model.DaoColumn;
import io.daobab.structure.IDao;

public interface IDaoRelatedToDescription<E extends RelatedToDescription> extends IDao<E>{
	
	@Column(name="DESCRIPTION")
	public default DaoColumn<E,String> colDescription(){
		return define("description");
		};

}
