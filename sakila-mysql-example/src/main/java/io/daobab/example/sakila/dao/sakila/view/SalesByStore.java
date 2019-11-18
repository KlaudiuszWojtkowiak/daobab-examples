package io.daobab.example.sakila.dao.sakila.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.daobab.clone.EntityDuplicator;
import io.daobab.model.Column;

import io.daobab.example.sakila.dao.sakila.column.Store;
import io.daobab.example.sakila.dao.sakila.column.Manager;
import io.daobab.example.sakila.dao.sakila.column.TotalSales;

import io.daobab.model.Table;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class SalesByStore extends Table implements 
	Store<SalesByStore>,
	Manager<SalesByStore>,
	TotalSales<SalesByStore>
	
	{

	@Override
	public String getEntityName() {
		return "sales_by_store";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colStore(),
			colManager(),
			colTotalSales()

        );
	}

	@Override
	public SalesByStore clone() {
		return EntityDuplicator.cloneEntity(this);
	}
	


}