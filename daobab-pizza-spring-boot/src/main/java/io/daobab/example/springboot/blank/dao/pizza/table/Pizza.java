package io.daobab.example.springboot.blank.dao.pizza.table;

import io.daobab.example.springboot.blank.dao.pizza.column.*;
import io.daobab.model.Column;
import io.daobab.model.PrimaryKey;
import io.daobab.model.Table;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


public class Pizza extends Table implements
	PizzaId<Pizza>,
	Name<Pizza>,
	Description<Pizza>,

        PrimaryKey<Pizza, BigDecimal,PizzaId>
	{

	@Override
	public String getEntityName() {
		return "pizza";
	}

	@Override
    public List<Column<?,?,?>> columns() {
        return Arrays.asList(
			colPizzaId(),
			colName(),
			colDescription()

        );
	}

	@Override
	public Column<Pizza, BigDecimal,PizzaId> colID() {
		return colPizzaId();
	}



}
