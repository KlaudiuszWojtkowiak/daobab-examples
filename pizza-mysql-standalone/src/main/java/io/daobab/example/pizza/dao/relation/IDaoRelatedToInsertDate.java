package io.daobab.example.pizza.dao.relation;

import java.util.Date;

import javax.persistence.Column;

import io.daobab.example.pizza.dao.entity.relation.RelatedToInsertDate;
import io.daobab.model.DaoColumn;
import io.daobab.structure.IDao;

public interface IDaoRelatedToInsertDate<E extends RelatedToInsertDate> extends IDao<E>{
	
	@Column(name="INSERT_DATE")
	public default DaoColumn<E,Date> colInsertDate(){
			return define("insertDate");
		};
}
