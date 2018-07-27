package io.daobab.example.pizza.dao.relation;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToName;
import io.daobab.model.DaoColumn;
import io.daobab.structure.IDao;

public interface IDaoRelatedToName<E extends RelatedToName> extends IDao<E>{
	
	@Column(name="NAME")
	public default DaoColumn<E,String> colName(){
		return define("name");
	};
		

}
